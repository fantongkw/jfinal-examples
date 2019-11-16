package com.jfinal;

import com.jfinal.aop.AopManager;
import com.jfinal.config.*;
import com.jfinal.controller.AopController;
import com.jfinal.interceptor.GAInterceptor;
import com.jfinal.interceptor.GSInterceptor;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class AopConfig extends JFinalConfig {

    public static void main(String[] args) {
        UndertowServer.start(AopConfig.class, 8080, true);
    }

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setInjectDependency(true);
        constants.setToCglibProxyFactory();
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", AopController.class, "/index");
    }

    @Override
    public void configEngine(Engine engine) {
    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.addGlobalActionInterceptor(new GAInterceptor());
        interceptors.addGlobalServiceInterceptor(new GSInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
