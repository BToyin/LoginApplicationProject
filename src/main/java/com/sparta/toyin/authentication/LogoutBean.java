package com.sparta.toyin.authentication;

import com.sparta.toyin.entities.User;

import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

public class LogoutBean {

    @Inject
    private LoginBean loginBean;

    public String logout() {
        ((HttpServletRequest) loginBean.externalContext.getRequest()).getSession(false).invalidate();
        return "/login.xhtml?face-redirect=true";
    }
}
