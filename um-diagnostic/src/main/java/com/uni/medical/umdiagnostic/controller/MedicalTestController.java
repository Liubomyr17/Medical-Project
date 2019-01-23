package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.MedicalTest;
import com.uni.medical.umdiagnostic.service.MedicalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalTest")
public class MedicalTestController {

    @Autowired
    private MedicalTestService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MedicalTest>> getAllMedicalTest() {
        List<MedicalTest> medicalTestList = service.getAllMedicalTest();
        if (medicalTestList.size() == 0) {
            return new ResponseEntity("No tests found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<MedicalTest>>(medicalTestList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MedicalTest> getMedicalTestById(@PathVariable("id") int id) {
        MedicalTest test = service.getMedicalTestById(id);
        if (test == null) {
            return new ResponseEntity("Medical test with id = " + id + " is not found", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<MedicalTest>(test, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveMedicalTest(@RequestBody MedicalTest medicalTest) {
        if (service.isMedicalTestExist(medicalTest)) {
            return new ResponseEntity("Unable to create. A medical test already exists!", HttpStatus.CONFLICT);
        }
        long id = service.saveMedicalTest(medicalTest);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalTest> updateMedicalTest(@PathVariable("id") int id, @RequestBody MedicalTest medicalTest) {
        MedicalTest currentTest = this.service.updateMedicalTest(new Long(id), medicalTest);
        return new ResponseEntity<>(currentTest, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMedicalTestById(@PathVariable("id") int id) {
        if (!service.isMedicalTestExist(id)) {
            return new ResponseEntity("Unable to delete. Medical test with id = " + id + " not found!", HttpStatus.CONFLICT);
        }

        service.deleteMedicalTestById(id);
        return new ResponseEntity("Medical test with id = " + id + " deleted!", HttpStatus.NO_CONTENT);
    }
}