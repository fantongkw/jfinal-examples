package com.jfinal.route;

import com.jfinal.config.Routes;
import com.jfinal.controller.ConfigController;

public class ConfigRoute extends Routes {

    @Override
    public void config() {
        setMappingSuperClass(false);
        setBaseViewPath("/config");
        add("/", ConfigController.class);
    }
}
