package service.employee_service.impl;

import model.employee.Division;
import repository.employee_repository.IDivisionRepository;
import repository.employee_repository.impl.DivisionRepository;
import service.employee_service.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public Division selectDivisionById(int id) {
        return divisionRepository.selectDivisionById(id);
    }

    @Override
    public List<Division> selectAllDivision() {
        return divisionRepository.selectAllDivision();
    }
}
