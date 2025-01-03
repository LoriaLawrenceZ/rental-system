package com.rental.service;

import com.rental.Woman;
import com.rental.repository.WomanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WomanService {

    @Autowired
    private WomanRepository womanRepository;

    public List<Woman> getAllWomen() {
        return womanRepository.findAll();
    }

    public Optional<Woman> getWomanById(int id) {
        return womanRepository.findById(id);
    }

    public Woman createWoman(Woman woman) {
        return womanRepository.save(woman);
    }

    public Woman updateWoman(int id, Woman woman) {
        Optional<Woman> existingWoman = womanRepository.findById(id);
        if (existingWoman.isPresent()) {
            Woman updatedWoman = existingWoman.get();
            updatedWoman.setName(woman.getName());
            updatedWoman.setMood(woman.getMood());
            updatedWoman.setBreastSize(woman.getBreastSize());
            updatedWoman.setWaistSize(woman.getWaistSize());
            updatedWoman.setHipSize(woman.getHipSize());
            return womanRepository.save(updatedWoman);
        } else {
            return null;
        }
    }

    public void deleteWoman(int id) {
        womanRepository.deleteById(id);
    }
}
