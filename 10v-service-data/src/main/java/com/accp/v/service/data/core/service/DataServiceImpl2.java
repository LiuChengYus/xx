package com.accp.v.service.data.core.service;

import com.accp.v.service.data.client.api.DataService;
import com.accp.v.service.data.core.model.CommandTag;
import com.accp.v.service.data.core.model.Content;
import com.accp.v.service.data.core.model.RealData;
import com.accp.v.service.data.core.model.Student;
import com.accp.v.service.data.core.util.JedisPoolUtils;
import com.accp.v.service.data.core.util.JsonPluginsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by CY on 2018/1/21.
 */
public class DataServiceImpl implements DataService {

    ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");//此文件
    JedisPoolUtils jedisClusterPool=(JedisPoolUtils)context.getBean("jedisClusterPool");
    Jedis jedis=jedisClusterPool.getJedis();

    @Test
    public  void y1(){

        Map<String, String> hgetAll = jedis.hgetAll("AAA");
        if(hgetAll!=null&&hgetAll.size()>0){
            for (String key:hgetAll.keySet()){
                /*System.out.println("key读取------>"+key);*/
                //System.out.println("value读取------>"+hgetAll.get(key));
                //RealData realData =JSON.parseObject(hgetAll.get(key),RealData.class);
               /* JSONObject jsonObject = JSON.parseObject(hgetAll.get(key));
                String commandTag = jsonObject.getString("commandTag");
                String vin = jsonObject.getString("vin");
                String content = jsonObject.getString("content");
                System.out.println(commandTag);
                System.out.println(vin);
                JSONObject jsonObject1 = JSON.parseObject(content);
                System.out.println(jsonObject1.getString("collectTime"));*/
                RealData realData = JsonPluginsUtil.jsonToBean(hgetAll.get(key), RealData.class);
                System.out.println(realData.getCommandTag());
            }
        }
    }

    @Test
    public void t1(){
        String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);


        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students =jsonObject.getJSONArray("students");
        System.out.println(teacherName);
        System.out.println(teacherAge);
        System.out.println(course);
       /* System.out.println(students.);*/
    }

    @Override
    public RealData getRealDataByVin(String vin) throws Exception {

        Map<String, String> hgetAll = jedis.hgetAll(vin);
        if(hgetAll!=null&&hgetAll.size()>0){
            for (String key:hgetAll.keySet()){
                System.out.println("key读取------>"+key);
                System.out.println("value读取------>"+hgetAll.get(key));
            }
        }

        return null;
    }

    @Override
    public List<RealData> getRealDataListAll() throws Exception {
      List<RealData> list=new ArrayList<>();

        Set<String> keys = jedis.keys("*");
        for (String item:keys){
            Map<String, String> hgetAll = jedis.hgetAll(item);
            if(hgetAll!=null&&hgetAll.size()>0){
                for (String key:hgetAll.keySet()){
                    RealData realData=new RealData();
                    Content content1=new Content();
                    JSONObject jsonObject = JSON.parseObject(hgetAll.get(key));

                    String commandTag = jsonObject.getString("commandTag");
                    String vin = jsonObject.getString("vin");
                    String content = jsonObject.getString("content");
                    JSONObject jsonObject1 = JSON.parseObject(content);
                    String collectTime = jsonObject1.getString("collectTime");
                    Integer serialNumber = jsonObject1.getInteger("serialNumber");
                    final String iccid = jsonObject1.getString("iccid");
                    Integer chargingSystemNumber = jsonObject1.getInteger("chargingSystemNumber");
                    Integer chargingSystemLength = jsonObject1.getInteger("chargingSystemLength");
                    JSONArray chargingSystemCode = jsonObject1.getJSONArray("chargingSystemCode");
                    //对实体赋值
                    realData.setCommandTag(CommandTag.valueOf(commandTag));
                    realData.setVin(vin);
                    //整车数据
                    content1.setCollectTime(Long.parseLong(collectTime));
                    content1.setSerialNumber(serialNumber);
                    content1.setIccid(iccid);
                    content1.setChargingSystemNumber(chargingSystemNumber);
                    content1.setChargingSystemLength(chargingSystemLength);
                   /* for (String code:chargingSystemCode.size()){

                    }*/
                }
            }


        }



        return null;
    }

    /**
     * 总个数
     * @return
     * @throws Exception
     */
    @Override
    public int getAccountAll() throws Exception {
        Set<String> keys = jedis.keys("*");

        return keys.size();
    }

    /**
     * 测试
     */
    @Test
    public  void t3(){
       /* Set<String> keys = jedis.keys("*");
        for (String item:keys){
            System.out.println(item);
        }*/

       /* CommandTag heartbeat = CommandTag.valueOf("HEARTBEAT");
        System.out.println(heartbeat);*/
        String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    }
}
