package com.interview.vaccines.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.interview.vaccines.domain.Vaccine;
import com.interview.vaccines.repositories.VaccineRepository;
import com.interview.vaccines.views.VaccineViews;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VaccineController {

    private final VaccineRepository vaccineRepository;

    public VaccineController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @JsonView(VaccineViews.MinimalView.class)
    @GetMapping("/vaccines")
    public List<Vaccine> getVaccines() {
        List<Vaccine> results = new ArrayList<>();
        vaccineRepository.findAll().forEach(results::add);
        return results;
    }

    @JsonView(VaccineViews.DetailView.class)
    @GetMapping("/vaccines/{id}")
    public Vaccine getVaccine(@PathVariable String id) {
        Optional<Vaccine> result = vaccineRepository.findById(Long.parseLong(id));
        return result.orElse(null);
    }
}
