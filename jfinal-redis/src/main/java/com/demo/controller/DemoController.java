package com.demo.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

public class DemoController extends Controller {

    public void index() {
        Cache cache = Redis.use("bbs");
        cache.set("key", "value");
        cache.get("key");
        renderHtml("hello");
    }

}
