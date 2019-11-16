package com.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.ClassInterceptor;
import com.jfinal.interceptor.MethodInterceptor;
import com.jfinal.service.Service;

@Before(ClassInterceptor.class)
public class AopController extends Controller {

    @Inject
    private Service service;

    public void index() {
        renderHtml("hello");
    }

    @Before(MethodInterceptor.class)
    public void method() {
        renderHtml("method");
    }

    @Clear
    public void clear() {
        renderHtml("clear");
    }

    public void test() {
        System.out.println(service.getClass());
        renderHtml("test");
    }
}
