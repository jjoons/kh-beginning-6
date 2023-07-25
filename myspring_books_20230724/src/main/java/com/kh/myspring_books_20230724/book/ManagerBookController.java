package com.kh.myspring_books_20230724.book;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerBookController {
  @Autowired
  private ManagerBookDAO bookDao;

  @RequestMapping(value = "/managerBookList.do")
  public String managerOrderList(Model model, HttpServletRequest request) {
    List<ManagerBookVO> bookList = null;
    String book_kind = request.getParameter("book_kind");
    int count = 0;
    System.out.println(book_kind);

    // DB 연동해서 전체 상품의 수를 얻어 냄
    count = bookDao.getBookCount();

    if (count > 0) {
      // 상품이 있으면 테이블에서 bookList에 저장
      bookList = bookDao.getBooks(book_kind);

      // bookList를 뷰에서 사용할 수 있도록 request 저장
      request.setAttribute("bookList", bookList);
    }

    // 뷰에서 사용할 속성
    request.setAttribute("count", new Integer(count));
    request.setAttribute("book_kind", book_kind);

    // 관리자인지 사용자인지 저장
    request.setAttribute("type", new Integer(0));
    model.addAttribute("cont", "02_01_bookList.jsp");

    return "00_index";
  }
}
