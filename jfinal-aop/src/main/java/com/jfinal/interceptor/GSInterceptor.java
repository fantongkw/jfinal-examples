package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GSInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        System.out.println("Before global service invoking");
        invocation.invoke();
        System.out.println("After global service invoking");
    }
}
