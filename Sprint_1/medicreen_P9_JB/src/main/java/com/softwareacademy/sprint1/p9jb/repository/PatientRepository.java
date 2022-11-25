package com.softwareacademy.sprint1.p9jb.repository;

import com.softwareacademy.sprint1.p9jb.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);

}
