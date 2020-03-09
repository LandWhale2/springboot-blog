package com.common.forum.domain.entity;

import javax.persistence.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.common.forum.config.PostStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Post {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String title;

  @Lob
  @NotNull
  private String content;

  @Lob
  private String code;

  @Enumerated(EnumType.STRING)
  private PostStatus status;

  private LocalDateTime regDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private List<Comment> comments;

  Post() {
  }

  public Post(Long id) {
    this.id = id;
  }

  public Post(String title, PostStatus status) {
    this.title = title;
    this.status = status;
  }

  public Post(Long id, String title, String content, String code, PostStatus status) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.code = code;
    this.status = status;
  }

  public Post(String title, String content, String code, PostStatus status) {
    this.title = title;
    this.content = content;
    this.code = code;
    this.status = status;
  }

  public Post(String title, String content, String code, PostStatus status, Category category) {
    this.title = title;
    this.content = content;
    this.code = code;
    this.status = status;
    this.category = category;
  }
}