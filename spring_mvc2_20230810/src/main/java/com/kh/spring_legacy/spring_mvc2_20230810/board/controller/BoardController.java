package com.kh.spring_legacy.spring_mvc2_20230810.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board") // 요청 url의 상위 url을 모두 처리할 때 사용 
@Slf4j
@Controller
public class BoardController {
  @RequestMapping("/error")
  public String error() {
    return "/common/error";
  }

  // 새글 작성하기 
  @RequestMapping("/write")
  public String writeView() {
    return "board/write";
  }
}
