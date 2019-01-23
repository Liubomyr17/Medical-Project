package com.uni.medical.umdiagnostic.junit;

import com.uni.medical.umdiagnostic.dao.AppointmentReportRepository;
import com.uni.medical.umdiagnostic.dao.entity.AppointmentReport;
import com.uni.medical.umdiagnostic.service.impl.AppointmentReportServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentReportServiceImplTest {


    @Autowired
    private AppointmentReportServiceImpl appointmentReportServiceImpl;

    @MockBean
    private AppointmentReportRepository repository;

    @Test
    public void testGetAllAppointmentReport() {
        AppointmentReport appointmentReport1 = new AppointmentReport();
        appointmentReport1.setId(new Long(18));
        appointmentReport1.setAnamnesis("surgery");
        appointmentReport1.setAppointmentId(new Long(1261));
        appointmentReport1.setReportMessage("brain surgers");
        appointmentReport1.setTreatmentId(new Long(1));

        AppointmentReport appointmentReport2 = new AppointmentReport();
        appointmentReport1.setId(new Long(24));
        appointmentReport2.setAnamnesis("surgery");
        appointmentReport2.setAppointmentId(new Long(12));
        appointmentReport2.setReportMessage("brain intervation");
        appointmentReport2.setTreatmentId(new Long(1));

        List<AppointmentReport> appointmentReportList = new ArrayList<>();
        appointmentReportList.add(appointmentReport1);
        appointmentReportList.add(appointmentReport2);

        Mockito.when(repository.findAll()).thenReturn(appointmentReportList);
        assertThat(appointmentReportServiceImpl.getAllAppointmentReport()).isEqualTo(appointmentReportList);
    }


    @Test
    public void testGetAllAppointmentReportById() {
        AppointmentReport appointmentReport = new AppointmentReport();
        appointmentReport.setId((long)24);
        appointmentReport.setAnamnesis("surgery");
        appointmentReport.setAppointmentId((long)12);
        appointmentReport.setReportMessage("brain intervation");
        appointmentReport.setTreatmentId((long)1);

        Mockito.when(repository.findOne(new Long(12))).thenReturn(appointmentReport);
        assertThat(appointmentReportServiceImpl.getAppointmentReportById(12)).isEqualTo(appointmentReport);
    }

    @Test
    public void testSaveAppointmentReport() {
        AppointmentReport appointmentReport = new AppointmentReport();
        appointmentReport.setId((long)2);
        appointmentReport.setAnamnesis("anea");
        appointmentReport.setAppointmentId((long)20);
        appointmentReport.setReportMessage("brain");
        appointmentReport.setTreatmentId((long)5);

        Mockito.when(repository.save(appointmentReport)).thenReturn(appointmentReport);
        assertThat(appointmentReportServiceImpl.saveAppointmentReport(appointmentReport)).isEqualTo(appointmentReport.getId());
    }

    @Test
    public void testUpdateAppointmentReport() {
        AppointmentReport currentReport = new AppointmentReport();
        currentReport.setId((long)4);
        currentReport.setAnamnesis("hospitalization");
        currentReport.setAppointmentId((long)4);
        currentReport.setReportMessage("brain");
        currentReport.setTreatmentId((long)5);

        Mockito.when(repository.findOne(new Long(3))).thenReturn(currentReport);

        currentReport.setReportMessage("brain");
        Mockito.when(repository.save(currentReport)).thenReturn(currentReport);

        assertThat(appointmentReportServiceImpl.updateAppointmentReport(new Long(3), new AppointmentReport("cerveau"))).isEqualTo(currentReport);
    }

    @Test
    public void testDeleteAppointmentReportById() {
        AppointmentReport report = new AppointmentReport();

        Mockito.when(repository.findOne((long)4)).thenReturn(report);
        Mockito.when(repository.exists(report.getAppointmentId())).thenReturn(false);
        assertFalse(repository.exists(report.getAppointmentId()));
    }


    @Test
    public void isAppointmentReportExist() {
        AppointmentReport appointmentReport = new AppointmentReport();

        appointmentReport.setId( new Long( 2 ) );
        appointmentReport.setAnamnesis( "surgeries" );
        appointmentReport.setAppointmentId( new Long( 18 ) );
        appointmentReport.setReportMessage( "annexes" );
        appointmentReport.setTreatmentId( new Long( 52 ) );

        Mockito.when( repository.findOne( new Long( 4 ) ) ).thenReturn( appointmentReport );
        assertThat( appointmentReportServiceImpl.isAppointmentReportExist( new Long( 4 ) ) ).isEqualTo( true );
    }

    @Test
    public void isAppointmentReportExist1() {

        AppointmentReport report  = Mockito.mock( AppointmentReport.class );

        Mockito.when(repository.findOne(new Long( 48 ) )).thenReturn( report );

        Mockito.when(repository.exists( report.getId() )).thenReturn( false );
        assertFalse(repository.exists( report.getId() ));
    }
}