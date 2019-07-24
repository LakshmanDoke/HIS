package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.model.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, String> {

}
