package com.dethimodule5backend.controller;

import com.dethimodule5backend.model.DanhMuc;
import com.dethimodule5backend.model.Tin;
import com.dethimodule5backend.service.IDanhMucService;
import com.dethimodule5backend.service.ITinService;
import net.bytebuddy.implementation.bind.annotation.Default;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tin")
public class TinController {

    @Autowired
    ITinService tinService;

    @Autowired
    IDanhMucService danhMucService;

//    @GetMapping("")
//    public ResponseEntity<Page<Tin>> getAllTin(@PageableDefault(value = 2) Pageable pageable) {
//        Page<Tin> tinPage = this.tinService.findAllTin(pageable);
//        return new ResponseEntity<>(tinPage, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<Page<Tin>> listBaiDang(@RequestParam(required = false, defaultValue = "") String huong,
                                                     @PageableDefault(value = 2) Pageable pageable) {

//        Sort sort = Sort.by("ngayDang").descending();
//        if (sortSelect.equals("DESC")) {
//            sort = Sort.by("gia").descending();
//        } else if (sortSelect.equals("ASC")) {
//            sort = Sort.by("gia").ascending();
//        }

        Page<Tin> tinPage = this.tinService.searchByAll(huong,pageable);
        return new ResponseEntity<>(tinPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tin> findTinById(@PathVariable Integer id) {
        Tin tin = this.tinService.findById(id);
        if (tin == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tin, HttpStatus.OK);
    }

    @GetMapping("/danhMuc")
    public ResponseEntity<List<DanhMuc>> findAllDanhMuc() {
        List<DanhMuc> danhMucList = this.danhMucService.findAllDanhMuc();
        return new ResponseEntity<>(danhMucList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createTin(@RequestBody Tin tin) {
        this.tinService.saveTin(tin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editTin(@PathVariable Integer id, @RequestBody Tin tin) {
        if (this.tinService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.tinService.saveTin(tin);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTin(@PathVariable Integer id) {
        this.tinService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
