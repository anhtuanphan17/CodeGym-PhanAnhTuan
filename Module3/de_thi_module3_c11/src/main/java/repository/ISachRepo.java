package repository;

import model.Sach;

import java.util.List;

public interface ISachRepo {
    List<Sach> findAllSach();

    Sach findSachById(Integer sachId);
}
