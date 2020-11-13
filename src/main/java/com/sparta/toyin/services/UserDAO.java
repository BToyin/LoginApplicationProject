package com.sparta.toyin.services;

import com.sparta.toyin.entities.UserEntity;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserDAO {


    @Inject
    private UserEntity userEntity;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UserEntity findUserByID(int userId) {
        return entityManager.find(UserEntity.class,userId);
    }


    public List<UserEntity> findAdminsByRole() {
        return entityManager.createNativeQuery("SELECT * FROM user u WHERE role='ADMIN'").getResultList();
    }


    public List<UserEntity> findUsersByRole() {
        return entityManager.createNativeQuery("SELECT * FROM user u WHERE role='USER'").getResultList();
    }

    public List<UserEntity> findUsersByRole(String role) {
        return entityManager.createQuery("SELECT u FROM user u WHERE u.role LIKE :role").setParameter("role",role).getResultList();
    }

//    @Transactional
    public void addUser(UserEntity user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }



}
