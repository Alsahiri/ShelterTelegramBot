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
import pro.sky.ShelterTelegramBot.model.Pet;
import pro.sky.ShelterTelegramBot.model.ReportBreach;
import pro.sky.ShelterTelegramBot.repository.PetRepository;
import pro.sky.ShelterTelegramBot.repository.ReportBreachRepository;
import pro.sky.ShelterTelegramBot.service.impl.PetServiceImpl;
import pro.sky.ShelterTelegramBot.service.impl.ReportBreachServiceImpl;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
public class ReportBreachServiceTest {

    @Mock
    private ReportBreachRepository reportBreachRepository;

    @InjectMocks
    private ReportBreachServiceImpl reportBreachService;



    @Test
    public void addTest() throws IOException {
        ReportBreach reportBreach=new ReportBreach();


        when(reportBreachRepository.save(reportBreach)).thenReturn(reportBreach);
        assertNotNull(reportBreachService.create(reportBreach));
        assertEquals(reportBreach, reportBreachService.create(reportBreach));
    }

    @Test
    public void delTest() throws IOException {
        ReportBreach reportBreach=new ReportBreach();


        when(reportBreachRepository.findById(1L)).thenReturn(Optional.of(reportBreach));


        reportBreachService.delete(1L);


        verify(reportBreachRepository, Mockito.times(1)).delete(reportBreach);
    }


    @Test
    public void getTest() throws IOException {
        ReportBreach reportBreach=new ReportBreach();


        when(reportBreachRepository.findById(1L)).thenReturn(Optional.of(reportBreach));
        assertNotNull(reportBreachService.get(1L));
        assertEquals(reportBreach, reportBreachService.get(1L));
    }


    @Test
    void getAll() {
        ReportBreach reportBreach=new ReportBreach();
        ReportBreach reportBreach2=new ReportBreach();

        List<ReportBreach> reportBreaches = Arrays.asList(reportBreach, reportBreach2);

        Collection<ReportBreach> result = Arrays.asList(reportBreach, reportBreach2);

        Mockito.when(reportBreachRepository.findAll()).thenReturn(reportBreaches);


        assertEquals(reportBreaches, reportBreachRepository.findAll());
    }
}
