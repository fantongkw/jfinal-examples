package com.demo.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {

    public void index() {
        renderText("Hello World");
    }

}
