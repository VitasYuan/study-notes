package com.zjut.convert;

import com.zjut.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author yuanweipeng
 */
public class DateConvert implements Converter<String, Date> {

    private Logger LOGGER = LoggerFactory.getLogger(DateConvert.class);

    @Override
    public Date convert(String s) {
        try {

            return DateUtil.parse(s);

        }catch (Exception e){
            LOGGER.error("Date convert exception, source :{},exception:{}", s, e);
        }

        return null;
    }

}
