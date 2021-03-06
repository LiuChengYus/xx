package com.accp.v.handler.real;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.*;

public class HeartbeatHandler {
	public static void main(String[] args) {
		Long fetchTimeOut = 100L;
		Properties props = new Properties();
		props.put("bootstrap.servers", "47.95.227.40:9092");
		props.put("group.id", "abc");
		props.put("enable.auto.commit", "false");// 自动提交offsets
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");// 反序列化器
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
		consumer.subscribe(Arrays.asList("login"));
		ConsumerRecord<String, String> record = null;
		List<ConsumerRecord<String, String>> buffer = new ArrayList();
		while (true) {
			ConsumerRecords<String, String> records = consumer
					.poll(fetchTimeOut);
			System.out.println("====我在运行=====");
			if (records.count() > 0) {
				System.out.println("====接到数据=====");
				Iterator<ConsumerRecord<String, String>> it = records
						.iterator();
				while (it.hasNext()) {
					try {
						record = it.next();
						buffer.add(record);
					} catch (Exception e1) {

					}
				}
				insertRedis(buffer);
				consumer.commitSync();
				buffer.clear();
			} else {
				// 如果没有接到数据，需要休眠下10s，再去Kafka拉取数据
				try {
					Thread.sleep(10000);
				} catch (InterruptedException ie) {

				}
			}
		}
	}

	private static void insertRedis(List<ConsumerRecord<String, String>> buffer) {
		if (buffer != null && buffer.size() > 0) {
			for (ConsumerRecord<String, String> record : buffer) {
				System.out.println("Key:" + record.key());
				System.out.println("Value:" + record.value());
			}
		}
		System.out.print("插入数据库");
	}

	private static  void getRedis(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");//此文件
		JedisPoolUtils jedisClusterPool=(JedisPoolUtils)context.getBean("jedisClusterPool");
		Jedis jedis=jedisClusterPool.getJedis();
        Map<String, String> hgetAll = jedis.hgetAll("小明");
        if(hgetAll!=null&&hgetAll.size()>0){
            for (String key:hgetAll.keySet()){
                System.out.println("key------>"+key);
                System.out.println("value------>"+hgetAll.get(key));
            }
        }
    }
}
