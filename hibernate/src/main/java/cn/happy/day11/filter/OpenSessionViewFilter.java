package cn.happy.day11.filter;

import cn.happy.day11.util.HibernateUtil;
import org.hibernate.Transaction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by CY on 2017/12/31.
 */
public class OpenSessionViewFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Transaction transaction = HibernateUtil.getSession().beginTransaction();
        chain.doFilter(req, resp);
        transaction.commit();
        HibernateUtil.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
