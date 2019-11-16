package com.jfinal;

import com.jfinal.config.*;
import com.jfinal.handler.ContextPathHandler;
import com.jfinal.interceptor.ConfigInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.route.ConfigRoute;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;


public class Config extends JFinalConfig {

    public static void main(String[] args) {
        UndertowServer.start(Config.class, 8080, true);
    }

    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setUrlParaSeparator("/");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new ConfigRoute());
    }

    @Override
    public void configEngine(Engine engine) {
        engine.addSharedFunction("/config/index.html");
    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/oa?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true","root","123456");
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new ConfigInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler());
    }
}
