package com.pharmacodia.dg.framework.dbservice;

import com.pharmacodia.dg.framework.datamodel.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by foy on 2016-06-07.
 */
@Service
public interface ICategoryService {
    public boolean save(Category category);
    public boolean update(Category category);
    public boolean delete(long id);
    public Category get(long id);
    public List<Category> all();
}
