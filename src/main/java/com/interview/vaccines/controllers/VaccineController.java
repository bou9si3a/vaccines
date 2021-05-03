package com.interview.vaccines.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.interview.vaccines.domain.Vaccine;
import com.interview.vaccines.repositories.VaccineRepository;
import com.interview.vaccines.utils.StringUtils;
import com.interview.vaccines.views.VaccineViews;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VaccineController {

    private final VaccineRepository vaccineRepository;

    public VaccineController(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @JsonView(VaccineViews.MinimalView.class)
    @GetMapping("/vaccines")
    public List<Vaccine> getAllVaccines() {
        return getVaccines();
    }

    @GetMapping("/vaccines/searchByName")
    public List<Vaccine> searchByName(@RequestParam(name = "name") String name) {
        List<Vaccine> results = getVaccines();
        return results
                .stream()
                .filter(vaccine -> vaccine.getSubjectFirstName() == name || vaccine.getSubjectLastName() == name)
                .collect(Collectors.toList());
    }

    @GetMapping("/vaccines/minAge/{minAge}")
    public List<Vaccine> getByMinAge(@PathVariable Integer minAge) {
        return vaccineRepository.findPatientsOlderThan(minAge);
    }

    @GetMapping("/vaccines/ssnContains/{substring}")
    public List<Vaccine> getBySsnContains(@PathVariable String substring) {
        return vaccineRepository.findSsnContains(substring);
    }

    @GetMapping("/vaccines/ssnDivisibleBy")
    public List<Vaccine> getSsnDivisibleBy() {
        List<Vaccine> results = getVaccines();
        return results
                .stream()
                .filter(vaccine -> isDivisibleBy(vaccine.getSubjectSocialSecurityNumber(), number))
                .collect(Collectors.toList());
    }

    @GetMapping("/vaccines/palindromes")
    public List<Vaccine> getPalindromes() {
        return getVaccines().stream().filter(this::isEitherNamesPalindrome).collect(Collectors.toList());
    }

    @JsonView(VaccineViews.DetailView.class)
    @GetMapping("/vaccines/{id}")
    public Vaccine getVaccine(@PathVariable String id) {
        Optional<Vaccine> result = vaccineRepository.findById(Long.parseLong(id));
        return result.orElse(null);
    }

    private List<Vaccine> getVaccines() {
        List<Vaccine> results = new ArrayList<>();
        vaccineRepository.findAll().forEach(results::add);
        return results;
    }

    private boolean isDivisibleBy(String ssn, int number) {
        return StringUtils.toInteger(ssn) % number == 0;
    }

    private boolean isEitherNamesPalindrome(Vaccine vaccine) {
        return StringUtils.isPalindrome(vaccine.getSubjectFirstName()) ||
                StringUtils.isPalindrome(vaccine.getSubjectLastName());
    }
}
