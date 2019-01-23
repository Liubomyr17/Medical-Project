package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.PatientData;
import com.uni.medical.umdiagnostic.service.PatientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patientData")
public class PatientDataController {

    @Autowired
    private PatientDataService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PatientData>> getAllPatientData() {
        List<PatientData> patientDataList = service.getAllPatientData();
        if (patientDataList.size() == 0) {
            return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PatientData>>(patientDataList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PatientData> getPatientDataById(@PathVariable("id") int id) {
        PatientData data = service.getPatientDataById(id);
        if (data == null) {
            return new ResponseEntity("Patient data with id = " + id + " is not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<PatientData>(data, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> savePatientData(@RequestBody PatientData patientData) {
        if (service.isPatientDataExist(patientData)) {
            return new ResponseEntity("Unable to create. A patient data already exists!", HttpStatus.CONFLICT);
        }
        long id = service.savePatientData(patientData);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientData> updatePatientData(@PathVariable("id") int id, @RequestBody PatientData patientData) {
        PatientData currentData = this.service.updatePatientData(new Long(id), patientData);
        return new ResponseEntity<>(currentData, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePatientDataById(@PathVariable("id") int id) {
        if (!service.isPatientDataExist(id)) {
            return new ResponseEntity("Unable to delete. Patient card with id = " + id + " not found!", HttpStatus.CONFLICT);
        }
        service.deletePatientDataById(id);
        return new ResponseEntity("Patient card with id = " + id + " deleted!", HttpStatus.NO_CONTENT);
    }
}