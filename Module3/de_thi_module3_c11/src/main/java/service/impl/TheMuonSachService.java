package service.impl;

import model.TheMuonSach;
import repository.ITheMuonSachRepo;
import repository.impl.TheMuonSachRepo;
import service.ITheMuonSachService;

import java.util.List;

public class TheMuonSachService implements ITheMuonSachService {
    ITheMuonSachRepo theMuonSachRepo = new TheMuonSachRepo();

    @Override
    public List<TheMuonSach> findAllTheMuonSach() {
        return theMuonSachRepo.findAllTheMuonSach();
    }
}
