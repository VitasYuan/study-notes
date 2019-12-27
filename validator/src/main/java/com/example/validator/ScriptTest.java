package com.example.validator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author weipeng_yuan
 * @date 2019-12-16 12:17
 */
public class ScriptTest {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        String exp = "2*6-(6+5)";
        Object result = scriptEngine.eval(exp);
        System.out.println(exp + "=" + result);
    }
}
