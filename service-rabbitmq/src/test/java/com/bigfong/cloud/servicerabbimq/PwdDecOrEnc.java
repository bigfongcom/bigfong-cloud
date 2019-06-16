package com.bigfong.cloud.servicerabbimq;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PwdDecOrEnc {
	@Test
	public void decrypt() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setPassword("");
		encryptor.setConfig(config);

		String name = "root";
		String password = "";

		String nameEnc = encryptor.encrypt(name);
		String passwordEnc = encryptor.encrypt(password);

		System.out.println(name+"----------------"+nameEnc);
		System.out.println(password+"----------------"+passwordEnc);

		/*Properties properties = System.getProperties();
		Iterator it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			System.out.print(entry.getKey() + "=");
			System.out.println(entry.getValue());

		}*/

	}
	public static void main(String[] args) {
		new  PwdDecOrEnc().decrypt();
	}
}