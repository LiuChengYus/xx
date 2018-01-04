package day09moneytomonet;

import cn.happy.day11.service.EmployeeService;
import cn.happy.day12.another.Dept;
import cn.happy.day12.another.Emp;
import cn.happy.day12.view.Employee;
import cn.happy.day12.view.Project;
import cn.happy.day12.view.ProEmp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by CY on 2017/12/30.
 */
public class mytest20171230_02 {
    //多对多分成 两个多对一  添加员工和项目的方法
    @Test
    public void t4() {

        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Employee employee = new Employee();
        employee.setEmpname("小红");

        //项目对象
        Project project = new Project();
        project.setProname("项目1");


        ProEmp proEmp = new ProEmp();
        proEmp.setEmp(employee);
        proEmp.setPro(project);

        session.saveOrUpdate(employee);
        session.saveOrUpdate(project);
        session.saveOrUpdate(proEmp);
        tx.commit();
    }

    //查询
    @Test
    public void t5() {

        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Employee load1 = session.load(Employee.class, 29);
        Employee load2 = session.load(Employee.class, 29);
        System.out.println(load1 == load2);

    }


    @Test
    public void rr() {
        int a[] = new int[10];
        System.out.println(a[6]);
    }
   @Test
   public void t1111(){
        int a=4;   //定义一个变量a初始值为4
        int b=8;   //定义一个变量b初始值为8
        int temp;  //定义一个为赋值的临时变量
        temp=b;    //把b的值8赋值给temp这样temp等于8
        b=a;       //把a的值4给b现在      b的值为     4
        a=temp;    //把现在temp的值8给a   a现在的值为 8
        System.out.println(a+"<——>"+b);
   }

    //注解版 一对多双向关联关系 保存 员工的同时保存部门
    @Test
    public void testannontion() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Dept dept1 = new Dept();
        dept1.setDeptname("开发部");

        Emp emp1 = new Emp();
        emp1.setEmpname("小贱贱");
        emp1.setDept(dept1);

        Emp emp2 = new Emp();
        emp2.setEmpname("小红红");
        emp2.setDept(dept1);


        session.save(emp1);
        session.save(emp2);

        tx.commit();
    }

    //注解版 一对多双向关联关系 保存 部门的同时保存员工
    @Test
    public void testannontion2() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Dept dept1 = new Dept();
        dept1.setDeptname("开发部");

        Dept dept2 = new Dept();
        dept2.setDeptname("测试部");

        Emp emp1 = new Emp();
        emp1.setEmpname("小贱贱");
        emp1.setDept(dept1);


        session.saveOrUpdate(emp1);


        tx.commit();
    }

    //注解版 一对多双向关联关系 查询所有的员工分别对应的部门
    @Test
    public void testannontion3() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql = "select distinct  d  from Dept d left outer join d.emps ";
        Query query = session.createQuery(hql);
        List<Dept> list = query.list();
        for (Dept item : list) {
            System.out.println(item.getDeptname());
            for (Emp it : item.getEmps()) {
                System.out.println(it.getEmpname());
            }
        }
        tx.commit();
    }

    //注解版 一对多双向关联关系 查询所有的部门下的员工
    @Test
    public void testannontion4() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        String hql = "select distinct e from Emp e left outer join e.dept on e.dept.deptno=e.empno";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        for (Emp item : list) {
            System.out.println(item.getEmpname() + "/" + item.getDept().getDeptname());
        }
        tx.commit();
    }

    @Test
    public  void  nosession(){
        EmployeeService service=new EmployeeService();
        Dept data = (Dept)service.getData(Dept.class, 60);
        //System.out.println(data.getDeptname());
        System.out.println();
    }

}
