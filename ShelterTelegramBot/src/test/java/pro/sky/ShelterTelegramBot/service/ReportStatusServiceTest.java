package pro.sky.ShelterTelegramBot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pro.sky.ShelterTelegramBot.model.ReportBreach;
import pro.sky.ShelterTelegramBot.model.ReportStatus;
import pro.sky.ShelterTelegramBot.repository.ReportStatusRepository;
import pro.sky.ShelterTelegramBot.service.impl.ReportStatusServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ReportStatusServiceTest {
    @Mock
    private ReportStatusRepository reportStatusRepository;

    @InjectMocks
    private ReportStatusServiceImpl reportStatusService;



    @Test
    public void addTest() throws IOException {
        ReportStatus reportStatus=new ReportStatus();


        when(reportStatusRepository.save(reportStatus)).thenReturn(reportStatus);
        assertNotNull(reportStatusService.create(reportStatus));
        assertEquals(reportStatus, reportStatusService.create(reportStatus));
    }

    @Test
    public void delTest() throws IOException {
        ReportStatus reportStatus=new ReportStatus();


        when(reportStatusRepository.findById(1L)).thenReturn(Optional.of(reportStatus));


        reportStatusService.delete(1L);


        verify(reportStatusRepository, Mockito.times(1)).delete(reportStatus);
    }


    @Test
    public void getTest() throws IOException {
        ReportStatus reportStatus=new ReportStatus();


        when(reportStatusRepository.findById(1L)).thenReturn(Optional.of(reportStatus));
        assertNotNull(reportStatusService.get(1L));
        assertEquals(reportStatus, reportStatusService.get(1L));
    }


    @Test
    void getAll() {
        ReportStatus reportStatus=new ReportStatus();
        ReportStatus reportStatus2=new ReportStatus();

        List<ReportStatus> reportStatusArray = Arrays.asList(reportStatus, reportStatus2);

        Collection<ReportStatus> result = Arrays.asList(reportStatus, reportStatus2);

        Mockito.when(reportStatusRepository.findAll()).thenReturn(reportStatusArray);


        assertEquals(reportStatusArray, reportStatusRepository.findAll());
    }
}
