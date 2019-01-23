package com.uni.medical.umdiagnostic.service;

import com.uni.medical.umdiagnostic.dao.entity.AppointmentReport;

import java.util.List;

public interface AppointmentReportService {

    List<AppointmentReport> getAllAppointmentReport();
    AppointmentReport getAppointmentReportById(long id);
    long saveAppointmentReport(AppointmentReport appointmentReport);
    AppointmentReport updateAppointmentReport(Long id, AppointmentReport aprt);
    void deleteAppointmentReportById(long id);
    boolean isAppointmentReportExist(long id);
    boolean isAppointmentReportExist(AppointmentReport report);
}
