package service.impl;

import model.Color;
import repo.IColorRepo;
import repo.impl.ColorRepo;
import service.IColorService;

import java.util.List;

public class ColorService implements IColorService {
    IColorRepo colorRepo =new ColorRepo();

    @Override
    public Color selectColorById(int id) {
        return colorRepo.selectColorById(id);
    }

    @Override
    public List<Color> selectAllColor() {
        return colorRepo.selectAllColor();
    }
}
