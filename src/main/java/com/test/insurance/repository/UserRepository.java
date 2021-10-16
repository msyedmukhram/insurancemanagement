package com.test.insurance.repository;

import com.test.insurance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByMobileNumber(String mobile);
}
