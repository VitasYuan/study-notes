package com.example.validator;

import com.example.validator.validator.TestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorApplicationTests {

	@Autowired
	private TestValidator validator;

	@Test
	public void contextLoads() {
		validator.validator();
	}

}
