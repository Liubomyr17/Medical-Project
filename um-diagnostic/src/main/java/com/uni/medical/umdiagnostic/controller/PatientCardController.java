package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.PatientCard;
import com.uni.medical.umdiagnostic.service.PatientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patientCard")
public class PatientCardController {

    @Autowired
    private PatientCardService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PatientCard>>getAllPatientCard(){
        List<PatientCard>patientCardList = service.getAllPatientCard();
        if(patientCardList.size()==0){
            return new ResponseEntity ("No cards found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PatientCard>>(patientCardList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PatientCard>getPatientCardById(@PathVariable("id") int id) {
        PatientCard card = service.getPatientCardById(id);
        if (card == null) {
            return new ResponseEntity("Patient card with id = " + id + "is not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<PatientCard>(card, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> savePatientCard(@RequestBody PatientCard patientCard) {
        if (service.isPatientCardExist(patientCard)) {
            return new ResponseEntity("Unable to create. A patient card already exists!", HttpStatus.CONFLICT);
        }
        long id = service.savePatientCard(patientCard);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientCard> updatePatientCard(@PathVariable("id") int id, @RequestBody PatientCard patientCard){
        PatientCard currentCard = this.service.updatePatientCard(new Long(id), patientCard);
        return new ResponseEntity<>(currentCard, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePatientCardById(@PathVariable("id") int id) {
        if (!service.isPatientCardExist(id)) {
            return new ResponseEntity("Unable to delete. Patient card with id = " + id + " not found!", HttpStatus.CONFLICT);
        }
        service.deletePatientCardById(id);
        return new ResponseEntity("Patient card with id = " + id + " deleted!", HttpStatus.NO_CONTENT);
    }
}