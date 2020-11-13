package com.sparta.toyin.bean;

import com.sparta.toyin.entities.UserEntity;
import com.sparta.toyin.services.UserDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean {


    @Inject
    private UserEntity userEntity;

    @Inject
    private UserDAO userDAO;

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
