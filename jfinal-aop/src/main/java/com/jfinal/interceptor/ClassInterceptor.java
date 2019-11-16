package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ClassInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before class invoking");
        invocation.invoke();
        System.out.println("After class invoking");
    }

}
