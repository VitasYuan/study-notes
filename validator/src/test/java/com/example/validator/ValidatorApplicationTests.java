package com.example.validator;

import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		Map<String, String> ofdGeneratorParam = new HashMap<>();
		ofdGeneratorParam.put("invoiceInfo", "invoiceInfo");
		ofdGeneratorParam.put("templateId", "01");
		ofdGeneratorParam.put("areaCode", "5000");

		byte[] fileByte = restTemplate.postForObject("http://127.0.0.1:8080/suwell/generate-ofd?invoiceInfo=dsds&templateId=123&areaCode=123", JSONObject.toJSONString(ofdGeneratorParam), byte[].class);
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {

			file = new File("test.yml");
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(fileByte);
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
