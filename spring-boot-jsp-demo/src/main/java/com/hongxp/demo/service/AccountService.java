package com.hongxp.demo.service;

import com.hongxp.demo.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public boolean valid(Account account) {
        if ("admin".equals(account.getName()) && "123456".equals(account.getPassword())) {
            return true;
        }
        return false;
    }
}

