package com.dethimodule5backend.repository;

import com.dethimodule5backend.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
