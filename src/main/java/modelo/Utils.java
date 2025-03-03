package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class Utils {
    private Utils() { }

    private final static byte[] MAGIC = new byte[] {0x06, 0x06, 0x06, 0x06};

    /**
     * Genera un Cipher.
     * Este metodo toma como parametros un SecretKey,
     * un modo y un IvParameterSpec para crear un
     * Cipher para el algoritmo AES, en modo CBC.
     * @param mode Indica si debe encriptar (true) o si debe desencriptar
     * (false)
     * @param sk   SecretKey generado con un password y una sal
     * @param ips  Especifica el vector de inicializacion. Debe ser null
     * si el modo es encriptar.
     * @return     El Cipher
     * */
    public static Cipher getCipherAES(final boolean mode,
                                      final SecretKey sk,
                                      final IvParameterSpec ips) {
        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        try {
            if (mode) {
                cipher.init(Cipher.ENCRYPT_MODE, sk);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, sk, ips);
            }
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return cipher;
    }

    /**
     * Genera un SecretKey con el algoritmo AES a 128 bits.
     * Este metodo toma como parametros un password o
     * passphrase junto con una sal criptografica y genera un
     * SecretKey de manera segura.
     * @param pw   Password o passphrase
     * @param salt Sal criptografica
     * @return     El SecretKey
     * */
    public static SecretKey getSecretKeyAES128(final String pw,
                                               final byte[] salt) {
        PBEKeySpec password = new PBEKeySpec(pw.toCharArray(), salt, 1000, 128);
        SecretKeyFactory factory = null;

        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        PBEKey key = null;

        try {
            key = (PBEKey) factory.generateSecret(password);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        SecretKey encKey = new SecretKeySpec(key.getEncoded(), "AES");
        return encKey;
    }

    /**
     * Genera una sal criptografica.
     * Este metodo utiliza la clase SecureRandom para generar
     * una sal de manera segura. La longitud de la sal es de
     * 16 bits.
     * Ver <a href="http://en.wikipedia.org/wiki/Salt_%28cryptography%29">
     * Salt (cryptography)</a>.
     * @return La sal criptografica
     * */
    public static byte[] getSalt() {
        SecureRandom rand = null;

        try {
            rand = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] salt = new byte[16];
        rand.nextBytes(salt);
        return salt;
    }

    /**
     * @deprecated File.digest
     * Este metodo genera el hash SHA-1 de un archivo cualquiera,
     * utilizando la clase MessageDigest.
     * @param path El path del archivo del cual se quiere calcular el SHA-1
     * @return El hash SHA-1 del archivo
     * */
    public static byte[] SHA1(final String path) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] dataBytes = new byte[1024];
        int nread = 0;

        try {
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        byte[] mdbytes = md.digest();
        return mdbytes;
    }

    /**
     * Metodo para convertir un arreglo de bytes en su representacion
     * hexadecimal en una cadena.
     * @param data El arreglo de bytes
     * @return La cadena
     * */
    public static String bytesToHex(final byte[] data) {
        if (data == null) {
            return null;
        } else {
            int len = data.length;
            String str = "";

            for (int i = 0; i < len; i++) {
                if ((data[i] & 0xFF) < 16) {
                    str = str + "0" + Integer.toHexString(data[i] & 0xFF);
                } else {
                    str = str + Integer.toHexString(data[i] & 0xFF);
                }
            }

            return str.toUpperCase();
        }
    }

    /**
     * Metodo para convertir una cadena hexadecimal en su representacion
     * en arreglo de bytes.
     * @param str La cadena
     * @return El arreglo de bytes
     * */
    public static byte[] hexToBytes(final String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];

            for (int i = 0; i < len; i++) {
                String integer = str.substring(i * 2, i * 2 + 2);
                buffer[i] = (byte) Integer.parseInt(integer, 16);
            }

            return buffer;
        }
    }

    public static boolean checkMagic(final byte[] magic) {
        return bytesToHex(magic).equals(bytesToHex(MAGIC));
    }

}
