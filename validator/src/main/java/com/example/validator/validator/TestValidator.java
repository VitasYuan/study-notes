package com.example.validator.validator;

import com.example.validator.model.Demo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author weipeng_yuan
 * @date 2019-08-26 16:01
 */
@Service
public class TestValidator {

    @Autowired
    private Validator validator;

    public void validator() {
        Demo2 demo2 = new Demo2();
        demo2.setAge("123");
        demo2.setHigh(150);
        demo2.setLength("122");
        demo2.setDoubleValue("123.12ds2");
        demo2.setList(new ArrayList<String>(){{add("111");add("222");add("333");}});

        Set<ConstraintViolation<Demo2>> violationSet = validator.validate(demo2);

        for (ConstraintViolation<Demo2> model : violationSet) {
            System.out.println(model.getMessage());
        }
    }


}
