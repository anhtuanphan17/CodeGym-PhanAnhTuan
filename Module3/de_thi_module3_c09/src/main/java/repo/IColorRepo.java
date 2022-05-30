package repo;

import model.Color;

import java.util.List;

public interface IColorRepo {
    Color selectColorById(int id);

    List<Color> selectAllColor();
}
