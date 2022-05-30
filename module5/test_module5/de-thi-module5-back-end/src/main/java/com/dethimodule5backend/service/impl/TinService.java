package com.dethimodule5backend.service.impl;

import com.dethimodule5backend.model.Tin;
import com.dethimodule5backend.repository.ITinRepository;
import com.dethimodule5backend.service.ITinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TinService implements ITinService {

    @Autowired
    ITinRepository tinRepository;

    @Override
    public Page<Tin> findAllTin(Pageable pageable) {
        return tinRepository.findAll(pageable);
    }

    @Override
    public Tin findById(Integer id) {
        return tinRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTin(Tin tin) {
        this.tinRepository.save(tin);
    }

    @Override
    public void deleteById(Integer id) {
        this.tinRepository.deleteById(id);
    }

    @Override
    public Page<Tin> searchByAll(String huong, Pageable pageable) {
        return this.tinRepository.findAllByHuongContaining(huong, pageable);
    }
}
