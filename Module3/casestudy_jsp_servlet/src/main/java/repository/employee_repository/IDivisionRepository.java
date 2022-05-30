package repository.employee_repository;

import model.employee.Division;

import java.util.List;

public interface IDivisionRepository {
    Division selectDivisionById(int id);

    List<Division> selectAllDivision();
}
