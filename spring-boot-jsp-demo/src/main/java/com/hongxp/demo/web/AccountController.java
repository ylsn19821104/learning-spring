package com.hongxp.demo.web;

import com.hongxp.demo.model.Account;
import com.hongxp.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account") //RequestMapping可对类和方法做映射
public class AccountController {
    //自动封装注解，省去set、get方法和实例化声明
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/login")
    public String Login() {
        return "account/login"; //没有用ResponseBody，返回string，跳转的是jsp页面："login" + ".jsp"后缀
    }

    @RequestMapping("/valid")
    @ResponseBody
    public String Valid(HttpServletRequest request) {
        Account account = new Account();
        account.setName(request.getParameter("name"));
        account.setPassword(request.getParameter("password"));
        if (accountService.valid(account)) {
            return "Login Success!";
        } else {
            return "Login Failed!";
        }
    }
}

