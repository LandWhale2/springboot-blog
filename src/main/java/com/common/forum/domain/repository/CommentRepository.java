package com.common.forum.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.forum.domain.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
