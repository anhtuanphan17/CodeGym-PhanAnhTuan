package service.employee_service.impl;

import model.employee.Position;
import repository.employee_repository.IPositionRepository;
import repository.employee_repository.impl.PositionRepository;
import service.employee_service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    IPositionRepository positionRepository = new PositionRepository();

    @Override
    public Position selectPositionById(int id) {
        return positionRepository.selectPositionById(id);
    }

    @Override
    public List<Position> selectAllPosition() {
        return positionRepository.selectAllPosition();
    }
}
