package com.tingeso.user.repository;


import com.tingeso.user.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    public UserEntity findByRut(String rut);
    List<UserEntity> findByCategory(String category);
    List<UserEntity> findByAgeGreaterThan(int age);

    // Método para encontrar usuarios por estado
    List<UserEntity> findByState(String state);

    @Query(value = "SELECT * FROM users WHERE users.rut = :rut", nativeQuery = true)
    UserEntity findByRutNative(@Param("rut") String rut);

}
