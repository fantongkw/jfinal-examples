package com.demo;

import com.demo.controller.DemoController;
import com.jfinal.config.*;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 8080, true);
    }

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.setBaseViewPath("/view");
        routes.add("/", DemoController.class, "/index");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
