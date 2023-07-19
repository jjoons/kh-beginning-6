package com.kh.spring_web_ojdbc_template_20230719.service;

import org.springframework.ui.Model;
import com.kh.spring_web_ojdbc_template_20230719.vo.MvcBoardVO;

public interface MvcBoardService {
  public abstract void execute(MvcBoardVO mvcBoardVO);

  public abstract void execute(Model model);
}
