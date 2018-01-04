package day06moneytonoe;

import cn.happy.day08.Dog;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2017/12/28.
 */
public class myTest {

    @Test
    public  void  t1(){
        Dog d1=new Dog();
        d1.setDogname("张三");
        d1.setDogage(22);

        Dog d2=new Dog();
        d2.setDogname("张三");
        d2.setDogage(2);

        Set<Dog> set=new HashSet<Dog>();
        set.add(d1);
        set.add(d2);
        System.out.println(set.size());

    }


}
