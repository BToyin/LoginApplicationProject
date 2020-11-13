package com.sparta.toyin.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LogoutBean {

    @Inject
    private LoginBean loginBean;

    public String logout() {
        ((HttpServletRequest) loginBean.externalContext.getRequest()).getSession(false).invalidate();
        return "/login.xhtml?face-redirect=true";
    }
}
