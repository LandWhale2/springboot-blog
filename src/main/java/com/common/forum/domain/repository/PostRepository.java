package com.common.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.forum.domain.entity.Post;




public interface PostRepository extends JpaRepository<Post, Long> {
	  Post findByIdAndStatus(Long id, PostStatus status);
}