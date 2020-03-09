package com.common.forum.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class CommentDto {

  @NotNull
  private Long postId;

  @NotBlank
  private String content;
}
