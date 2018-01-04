package cn.happy.day05.dao;

import cn.happy.day05.util.HibernateUtil;

import java.io.Serializable;

/**
 * Created by CY on 2017/12/27.
 */
public class HibernateDAO {
    public Object get(Class clazz, Serializable id){
        Object result= HibernateUtil.getSession().load(clazz,id);
        System.out.println(HibernateUtil.getSession().hashCode()+"dao");
        return result;
    }
}
