package com.kh.d20230718_problem_1.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired
  private BoardDAO dao;

  @ModelAttribute(value = "cp")
  public String getContextPath(HttpServletRequest req) {
    return req.getContextPath();
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String boardList(Model model, int p) {
    List<Board> boardList = this.dao.getBoardList();
    model.addAttribute("boardList", boardList);

    return "board/boardList";
  }

  @RequestMapping(value = "/boardInfo", method = RequestMethod.GET)
  public String boardInfo(Model model, int num) {
    Board board = this.dao.getBoardById(num);

    if (board != null) {
      this.dao.increaseReadCount(num);
    }

    model.addAttribute("bean", board);

    return "board/boardInfo";
  }

  @RequestMapping(value = "boardWriteForm", method = RequestMethod.GET)
  public String boardWriteForm() {
    return "board/boardWriteForm";
  }

  @RequestMapping(value = "/boardWritePro", method = RequestMethod.POST)
  public String boardWritePro(Model model, Board board) {
    // 스프링이 자동으로 매핑을 시켜준다.
    // 필드명이 Board 클래스의 필드명과 같아야 실행할 수 있다
    int result = this.dao.insertBoard(board);

    return "redirect:/board/boardList";
  }

  @RequestMapping(value = "/reWriteForm", method = RequestMethod.GET)
  public String reWriteForm(Model model, int num) {
    Board board = this.dao.getBoardById(num);

    //    model.addAttribute("", board);
    //    model.addAttribute("", board);
    //    model.addAttribute("", board);

    return "board/reWriteForm";
  }
}
