package com.softwareacademy.sprint1.p9jb.service;

import java.util.List;
import java.util.Optional;

import com.softwareacademy.sprint1.p9jb.exceptions.AlreadyExistsException;
import com.softwareacademy.sprint1.p9jb.exceptions.DoesNotExistsException;
import com.softwareacademy.sprint1.p9jb.model.Patient;
import com.softwareacademy.sprint1.p9jb.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) throws AlreadyExistsException {
        if(patientRepository.findByFirstNameAndLastName(patient.getFirstName(), patient.getLastName()).isPresent())
            throw new AlreadyExistsException(patient.getFirstName() + " " + patient.getLastName() + " already exists");
        return patientRepository.save(patient);
    }

    public Patient getPatient(String firstName, String lastName) throws DoesNotExistsException {
        Optional<Patient> optionalPatient = patientRepository.findByFirstNameAndLastName(firstName, lastName);
        if( ! optionalPatient.isPresent()) {
            throw new DoesNotExistsException(firstName + " " + lastName + " does not exists");
        }
        return optionalPatient.get();
    }

    public List<Patient> getAllPatients() {
        List<Patient> allPatients = patientRepository.findAll();
        return allPatients;
    }

    public Patient updatePatient(Patient patientToUpdate, Patient patientUpdated) throws DoesNotExistsException {
        Patient currentPatient = patientToUpdate;
        currentPatient.setLastName(patientUpdated.getLastName());
        currentPatient.setFirstName(patientUpdated.getFirstName());
        currentPatient.setBirthdate(patientUpdated.getBirthdate());
        currentPatient.setGender(patientUpdated.getGender());
        currentPatient.setAddress(patientUpdated.getAddress());
        currentPatient.setPhone(patientUpdated.getPhone());
        return patientRepository.save(currentPatient);
    }
}
