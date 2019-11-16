package com.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class ConfigController extends Controller {

    public void index() {
        renderFile("jfinal config");
    }

    public void login() {
        redirect("/login.html");
    }
}
