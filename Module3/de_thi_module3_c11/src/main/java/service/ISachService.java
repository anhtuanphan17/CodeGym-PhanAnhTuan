package service;

import model.Sach;

import java.util.List;

public interface ISachService {
    List<Sach> findAllSach();

    Sach findSachById(Integer sachId);
}
