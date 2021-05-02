package com.interview.vaccines.repositories;

import com.interview.vaccines.domain.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
}
