package com.softwareacademy.sprint1.p9jb.controller;

import java.util.List;

import com.softwareacademy.sprint1.p9jb.exceptions.AlreadyExistsException;
import com.softwareacademy.sprint1.p9jb.exceptions.DoesNotExistsException;
import com.softwareacademy.sprint1.p9jb.model.Patient;
import com.softwareacademy.sprint1.p9jb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        List<Patient> findAll = patientService.getAllPatients();
        return findAll;
    }

    @GetMapping("/patient")
    public Patient getPatientByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws DoesNotExistsException {
        Patient patient = patientService.getPatient(firstName, lastName);
        return patient;
    }

    @PostMapping("/patient/add")
    public ResponseEntity<Object> addPatient(@RequestBody Patient patient) {
        try {
            Patient createdPatient = patientService.createPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/patient")
    public Patient updatePatient(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestBody Patient patientUpdated) throws DoesNotExistsException {
        Patient patientToUpdate = patientService.getPatient(firstName, lastName);
        return patientService.updatePatient(patientToUpdate, patientUpdated);
    }

}
