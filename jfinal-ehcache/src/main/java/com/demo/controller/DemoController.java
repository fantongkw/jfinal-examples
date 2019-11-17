package com.demo.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

public class DemoController extends Controller {

    @Before(CacheInterceptor.class)
    public void index() {
        render("hello.html");
    }

    @Before(EvictInterceptor.class)
    @CacheName("test")
    public void test() {

    }

}
