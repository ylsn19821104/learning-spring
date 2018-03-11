package com.hongxp.demo.dubbo.client.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hongxp.demo.dubbo.provider.po.Category;
import com.hongxp.demo.dubbo.provider.service.CategoryService;
import com.hongxp.demo.dubbo.provider.vo.CategoryVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Reference
    CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryVo getCategory(@NotNull @PathVariable("id") Long id) {
        Category re = categoryService.selectCategory(id);
        CategoryVo vo = new CategoryVo();
        if (re != null)
            vo.setName(re.getName());
        return vo;
    }
}
