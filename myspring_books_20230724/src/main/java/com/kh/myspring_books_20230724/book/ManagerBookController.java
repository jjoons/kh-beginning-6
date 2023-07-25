package com.kh.myspring_books_20230724.book;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ManagerBookController {
  @Autowired
  private ManagerBookDAO bookDao;

  @Autowired
  private Upload upload;

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
    model.addAttribute("type", new Integer(0));
    model.addAttribute("cont", "02_01_bookList.jsp");

    return "00_index";
  }

  @RequestMapping(value = "/managerBookRegister.do")
  public String managerBookRegister(Model model, HttpServletRequest request) {
    model.addAttribute("type", new Integer(0));
    model.addAttribute("cont", "02_02_bookRegister.jsp");

    return "00_index";
  }

  @RequestMapping(value = "/managerBookRegisterPro.do")
  public String managerBookRegisterPro(Model model, HttpServletRequest request,
      MultipartHttpServletRequest mRequest) {
    try {
      mRequest.setCharacterEncoding("utf-8");
    } catch (Exception e) {
      System.err.println(e);
    }

    String loadName = upload.fileUpload(mRequest);

    if (loadName.equals("")) {
      model.addAttribute("result", "파일 업로드 실패");
    } else {
      model.addAttribute("result", "파일 업로드 성공");
    }

    // 폼으로부터 넘어온 정보 중 파일이 아닌 정보를 얻어냄
    ManagerBookVO book = new ManagerBookVO();
    String filename = loadName;

    // DB 연동. 넘어온 정보를 테이블의 레코드에 추가한다
    bookDao.insertBook(book);
    request.setAttribute("book_kind", book_kind);

    model.addAttribute("type", new Integer(0));
    model.addAttribute("cont", "02_03_bookRegisterPro.jsp");

    return "00_index";
  }


}
