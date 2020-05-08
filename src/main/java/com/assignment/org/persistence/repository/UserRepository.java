package com.assignment.org.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.org.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	User findFirstByEmailId(String username);

}
