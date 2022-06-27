package com.jeonghoon.thymeleaf_practice.validator;

import com.jeonghoon.thymeleaf_practice.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Board.class.equals(clazz);
  }

  @Override
  public void validate(Object obj, Errors errors) {
    Board b = (Board) obj;

    if (StringUtils.isEmpty(b.getContent())) {
      errors.rejectValue("content", "contentError", "내용을 입력해주세요.");
    }

    if (StringUtils.isEmpty(b.getAuthor())) {
      errors.rejectValue("author", "authorError", "작성자를 입력해주세요.");
    }

    if (StringUtils.isEmpty(b.getTitle())) {
      errors.rejectValue("title", "titleError", "제목을 입력해주세요.");
    }

  }
}
