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
        return entityManager.createNativeQuery("SELECT * FROM user u WHERE u.role='ADMIN'", UserEntity.class).getResultList();
    }


    public List<UserEntity> findUsersByRole() {
        return entityManager.createNativeQuery("SELECT * FROM user u WHERE u.role='USER'",UserEntity.class).getResultList();
    }


//    @Transactional
    public void addUser(UserEntity user) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }


    public UserEntity findUserByUserName(String username) {
        try {
            return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.userName LIKE :username", UserEntity.class).setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            throw new NoResultException("credentials do not exist");
        }

    }
}
