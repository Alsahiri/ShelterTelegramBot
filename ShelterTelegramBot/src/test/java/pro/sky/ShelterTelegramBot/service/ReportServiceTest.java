package pro.sky.ShelterTelegramBot.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pro.sky.ShelterTelegramBot.model.Client;
import pro.sky.ShelterTelegramBot.model.Pet;
import pro.sky.ShelterTelegramBot.model.Report;
import pro.sky.ShelterTelegramBot.repository.PetRepository;
import pro.sky.ShelterTelegramBot.repository.ReportRepository;
import pro.sky.ShelterTelegramBot.service.impl.PetServiceImpl;
import pro.sky.ShelterTelegramBot.service.impl.ReportServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportServiceImpl reportService;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void addTest() throws IOException {
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");


        when(reportRepository.save(report)).thenReturn(report);
        assertNotNull(reportService.create(report));
        assertEquals(report, reportService.create(report));
    }

    @Test
    public void delTest() throws IOException {
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");


        when(reportRepository.findById(1L)).thenReturn(Optional.of(report));


        reportService.delete(1L);


        verify(reportRepository, Mockito.times(1)).delete(report);
    }


    @Test
    public void getTest() throws IOException {
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");


        when(reportRepository.findById(1L)).thenReturn(Optional.of(report));
        assertNotNull(reportService.get(1L));
        assertEquals(report, reportService.get(1L));
    }


    @Test
    void getAll() {
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");
        Report report2=new Report("g", LocalDate.now().format(FORMATTER),0,"На проверке");
        List<Report> reports = Arrays.asList(report, report2);

        Mockito.when(reportRepository.findAll()).thenReturn(reports);


        Assert.assertEquals(reports, reportRepository.findAll());
    }

    @Test
    void findReportByNameTest() {
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");
        String reportName= "qq";


        Mockito.when(reportRepository.findReportByName(reportName)).thenReturn(report);
        reportService.findReportByName(reportName);
    }



    @Test
    public void testUpdateWithClient() {

        Client client=Mockito.mock(Client.class);
        Report report=Mockito.mock(Report.class);
        when(reportRepository.save(report)).thenReturn(report);
        reportService.updateWithClient(client,report);
    }

}
