package com.dethimodule5backend.service;

import com.dethimodule5backend.model.DanhMuc;

import java.util.List;

public interface IDanhMucService {
    List<DanhMuc> findAllDanhMuc();
}
