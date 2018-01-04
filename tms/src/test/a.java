import cn.tms.entity.News;
import cn.tms.entity.Student;
import cn.tms.service.impl.IFrontServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by CY on 2017/11/25.
 */
public class a {

    private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(a==b);
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test01(){

        Student student=new Student();
        student.setAge(1);
        student.setName("小红");
        Student student1=new Student();
        student1.setAge(2);
        student1.setName("小名");
        Student student2=new Student();
        student2.setAge(3);
        student2.setName("小军");
        Student student3=new Student();
        student3.setAge(4);
        student3.setName("小量");


        List<Student> arrayList=new ArrayList();
        arrayList.add(student1);
        arrayList.add(student);
        arrayList.add(student2);
        arrayList.add(student3);
           Map<Integer,Object> map=new HashMap<Integer,Object>();
        for (Student item:arrayList) {
            map.put(item.getAge(),student);

        }
    }

    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
    }
}
