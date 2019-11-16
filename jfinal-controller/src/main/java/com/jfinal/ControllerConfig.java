package com.jfinal;

import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.model.User;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.route.ControllerRoute;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class ControllerConfig extends JFinalConfig {

    static Prop p;

    public static void main(String[] args) {
        UndertowServer.start(ControllerConfig.class, 8080, true);
    }

    private static void loadConfig() {
        if (p == null) {
            p = PropKit.use("application.txt");
        }
    }

    @Override
    public void configConstant(Constants constants) {
        loadConfig();
        constants.setDevMode(p.getBoolean("devMode", false));

        constants.setBaseDownloadPath("download");
        constants.setBaseUploadPath("upload");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new ControllerRoute());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin dp = createDruidPlugin();
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("user", User.class);
        plugins.add(arp);
    }

    public static DruidPlugin createDruidPlugin() {
        loadConfig();
        return new DruidPlugin(p.get("jdbcUrl"),p.get("user"),p.get("password").trim());
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
