package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before method invoking");
        invocation.invoke();
        System.out.println("After method invoking");
    }
}
