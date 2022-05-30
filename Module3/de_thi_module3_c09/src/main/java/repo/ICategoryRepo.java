package repo;

import model.Category;
import model.Color;

import java.util.List;

public interface ICategoryRepo {
    Category selectCategoryById(int id);

    List<Category> selectAllCategory();
}
