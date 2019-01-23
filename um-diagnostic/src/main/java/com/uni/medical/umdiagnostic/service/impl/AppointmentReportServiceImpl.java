package com.uni.medical.umdiagnostic.service.impl;

import com.uni.medical.umdiagnostic.dao.AppointmentReportRepository;
import com.uni.medical.umdiagnostic.dao.entity.AppointmentReport;
import com.uni.medical.umdiagnostic.service.AppointmentReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AppointmentReportServiceImpl implements AppointmentReportService {

    @Autowired
    private AppointmentReportRepository repository;

    @Override
    public List<AppointmentReport> getAllAppointmentReport() {
        return repository.findAll();
    }

    @Override
    public AppointmentReport getAppointmentReportById(long id) {
        return repository.findOne(id);
    }

    @Override
    public long saveAppointmentReport(AppointmentReport appointmentReport) {
        AppointmentReport report = repository.save(appointmentReport);
        return report.getId();
    }

    @Override
    public AppointmentReport updateAppointmentReport(Long id, AppointmentReport aprt) {
        AppointmentReport currentReport = repository.findOne(id);
        if (currentReport == null) {
            throw new RuntimeException("could not find report by id:" + id);
        }
        currentReport.setAppointmentId(aprt.getAppointmentId());
        currentReport.setTreatmentId(aprt.getTreatmentId());
        currentReport.setAnamnesis(aprt.getAnamnesis());
        currentReport.setReportMessage(aprt.getReportMessage());
        this.repository.save(currentReport);
       return currentReport;
    }

    @Override
    public void deleteAppointmentReportById(long id) {
        repository.delete(id);
    }

    @Override
    public boolean isAppointmentReportExist(long id) {
        return repository.findOne(id) != null ? true : false;
    }

    @Override
    public boolean isAppointmentReportExist(AppointmentReport report) {
        return false;
    }
}