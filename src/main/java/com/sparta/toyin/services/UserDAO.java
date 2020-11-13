package com.sparta.toyin.services;

import com.sparta.toyin.entities.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UserEntity findUserByID(int userId) {
        return entityManager.find(UserEntity.class,userId);
    }



//
//    public String redirect(int number) {
//        if (findUserByID(number) != null) {
//            return "actorInfo";
//        }else {
//            return "error";
//        }
//    }
}
