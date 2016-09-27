package com.pharmacodia.dg.framework.dbservice.impl;

import com.pharmacodia.dg.framework.datamodel.Category;
import com.pharmacodia.dg.framework.dao.CategoryMapper;
import com.pharmacodia.dg.framework.dbservice.ICategoryService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by foy on 2016-06-07.
 */
@Service("categoryService")
public class CategoryImpl implements ICategoryService {

    @Resource(name = "frameworkSqlSession")
    private SqlSession frameworkSqlSession;

    @Override
    @Transactional
    public boolean save(Category category) {
        CategoryMapper cm=frameworkSqlSession.getMapper(CategoryMapper.class);
        if(category.getParentCategoryId() !=null ){
            Category pc=get(category.getParentCategoryId());
            category.setPathStr(pc.getPathStr()+"/"+pc.getCategoryId());
        }
        cm.insertSelective(category);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        CategoryMapper cm=frameworkSqlSession.getMapper(CategoryMapper.class);
        cm.updateByPrimaryKeySelective(category);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        CategoryMapper cm=frameworkSqlSession.getMapper(CategoryMapper.class);
        cm.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public Category get(long id) {
        CategoryMapper cm=frameworkSqlSession.getMapper(CategoryMapper.class);
        return cm.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> all() {
        CategoryMapper cm=frameworkSqlSession.getMapper(CategoryMapper.class);
        return cm.listAll();
    }
}
