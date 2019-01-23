package com.uni.medical.umdiagnostic.dao;

import com.uni.medical.umdiagnostic.dao.entity.AppointmentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentReportRepository extends JpaRepository<AppointmentReport, Long> {
    AppointmentReport findAppointmentReportByAppointmentId(long patientId);
}