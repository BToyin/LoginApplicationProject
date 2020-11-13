package com.sparta.toyin.services;

import com.sparta.toyin.entities.UserEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.ArrayList;

public class UserDAO {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UserEntity findUserByID(int userId) {
        return entityManager.find(UserEntity.class,userId);
    }

    public boolean isAdmin(int userId) {
        boolean hasPrivileges = false;
        if (entityManager.find(UserEntity.class, userId).getRole().equals("admin")){
            hasPrivileges=true;
        }
        return hasPrivileges;
    }

    public ArrayList<UserEntity> findAdminsByRole() {
        ArrayList<UserEntity> admins = (ArrayList<UserEntity>) entityManager.createQuery("SELECT u.user_name, u.password FROM users u WHERE role='ADMIN'").getResultList();
        return admins;
    }


    public ArrayList<UserEntity> findUsersByRole() {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) entityManager.createQuery("SELECT u.user_name, u.password FROM users u WHERE role='USER'").getResultList();
        return users;
    }

    @Transactional
    public void addUser(UserEntity user) {
       this.entityManager.persist(user);
    }




}
