package cn.loverblue.hr;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.utils.ConvertData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class HrApplicationTests {

    Logger logger = LoggerFactory.getLogger(HrApplicationTests.class);

    @Resource
    ConvertData convertData;

    @Test
    void contextLoads() {

        logger.debug("我是debug");
        logger.info("我是info");

    }
    @Test
    public void test01(){

        Date date = convertData.convert("2012-12-01");

        System.out.println(date);
    }

}
