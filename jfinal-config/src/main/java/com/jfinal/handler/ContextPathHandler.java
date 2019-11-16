package com.jfinal.handler;

import com.jfinal.kit.StrKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextPathHandler extends Handler {

    private String contextPathName;

    public ContextPathHandler() {
        this.contextPathName = "CONTEXT_PATH";
    }

    public ContextPathHandler(String contextPathName) {
        if (StrKit.isBlank(contextPathName)) {
            throw new IllegalArgumentException("contextPathName can not be blank.");
        }
        this.contextPathName = contextPathName;
    }

    @Override
    public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        httpServletRequest.setAttribute(contextPathName, httpServletRequest.getContextPath());
        next.handle("", httpServletRequest, httpServletResponse, booleans);
    }
}
