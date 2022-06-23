package com.jeonghoon.thymeleaf_practice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "[제목 유효성 예외 메시지] 최소 2자 최대 50자 입니다.")
    @Size(min=2, max=50)
    private String title;

    @NotEmpty(message = "[내용 유효성 예외 메시지] 내용 입력 값이 없습니다.")
    private String content;

    @NotEmpty(message = "[작성자 유효성 예외 메시지] 작성자 입력 값이 없습니다.")
    @Size(min=2, max=10)
    private String author;
}
