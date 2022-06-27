package com.jeonghoon.thymeleaf_practice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 2, max = 50, message = "제목은 최소 2자 이상 최대 50자까지 지원합니다.")
  private String title;

  @NotNull
  private String content;

  @NotNull
  @Size(min = 2, max = 10, message = "작성자는 최소 2자 이상 최대 50자까지 지원합니다.")
  private String author;
}
