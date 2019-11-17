package com.demo.controller;

import com.demo.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;

public class DemoController extends Controller {

    public void index() {
        renderHtml("hello");
    }

    @Before(LoginValidator.class)
    public void login1() {

    }
}
