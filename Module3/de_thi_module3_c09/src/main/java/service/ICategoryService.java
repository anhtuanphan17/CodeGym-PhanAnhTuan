package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    Category selectCategoryById(int id);

    List<Category> selectAllCategory();
}
