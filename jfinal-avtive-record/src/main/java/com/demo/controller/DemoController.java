package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;

public class DemoController extends Controller {
    @Inject
    private UserService userService;

    public void index() {
        renderHtml("index");
    }

    @Before(Tx.class)
    public void add() {
        userService.add();
        renderHtml("add");
    }

    public void delete() {
        userService.delete();
        renderHtml("delete");
    }

    public void findAndUpdate() {
        userService.findAndUpdate();
        renderHtml("findAndUpdate");
    }

    public void findUser() {
        userService.findAndUpdate();
        renderHtml("findUser");
    }

    public void selectWhere() {
        userService.selectWhere();
        renderHtml("selectWhere");
    }

    public void page() {
        userService.page();
        renderHtml("page");
    }
}
