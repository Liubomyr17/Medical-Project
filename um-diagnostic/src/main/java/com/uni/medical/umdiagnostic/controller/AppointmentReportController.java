package com.uni.medical.umdiagnostic.controller;

import com.uni.medical.umdiagnostic.dao.entity.AppointmentReport;
import com.uni.medical.umdiagnostic.service.AppointmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointmentReport")
public class AppointmentReportController {

    @Autowired
    private AppointmentReportService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentReport>> getAllAppointmentReport() {
        List<AppointmentReport> appointmentReportList = service.getAllAppointmentReport();
        if (appointmentReportList.size() == 0) {
            return new ResponseEntity("No appointments found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<AppointmentReport>>(appointmentReportList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AppointmentReport> getAppointmentReportById(@PathVariable("id") int id) {
        AppointmentReport report = service.getAppointmentReportById(id);
        if (report == null) {
            return new ResponseEntity("Appointment report with id = " + id + " is not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<AppointmentReport>(report, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveAppointmentReport(@RequestBody AppointmentReport appointmentReport) {
        if (service.isAppointmentReportExist(appointmentReport)) {
            return new ResponseEntity("Unable to create. An appointment report already exists!", HttpStatus.CONFLICT);
        }
        long id = service.saveAppointmentReport(appointmentReport);
        return new ResponseEntity<Long>(new Long(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentReport> updateAppointmentReport(@PathVariable("id") int id, @RequestBody AppointmentReport appointmentReport){
        AppointmentReport currentReport = this.service.updateAppointmentReport(new Long(id), appointmentReport);
        return new ResponseEntity<>(currentReport, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointmentReportById(@PathVariable("id") int id) {
        if (!service.isAppointmentReportExist(id)) {
            return new ResponseEntity("Unable to delete. Appointment report with id = " + id + " not found!", HttpStatus.CONFLICT);
        }

        service.deleteAppointmentReportById(id);
        return new ResponseEntity("Appointment report with id = " + id + " deleted!", HttpStatus.NO_CONTENT);
    }
}