package com.example.validator.model;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * @author weipeng_yuan
 * @date 2019-12-16 10:58
 */
@ScriptAssert.List(value = {
        //年龄长度大于length长度
//        @ScriptAssert(lang = "javascript", script = "!org.springframework.util.StringUtils.isEmpty(_this.age)",message = "不能为空"),
        //年龄长度大于length长度
        @ScriptAssert(lang = "javascript", script = "com.example.validator.model.ScriptTest.checkSpbm(_this)",message = "scriptTest11")
})
public class ScriptTest {

    /**
     * 商品编码为空时，商品编码简称也必需为空
     */
    public static boolean checkSpbm(String spbmAbb, String spbm) {
        System.out.println("spbm:" + spbm + "spbmabb:" + spbmAbb);
        if(StringUtils.isNotBlank(spbmAbb)&&StringUtils.isBlank(spbm)){
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }

    public static boolean checkSpbm(Demo2 demo2) {
        System.out.println(demo2);
        return true;
    }


}
