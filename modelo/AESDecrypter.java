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
import javax.crypto.spec.*;
import java.util.*;

public class AESDecrypter {
	
	/**
	 * Desencripta un archivo.
	 * 
	 * Este método se encarga de desencriptar un archivo
	 * usando una contraseña. Si la contraseña es correcta
	 * el resultado es el archivo original.
	 * 
	 * @param in       Archivo de entrada
	 * @param out      Archivo de salida
	 * @param password Contraseña usada para generar la clave
	 * @return         Hash SHA-1 que estaba guardado junto con el archivo encriptado
	 * @throws NotEncryptedException Si el archivo de entrada no esta encriptado (Cuando no cominenza con 0x06060606)
	 * */
	private static byte[] decryptFile(InputStream in, OutputStream out, String password) throws NotEncryptedException { 
		byte[] buf = new byte[1024];
		byte[] sha1 = null;
		try {
			in.read(buf, 0, 4);
			byte[] magic = Arrays.copyOf(buf, 4);
			if (!Utils.bytesToHex(magic).equals(Utils.bytesToHex(new byte[] { 0x06, 0x06, 0x06, 0x06 }))) throw new NotEncryptedException();
			in.read(buf, 0, 16);
			byte[] iv = Arrays.copyOf(buf, 16);
			in.read(buf, 0, 16);
			byte[] salt = Arrays.copyOf(buf, 16);
			in.read(buf, 0, 20);
			sha1 = Arrays.copyOf(buf, 20);
			IvParameterSpec ips = new IvParameterSpec(iv);
			SecretKey sk = Utils.getSecretKeyAES128(password, salt);
			Cipher dcipher = Utils.getCipherAES(false, sk, ips); 
			in = new CipherInputStream(in, dcipher);
			int numRead = 0;
			while ((numRead = in.read(buf)) >= 0) {
				out.write(buf, 0, numRead);
			}
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return sha1;
	}
	
	/**
	 * Desencripta un archivo.
	 * 
	 * Ver {@link #decryptFile(InputStream, OutputStream, String)}
	 * 
	 * @param in       Path del archivo de entrada
	 * @param out      Path del archivo de salida
	 * @param password Contraseña usada para generar la clave
	 * @return         Hash SHA-1 que estaba guardado junto con el archivo encriptado
	 * @throws NotEncryptedException Si el archivo de entrada no esta encriptado (Cuando no cominenza con 0x06060606)
	 * */
	public static byte[] decryptFile(String in, String out, String password) throws NotEncryptedException {
		try {
			return decryptFile(new FileInputStream(in), new FileOutputStream(out), password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
