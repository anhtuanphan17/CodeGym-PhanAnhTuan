package service.impl;

import model.Sach;
import repository.ISachRepo;
import repository.impl.SachRepo;
import service.ISachService;

import java.util.List;

public class SachService implements ISachService {
    ISachRepo sachRepo = new SachRepo();

    @Override
    public List<Sach> findAllSach() {
        return sachRepo.findAllSach();
    }

    @Override
    public Sach findSachById(Integer sachId) {
        return sachRepo.findSachById(sachId);
    }
}
