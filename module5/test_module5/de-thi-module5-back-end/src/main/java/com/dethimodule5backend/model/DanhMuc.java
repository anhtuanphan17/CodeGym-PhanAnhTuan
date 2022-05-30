package com.dethimodule5backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer danhMucId;
    private String tenDanhMuc;

    @JsonBackReference
    @OneToMany(mappedBy = "danhMuc")
    private Set<Tin> tin;

    public DanhMuc() {
    }

    public Integer getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(Integer danhMucId) {
        this.danhMucId = danhMucId;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<Tin> getTin() {
        return tin;
    }

    public void setTin(Set<Tin> tin) {
        this.tin = tin;
    }

}
