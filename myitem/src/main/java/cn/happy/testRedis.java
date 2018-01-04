package cn.happy;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class testRedis {
    private RedisUtil redisUtil = new RedisUtil();

    @Test
    public void testRedis(){
        /*RedisUtil redisUtil = new RedisUtil();
        redisUtil.setDemo("test","1");
        System.out.print(redisUtil.getDemo("test"));*/
        Jedis jedis=new Jedis("127.0.0.1");
        jedis.lpush("list", "aa");
        jedis.lpush("list", "bb");
        jedis.lpush("list", "cc");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println(jedis.lrange("list", 0, 1));
        System.out.println(jedis.lpop("list")); // 栈顶
        jedis.del("list");


    }
    /*@Test
    public void testRedisPool() {
        RedisUtilPool redisUtilPool = new RedisUtilPool();
        Jedis jedis = redisUtilPool.getJedis();
        jedis.set("test2", "2");
        System.out.println(jedis.get("test2"));
    }*/

}