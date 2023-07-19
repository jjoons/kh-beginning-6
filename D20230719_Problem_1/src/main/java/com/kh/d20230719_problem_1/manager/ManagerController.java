package com.kh.d20230719_problem_1.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kh.d20230719_problem_1.board.BoardDAO;
import com.kh.d20230719_problem_1.buy.BuyDAO;
import com.kh.d20230719_problem_1.cart.CartDAO;
import com.kh.d20230719_problem_1.customer.CustomerDAO;
import com.kh.d20230719_problem_1.helper.CommonHelper;
import com.kh.d20230719_problem_1.item.ItemDAO;
import com.kh.d20230719_problem_1.item.ItemDTO;

@Controller
@RequestMapping("/manager")
public class ManagerController {
  @Autowired
  private BoardDAO boardDAO;

  @Autowired
  private BuyDAO buyDAO;

  @Autowired
  private CartDAO cartDAO;

  @Autowired
  private CustomerDAO customerDAO;

  @Autowired
  private ItemDAO itemDAO;

  @Autowired
  private ManagerDAO managerDAO;

  @ModelAttribute("contextPath")
  public String getContextPath(HttpServletRequest req) {
    return req.getContextPath();
  }

  public boolean isLogin(HttpSession session) {
    return ((String) session
        .getAttribute(ManagerConstant.MANAGER_SESSION_ATTRIBUTE_LOGIN_ID)) != null;
  }

  public void logout(HttpSession session) {
    session.removeAttribute(ManagerConstant.MANAGER_SESSION_ATTRIBUTE_LOGIN_ID);
  }


  @RequestMapping(value = {"/"}, method = RequestMethod.GET)
  public String index(HttpSession session, Model model) {
    return "redirect:managerMain";
  }

  @RequestMapping(value = "/managerMain", method = RequestMethod.GET)
  public String managerMain(HttpSession session, Model model) {
    if (!this.isLogin(session)) {
      return "redirect:managerLogin";
    }

    int customerCount = this.managerDAO.totalCustomerCount();
    int registeredItemCount = this.managerDAO.totalItemCount();
    //    int  totalBuyCount = ;

    model.addAttribute("customerCount", customerCount);
    model.addAttribute("registeredItemCount", registeredItemCount);
    //    model.addAttribute("totalBuyCount", );

    return "01_managerMain";
  }

  @RequestMapping(value = "/managerLogin", method = RequestMethod.GET)
  public String managerLogin(HttpSession session) {
    if (this.isLogin(session)) {
      return "redirect:managerMain";
    }

    return "02_managerLogin";
  }

  @RequestMapping(value = "/managerLoginPro", method = RequestMethod.POST)
  public String managerLoginPro(Model model, HttpSession session, String id, String pw) {
    if (this.isLogin(session)) {
      return "redirect:managerMain";
    }

    int loginResult = this.managerDAO.checkIdPassword(id, pw);
    model.addAttribute("loginResult", loginResult);

    if (loginResult == 1) {
      session.setAttribute(ManagerConstant.MANAGER_SESSION_ATTRIBUTE_LOGIN_ID, id);
      return "redirect:managerMain";
    }

    return "03_memberLoginPro";
  }

  @RequestMapping(value = "/managerLogout", method = RequestMethod.GET)
  public String managerLoginPro(HttpSession session) {
    session.removeAttribute(ManagerConstant.MANAGER_SESSION_ATTRIBUTE_LOGIN_ID);
    return "redirect:managerLogin";
  }

  @RequestMapping(value = "/addNewItem", method = RequestMethod.GET)
  public String addNewItem(HttpSession session) {
    if (!this.isLogin(session)) {
      return "redirect:managerLogin";
    }

    return "05_addNewItem";
  }

  @RequestMapping(value = "/addNewItemPro", method = RequestMethod.POST)
  public String addNewItemPro(HttpSession session, Model model, ItemDTO dto) {
    if (!this.isLogin(session)) {
      return "redirect:managerLogin";
    }

    String today = CommonHelper.getToday();
    dto.setReg_date(today);

    int result = this.itemDAO.insertItem(dto);
    model.addAttribute("result", result);

    return "06_addNewItemPro";
  }
}
