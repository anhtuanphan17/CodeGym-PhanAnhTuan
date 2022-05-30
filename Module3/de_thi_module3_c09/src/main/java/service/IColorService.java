package service;

import model.Color;

import java.util.List;

public interface IColorService {
    Color selectColorById(int id);

    List<Color> selectAllColor();
}
