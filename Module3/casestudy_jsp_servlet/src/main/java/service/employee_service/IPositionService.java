package service.employee_service;

import model.employee.Position;

import java.util.List;

public interface IPositionService {
    Position selectPositionById(int id);

    List<Position> selectAllPosition();

}
