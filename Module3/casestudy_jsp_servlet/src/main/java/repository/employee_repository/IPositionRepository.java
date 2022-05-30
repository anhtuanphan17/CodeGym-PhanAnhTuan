package repository.employee_repository;

import javafx.geometry.Pos;
import model.employee.Position;

import java.util.List;

public interface IPositionRepository {
    Position selectPositionById(int id);

    List<Position> selectAllPosition();
}
