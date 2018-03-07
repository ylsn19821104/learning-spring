package com.hongxp.data.test;

import com.hongxp.demo.DataRestApplication;
import com.hongxp.demo.entity.User;
import com.hongxp.demo.repo.CustomerRepository;
import com.hongxp.demo.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataRestApplication.class)
public class RepoTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(29);
        user.setName("sky");
        user.setSex(true);
        userRepository.save(user);
    }


}
