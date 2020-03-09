package com.common.forum.service;


import lombok.RequiredArgsConstructor;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.forum.config.PostStatus;
import com.common.forum.domain.entity.Post;
import com.common.forum.domain.repository.PostRepository;
import com.common.forum.exception.NotFoundException;

import java.time.LocalDateTime;



@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Post createPost(Post post) {
    post.setRegDate(LocalDateTime.now());
    return postRepository.save(post);
  }

  public Post updatePost(Long id, Post post) {
    Post oldPost = postRepository.findByIdAndStatus(id, PostStatus.Y);
    if (oldPost == null) {
      throw new NotFoundException(id + " not found");
    }

    oldPost.setContent(post.getContent());
    oldPost.setCode(post.getCode());
    oldPost.setTitle(post.getTitle());
    return oldPost;
  }

  public void deletePost(Long id) {
    Post oldPost = postRepository.findByIdAndStatus(id, PostStatus.Y);
    if (oldPost == null) {
      throw new NotFoundException(id + " not found");
    }
    oldPost.setStatus(PostStatus.N);
  }

  @Transactional(readOnly = true)
  public Post findByIdAndStatus(Long id, PostStatus status) {
    Post post = postRepository.findByIdAndStatus(id, status);
    if (post == null) {
      throw new NotFoundException(id + " not found");
    }
    return post;
  }
}