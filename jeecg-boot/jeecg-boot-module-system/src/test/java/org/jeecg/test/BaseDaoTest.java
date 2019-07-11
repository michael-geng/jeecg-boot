package org.jeecg.test;

import org.jeecg.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = TestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
public class BaseDaoTest {

    //@Autowired
    //private AppUserDao userDao;

    @Test
    public void test() {
        //Integer id = userDao.getCustomerId("11");
    }
}