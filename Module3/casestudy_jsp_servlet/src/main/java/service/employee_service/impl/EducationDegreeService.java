package service.employee_service.impl;

import model.employee.EducationDegree;
import repository.employee_repository.IEducationDegreeRepository;
import repository.employee_repository.impl.EducationDegreeRepository;
import service.employee_service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public EducationDegree selectEducationDegreeById(int id) {
      return   educationDegreeRepository.selectEducationDegreeById(id);
    }

    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        return educationDegreeRepository.selectAllEducationDegree();
    }
}
