package com.dethimodule5backend.repository;

import com.dethimodule5backend.model.Tin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITinRepository extends JpaRepository<Tin, Integer> {
    Page<Tin> findAllByHuongContaining(String huong, Pageable pageable);
}
