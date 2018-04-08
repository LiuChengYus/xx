package com.accp.day10timerintercepor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by CY on 2018/2/27.
 * 自定义hi见拦截器
 */
public class MyTimerInterceptor extends AbstractInterceptor{
    public String intercept(ActionInvocation invocation) throws Exception {
        long l = System.currentTimeMillis();
        String invoke = invocation.invoke();
        long l1 = System.currentTimeMillis();
        System.out.println("耗时"+(l-l1));
        return invoke;
    }
}
