package com.hongxp.demo.dubbo.provider;

import com.hongxp.demo.dubbo.provider.po.Category;
import com.hongxp.demo.dubbo.provider.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboProviderDemoApplicationTests {

    @Autowired
    CategoryService categoryService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSelectCategory() {
        Category category = categoryService.selectCategory(24L);
        System.err.println(category);
    }
}
