package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.MedicalMeasurement;
import com.uni.medical.umdiagnostic.service.MedicalMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalMeasurement")

public class MedicalMeasurementController {

    @Autowired
    private MedicalMeasurementService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MedicalMeasurement>> getAllMedicalMeasurement() {
        List<MedicalMeasurement> medicalMeasurementList = service.getAllMedicalMeasurement();
        if (medicalMeasurementList.size() == 0) {
            return new ResponseEntity("No measurements found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<MedicalMeasurement>>(medicalMeasurementList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MedicalMeasurement> getMedicalMeasurementById(@PathVariable("id") int id) {
        MedicalMeasurement measurement = service.getMedicalMeasurementById(id);
        if (measurement == null) {
            return new ResponseEntity("Medical measurement with id = " + id + " is not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<MedicalMeasurement>(measurement, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveMedicalMeasurement(@RequestBody MedicalMeasurement medicalMeasurement) {
        if (service.isMedicalMeasurementExist(medicalMeasurement)) {
            return new ResponseEntity("Unable to create. A medical measurement already exists!", HttpStatus.CONFLICT);
        }
        long id = service.saveMedicalMeasurement(medicalMeasurement);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalMeasurement> updateMedicalMeasurement(@PathVariable("id") int id, @RequestBody MedicalMeasurement medicalMeasurement) {
        MedicalMeasurement currentMeasurement = this.service.updateMedicalMeasurement(new Long(id), medicalMeasurement);
        return new ResponseEntity<>(currentMeasurement, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMedicalMeasurementById(@PathVariable("id") int id) {
        if (!service.isMedicalMeasurementExist(id)) {
            return new ResponseEntity("Unable to delete. Medical measurement with id = " + id + " not found!", HttpStatus.CONFLICT);
        }
        service.deleteMedicalMeasurementById(id);
        return new ResponseEntity("Medical measurement with id = " + id + " deleted!", HttpStatus.NO_CONTENT);
    }
}