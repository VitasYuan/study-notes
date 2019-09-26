package com.example.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboApplicationTests {

    @Test
    public void contextLoads() {
        String param = "硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼1234567890";
        System.out.println("硼".length());
        System.out.println(param.length());
        boolean result = checkLength("硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼硼铁硼铁硼1234567890", 90);
        System.out.println(result);
    }

    private boolean checkLength(String value,int length){
        if(value.length()>length){
            return true;
        }
        return false;
    }

}
