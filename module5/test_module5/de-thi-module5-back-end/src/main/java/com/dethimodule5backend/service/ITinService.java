package com.dethimodule5backend.service;

import com.dethimodule5backend.model.Tin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface ITinService {
    Page<Tin> findAllTin(Pageable pageable);

    Tin findById(Integer id);

    void saveTin(Tin tin);

    void deleteById(Integer id);

    Page<Tin> searchByAll( String huong, Pageable pageable);

}
