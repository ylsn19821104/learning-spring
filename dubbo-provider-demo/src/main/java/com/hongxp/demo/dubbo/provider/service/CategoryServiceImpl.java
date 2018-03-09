package com.hongxp.demo.dubbo.provider.service;

import com.hongxp.demo.dubbo.provider.dao.CategoryDao;
import com.hongxp.demo.dubbo.provider.po.Category;
import com.hongxp.demo.dubbo.provider.vo.CategorySearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public int save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category selectCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return categoryDao.findById(category);
    }

    @Override
    public List<Category> selectCategoryList(CategorySearchVo categorySearchVo) {
        return null;
    }

    @Override
    public Integer refKeepWatchPointCount(Long id) {
        return null;
    }

    @Override
    public Boolean checkDoubleNameError(Long id, String name, Long channel, Integer type, Boolean isUpdate) {
        return null;
    }

    @Override
    public Boolean checkHadSecondCategory(Long id) {
        return null;
    }

    @Override
    public Boolean checkHadKeepWatchPoint(Long id) {
        return null;
    }

    @Override
    public Integer getCategoryCountByParam(CategorySearchVo categorySearchVo) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Integer refEquipmentCount(Long id) {
        return null;
    }
}
