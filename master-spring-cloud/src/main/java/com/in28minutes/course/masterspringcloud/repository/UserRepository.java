package com.in28minutes.course.masterspringcloud.repository;

import com.in28minutes.course.masterspringcloud.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
}
