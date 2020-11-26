package com.sparta.toyin.bean;

import com.sparta.toyin.entities.UserEntity;
import com.sparta.toyin.services.UserDAO;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {

    @Inject
    private UserEntity userEntity;

    @Inject
    private UserDAO userDAO;

    @Inject
    SecurityContext securityContext;

    @Inject
    ExternalContext externalContext;

    @Inject
    FacesContext facesContext;

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void submit(String username) throws IOException {
        switch (continueAuthentication(username)) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login unsuccessful", null));
                break;
            case SUCCESS:
                externalContext.redirect(externalContext.getRequestContextPath() + "/view/welcome.xhtml");
        }
    }

    private AuthenticationStatus continueAuthentication(String username) {
        UserEntity user = userDAO.findUserByUserName(username);
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(user.getUserName(), user.getPassword()))
        );
    }

    public String logout() {
        ((HttpServletRequest) externalContext.getRequest()).getSession(false).invalidate();
        return "/login.xhtml?face-redirect=true";
    }

}
