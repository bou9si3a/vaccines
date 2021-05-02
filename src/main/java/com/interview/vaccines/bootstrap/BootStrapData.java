package com.interview.vaccines.bootstrap;

import com.interview.vaccines.domain.Vaccine;
import com.interview.vaccines.domain.VaccineType;
import com.interview.vaccines.repositories.VaccineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class BootStrapData implements CommandLineRunner {

    private final VaccineRepository vaccineRepository;

    public BootStrapData(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public void run(String... args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(
                LocalDate.of(2021, 3, 16),
                LocalTime.of(9, 0, 0, 0)
        );
        LocalDateTime localDateTime2 = LocalDateTime.of(
                LocalDate.of(2021, 3, 17),
                LocalTime.of(9, 30, 0, 0)
        );
        LocalDateTime localDateTime3 = LocalDateTime.of(
                LocalDate.of(2021, 3, 16),
                LocalTime.of(9, 30, 0, 0)
        );
        LocalDateTime localDateTime4 = LocalDateTime.of(
                LocalDate.of(2021, 3, 17),
                LocalTime.of(9, 0, 0, 0)
        );
        LocalDateTime localDateTime5 = LocalDateTime.of(
                LocalDate.of(2021, 4, 18),
                LocalTime.of(9, 30, 0, 0)
        );
        LocalDateTime localDateTime6 = LocalDateTime.of(
                LocalDate.of(2021, 4, 18),
                LocalTime.of(11, 30, 0, 0)
        );
        LocalDateTime localDateTime7 = LocalDateTime.of(
                LocalDate.of(2021, 4, 20),
                LocalTime.of(16, 30, 0, 0)
        );
        LocalDateTime localDateTime8 = LocalDateTime.of(
                LocalDate.of(2021, 5, 17),
                LocalTime.of(9, 30, 0, 0)
        );
        Vaccine vaccine1 = new Vaccine(
                "firstName1", "lastName1", 63, localDateTime1, VaccineType.Moderna, localDateTime5
        );
        Vaccine vaccine2 = new Vaccine(
                "firstName2", "lastName2", 72, localDateTime2, VaccineType.Pfizer, localDateTime6
        );
        Vaccine vaccine3 = new Vaccine(
                "firstName3", "lastName3", 58, localDateTime3, VaccineType.Astrazeneca, localDateTime7
        );
        Vaccine vaccine4 = new Vaccine(
                "firstName4", "lastName4", 49, localDateTime4, VaccineType.Moderna, localDateTime8
        );
        Vaccine vaccine5 = new Vaccine(
                "firstName5", "lastName5", 88, localDateTime5, VaccineType.Pfizer, null
        );
        Vaccine vaccine6 = new Vaccine(
                "firstName6", "lastName6", 59, localDateTime6, VaccineType.Astrazeneca, null
        );
        Vaccine vaccine7 = new Vaccine(
                "firstName7", "lastName7", 61, localDateTime7, VaccineType.Astrazeneca, null
        );
        Vaccine vaccine8 = new Vaccine(
                "firstName8", "lastName8", 77, localDateTime8, VaccineType.Moderna, null
        );
        vaccineRepository.save(vaccine1);
        vaccineRepository.save(vaccine2);
        vaccineRepository.save(vaccine3);
        vaccineRepository.save(vaccine4);
        vaccineRepository.save(vaccine5);
        vaccineRepository.save(vaccine6);
        vaccineRepository.save(vaccine7);
        vaccineRepository.save(vaccine8);
    }
}
