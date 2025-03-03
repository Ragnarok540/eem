package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public final class File {
    private String path;

    public File(final String path) {
        this.path = path;
    }

    public void encrypt(final String outPath,
                        final String password) {
        // encrypt file
    }

    public byte[] digest(final String algorithm) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm); // SHA3-512 (64 bytes)
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(this.path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int inputSize = 1024;
        byte[] dataBytes = new byte[inputSize];
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
}
