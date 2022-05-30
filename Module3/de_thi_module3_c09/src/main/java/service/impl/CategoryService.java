package service.impl;

import model.Category;
import repo.ICategoryRepo;
import repo.impl.CategoryRepo;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public Category selectCategoryById(int id) {
        return categoryRepo.selectCategoryById(id);
    }

    @Override
    public List<Category> selectAllCategory() {
        return categoryRepo.selectAllCategory();
    }
}
