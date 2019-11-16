package com.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;
import com.jfinal.model.User;
import com.jfinal.upload.UploadFile;

import java.io.File;

public class ControllerController extends Controller {

    public void index() {
        renderText("index");
    }

    @NotAction
    public void method() {
        renderText("method");
    }

    public void show() {
        render("index.html");
    }

    public void index1() {
        render("/view/index/index.html");
    }

    public void login() {
        User user = getModel(User.class);
    }

    public void file() {
        renderFile("test.txt");
    }

    public void file1() {
        String file = "G:/test.txt";
        renderFile(new File(file));
    }

    public void uploaded() {
        UploadFile file = getFile("file");
    }

    public void qrcode() {
        String data = "weixin://helloworld";
        renderQrCode(data, 200, 200, 'M');
    }
}
