package com.example;

import com.example.business.dictionary.dao.impl.DictionaryDaoImpl;
import com.example.business.dictionary.service.DictionaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlashApplicationTests {

    @Autowired
	private DictionaryDaoImpl dictionaryDao;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

	@Test
    @Rollback
    @Transactional
	public void contextLoads() throws Exception{
//	    dictionaryDao.listChildrenByKey("fsd");
//
//        System.out.println(dictionaryService.list());
//
        System.out.println(dictionaryService.list());
//        System.out.println(dictionaryService.list());
//        System.out.println("删除前：" + dictionaryDao.listChildrenByKey("animationStatus"));
//
//        System.out.println(dictionaryDao.listChildrenByKey("animat1ionStatus"));
//        System.out.println(dictionaryDao.listChildrenByKey("animationStatus2"));
//        dictionaryDao.delete(5);
//
//        System.out.println("删除前：" + dictionaryDao.listChildrenByKey("animationStatus"));
//        dictionaryService.list();

	}

//	@Test
//	public void test() throws Exception {
//        template.opsForValue().set("dictioanary", "123");
//        System.out.println(template.opsForValue().get("dictioanary"));
//    }
//
//    @Test
//    public void redisTemplateTest(){
//
//	    redisTemplate.opsForValue().set("DictionaryList" , dictionaryDao.list());
//        System.out.println(redisTemplate.opsForValue().get("DictionaryList"));
//    }

}
