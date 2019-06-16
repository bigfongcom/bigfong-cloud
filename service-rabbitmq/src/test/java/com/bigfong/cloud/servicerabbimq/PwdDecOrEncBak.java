package com.bigfong.cloud.servicerabbimq;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PwdDecOrEncBak {
	@Test
	public void decrypt() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setPassword("l&id81!lw");
		encryptor.setConfig(config);
		String ciphertext = "Ws7Ezzk6jfM/pZ3UlUmNFt/hyBEQ8zDZ";// 密文
//		String name = encryptor.encrypt("ebuy");huangshi
//		String password = encryptor.encrypt("123456");huangshi@321
		String name = encryptor.encrypt("huangshi");
		String password = encryptor.encrypt("huangshi@321");

		//解密
//		String mdName =encryptor.decrypt("LtcG3xB87zaxyM4ddTCZUg==");
//		String mdPassword =encryptor.decrypt("xIJQ9OWQeDfsnk6i25uPSg==");
		String mdName =encryptor.decrypt("s8hdqGJLniVNDnkkxTOsed/nkm/WjOwl");
		String mdPassword =encryptor.decrypt("tblZL3MXn9zo6xIsqBKU5FB/MdWppsWV");
		System.out.println(name+"----------------"+mdName);
		System.out.println(password+"----------------"+mdPassword);
		String plaintext = encryptor.decrypt(ciphertext); // 解密
		System.out.println(ciphertext + " : " + plaintext);// 运行结果：8y9G4kIZQuCHB78mMJNkHw== : root
	}
	public static void main(String[] args) {
		new PwdDecOrEncBak().decrypt();
	}
}