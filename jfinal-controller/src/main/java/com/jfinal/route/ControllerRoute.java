package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.ControllerController;

public class ControllerRoute extends Routes {

    @Override
    public void config() {
        setBaseViewPath("/view");
        add("/", ControllerController.class, "/controller");
    }
}
