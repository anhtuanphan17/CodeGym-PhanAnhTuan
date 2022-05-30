package service.employee_service;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    EducationDegree selectEducationDegreeById(int id);

    List<EducationDegree> selectAllEducationDegree();
}
