package com.interview.vaccines.repositories;

import com.interview.vaccines.domain.Vaccine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {

    @Query("SELECT v FROM Vaccine v WHERE v.subjectAge > :age")
    List<Vaccine> findPatientsOlderThan(@Param("age") int age);

    @Query("SELECT v FROM Vaccine v WHERE v.subjectSocialSecurityNumber LIKE %:substring%")
    List<Vaccine> findSsnContains(@Param("substring") String substring);
}
