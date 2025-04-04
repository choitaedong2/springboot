package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Board;
import com.study.springboot.dto.UserDto;
import com.study.springboot.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {
	@Autowired
	BoardRepository bRepository;
	
	@GetMapping("/boardall")
	public List<Board> getBoardAll() {
		return boardRestService.getUserDtoAll();
	}
	
	@GetMapping("/board/{bno}")
	public Board getBno(@RequestParam("bno") String bno) {
		log.info("bno : " +bno);
		return boardRestService.getUserById(bno);
	}
	
}
