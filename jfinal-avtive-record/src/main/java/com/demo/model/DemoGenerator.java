package com.demo.model;

import com.demo.DemoConfig;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

public class DemoGenerator  {

    private static DataSource getDataSource() {
        DruidPlugin dp = DemoConfig.createDruidPlugin();
        dp.start();
        return dp.getDataSource();
    }

    public static void main(String[] args) {
        String baseModelPackageName = "com.demo.model.base";
        String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/com/demo/model/base";
        String modelPackageName = "com.demo.model";
        String modelOutputDir = baseModelOutputDir + "/..";
        Generator generator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
        generator.setGenerateRemarks(true);
        generator.setDialect(new MysqlDialect());
        generator.setGenerateChainSetter(false);
        generator.generate();
    }
}
