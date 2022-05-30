package com.dethimodule5backend.service.impl;

import com.dethimodule5backend.model.DanhMuc;
import com.dethimodule5backend.repository.IDanhMucRepository;
import com.dethimodule5backend.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {

    @Autowired
    IDanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> findAllDanhMuc() {
        return danhMucRepository.findAll();
    }
}
