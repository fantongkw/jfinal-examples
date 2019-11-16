package com.demo;

import com.demo.controller.DemoController;
import com.demo.model.User;
import com.demo.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

    private static Prop p;

    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 8080, true);
    }

    private static void loadConfig() {
        if (p == null) {
            p = PropKit.use("application.txt");
        }
    }

    @Override
    public void configConstant(Constants constants) {
        loadConfig();
        constants.setDevMode(true);
        constants.setInjectDependency(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/", DemoController.class, "/index");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = createDruidPlugin();
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        _MappingKit.mapping(arp);
        plugins.add(arp);
    }

    public static DruidPlugin createDruidPlugin() {
        loadConfig();
        return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password").trim());
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
