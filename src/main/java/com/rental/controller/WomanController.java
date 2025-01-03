package com.rental.controller;

import com.rental.Woman;
import com.rental.service.WomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/women")
public class WomanController {

    @Autowired
    private WomanService womanService;

    @GetMapping
    public List<Woman> getAllWomen() {
        return womanService.getAllWomen();
    }

    @GetMapping("/{id}")
    public Woman getWomanById(@PathVariable int id) {
        return womanService.getWomanById(id);
    }

    @PostMapping
    public Woman createWoman(@RequestBody Woman woman) {
        return womanService.createWoman(woman);
    }

    @PutMapping("/{id}")
    public Woman updateWoman(@PathVariable int id, @RequestBody Woman woman) {
        return womanService.updateWoman(id, woman);
    }

    @DeleteMapping("/{id}")
    public void deleteWoman(@PathVariable int id) {
        womanService.deleteWoman(id);
    }
}
