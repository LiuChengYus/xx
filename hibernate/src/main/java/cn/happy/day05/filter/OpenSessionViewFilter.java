package cn.happy.day05.filter;


import cn.happy.day05.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.SessionStatistics;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by CY on 2017/12/27.
 */
public class OpenSessionViewFilter implements javax.servlet.Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     //请求到达时,打开Session并开启事务
        Session  session=null;
        Transaction tx=null;
        try{
            session= HibernateUtil.getSession();
            System.out.println("filter\t"+session.hashCode());
            tx=session.beginTransaction();
            //执行请求处理连
            chain.doFilter(request,response);
            //返回事务.提交事务
            tx.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭Session
            HibernateUtil.close();
        }
    }

    public void destroy() {

    }
}
