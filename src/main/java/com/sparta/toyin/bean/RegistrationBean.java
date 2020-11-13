package com.sparta.toyin.bean;

import com.sparta.toyin.entities.UserEntity;
import com.sparta.toyin.services.UserDAO;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import java.io.IOException;

@Named
@RequestScoped
public class RegistrationBean {


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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void adduser(UserEntity userEntity) {
        userDAO.addUser(userEntity);
    }

}
