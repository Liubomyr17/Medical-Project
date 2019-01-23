package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.TreatmentMethod;
import com.uni.medical.umdiagnostic.service.TreatmentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatmentMethod")
public class TreatmentMethodController {

    @Autowired
    private TreatmentMethodService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<TreatmentMethod>> getAllTreatmentMethod() {
        List<TreatmentMethod> treatmentMethodList = service.getAllTreatmentMethod();
        if (treatmentMethodList.size() == 0) {
            return new ResponseEntity("No methods found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<TreatmentMethod>>(treatmentMethodList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TreatmentMethod> getTreatmentMethodById(@PathVariable("id") int id) {
        TreatmentMethod method = service.getTreatmentMethodById(id);
        if (method == null) {
            return new ResponseEntity("Treatment method with id = " + id + " is not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<TreatmentMethod>(method, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveTreatmentMethod(@RequestBody TreatmentMethod treatmentMethod) {
        if (service.isTreatmentMethodExist(treatmentMethod)) {
            return new ResponseEntity("Unable to create. A treatment method already exists!", HttpStatus.CONFLICT);
        }
        long id = service.saveTreatmentMethod(treatmentMethod);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreatmentMethod> updateTreatmentMethod(@PathVariable("id") int id, @RequestBody TreatmentMethod treatmentMethod){
        TreatmentMethod currentMethod = this.service.updateTreatmentMethod(new Long(id), treatmentMethod);
        return new ResponseEntity<>(currentMethod, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<?> deleteTreatmentMethodById(@PathVariable("id") int id){
        if (!service.isTreatmentMethodExist(id)) {
            return new ResponseEntity("Unable to delete. Treatment method with id = " + id + " not found!", HttpStatus.CONFLICT);
        }
        service.deleteTreatmentMethodById(id);
        return new ResponseEntity<>("Treatment report with id = " + id + "deleted!", HttpStatus.NO_CONTENT);
    }
}