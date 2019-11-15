package jfinal.controller;

import com.jfinal.core.Controller;

public class HelloWorldController extends Controller {

    public void index () {
        renderText("Hello World!");
    }
}
