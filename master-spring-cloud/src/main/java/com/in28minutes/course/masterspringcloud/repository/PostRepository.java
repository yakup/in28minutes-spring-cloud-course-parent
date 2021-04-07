package com.in28minutes.course.masterspringcloud.repository;

import com.in28minutes.course.masterspringcloud.controller.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
