package com.jeonghoon.thymeleaf_practice.repository;

import com.jeonghoon.thymeleaf_practice.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
