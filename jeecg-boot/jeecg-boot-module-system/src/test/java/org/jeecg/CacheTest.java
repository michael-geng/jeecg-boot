package org.jeecg;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;
import org.jeecg.test.BaseServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class CacheTest extends BaseServiceTest {

    @Test
    public void test1(){
        CacheChannel cache = J2Cache.getChannel();

        //缓存操作
        cache.set("default", "1", "Hello J2Cache");
        System.out.println(cache.get("default", "1"));
        cache.evict("default", "1");
        System.out.println(cache.get("default", "1"));

        cache.close();
    }

}
