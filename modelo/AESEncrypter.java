/*
 * Copyright 2012 NovaSoft.
 *
 * Licensed under the zlib License, Version 1.2.7 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://zlib.net/zlib_license.html
 * 
 * Edgar Nova
 * ragnarok540@gmail.com
 * 
 */

package modelo;

import java.io.*;
import javax.crypto.*;

public class AESEncrypter {

	/**
	 * Encripta un archivo.
	 * 
	 * Este método se encarga de encriptar un archivo
	 * usando una contraseña. El archivo encriptado incluye
	 * un identificador, el vector de inicializacion, la
	 * sal criptográfica, asi como los datos encriptados.
	 * 
	 * @param in       Archivo de entrada
	 * @param out      Archivo de salida
	 * @param sha1     Hash SHA-1 del archivo original
	 * @param password Contraseña usuada para generar la clave
	 * */
	private static void encryptFile(InputStream in, OutputStream out, byte[] sha1, String password) {
		byte[] buf = new byte[1024];
		byte[] salt = Utils.getSalt();
		SecretKey sk = Utils.getSecretKeyAES128(password, salt);
		Cipher cipher = Utils.getCipherAES(true, sk, null);
		byte[] iv = cipher.getIV();
		try {
			out.write(new byte[] { 0x06, 0x06, 0x06, 0x06 }); // 4 bytes
			out.write(iv); // 16 bytes
			out.write(salt); // 16 bytes
			out.write(sha1); // 20 bytes
			out = new CipherOutputStream(out, cipher);
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) {
				out.write(buf, 0, numRead);
			}
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Encripta un archivo.
	 * 
	 * Ver {@link #encryptFile(InputStream, OutputStream, byte[], String)}
	 * 
	 * @param in       Path del archivo de entrada
	 * @param out      Path del archivo de salida
	 * @param password Contraseña usuada para generar la clave
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