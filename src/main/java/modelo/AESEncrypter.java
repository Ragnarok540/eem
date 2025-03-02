package modelo;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;

public class AESEncrypter {

    /**
     * Encripta un archivo.
     * 
     * Este metodo se encarga de encriptar un archivo
     * usando una contrasena. El archivo encriptado incluye
     * un identificador, el vector de inicializacion, la
     * sal criptografica, asi como los datos encriptados.
     * 
     * @param in       Archivo de entrada
     * @param out      Archivo de salida
     * @param sha1     Hash SHA-1 del archivo original
     * @param password Contrasena usuada para generar la clave
     * */
    private static void encryptFile(InputStream in, OutputStream out, byte[] sha1, String password) {
        byte[] buf = new byte[1024];
        byte[] salt = Utils.getSalt();
        SecretKey sk = Utils.getSecretKeyAES128(password, salt);
        Cipher cipher = Utils.getCipherAES(true, sk, null);
        byte[] iv = cipher.getIV();

        try {
            out.write(new byte[] {0x06, 0x06, 0x06, 0x06}); // 4 bytes
            out.write(iv); // 16 bytes
            out.write(salt); // 16 bytes
            out.write(sha1); // 20 bytes
            out = new CipherOutputStream(out, cipher);
            int numRead = 0;

            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Encripta un archivo.
     * 
     * Ver {@link #encryptFile(InputStream, OutputStream, byte[], String)}
     * 
     * @param in       Path del archivo de entrada
     * @param out      Path del archivo de salida
     * @param password Contrasena usuada para generar la clave
     * */
    public static void encryptFile(String in, String out, String password) {
        byte[] sha1 = Utils.SHA1(in);

        try {
            encryptFile(new FileInputStream(in), new FileOutputStream(out), sha1, password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
