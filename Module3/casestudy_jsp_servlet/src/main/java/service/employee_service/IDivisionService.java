package service.employee_service;

import model.employee.Division;

import java.util.List;

public interface IDivisionService {
    Division selectDivisionById(int id);

    List<Division> selectAllDivision();
}
