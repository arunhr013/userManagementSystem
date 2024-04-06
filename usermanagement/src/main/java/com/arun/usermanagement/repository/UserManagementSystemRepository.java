package com.arun.usermanagement.repository;

import com.arun.usermanagement.entity.UserManagementSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementSystemRepository extends CrudRepository<UserManagementSystem, Long> , JpaRepository<UserManagementSystem, Long> {
}
