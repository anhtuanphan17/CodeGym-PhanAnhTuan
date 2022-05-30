package repository.employee_repository;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    EducationDegree selectEducationDegreeById(int id);

    List<EducationDegree> selectAllEducationDegree();
}
