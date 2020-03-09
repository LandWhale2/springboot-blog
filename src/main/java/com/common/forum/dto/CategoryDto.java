package com.common.forum.dto;




import javax.validation.constraints.NotBlank;

import lombok.Data;



@Data
public class CategoryDto {

  private Long id;
  @NotBlank
  private String name;
}
