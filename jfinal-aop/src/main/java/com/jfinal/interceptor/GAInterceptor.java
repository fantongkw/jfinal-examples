package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GAInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before global action invoking");
        invocation.invoke();
        System.out.println("After global action invoking");
    }
}
