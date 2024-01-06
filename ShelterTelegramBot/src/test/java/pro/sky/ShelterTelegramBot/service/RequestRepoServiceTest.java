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
import pro.sky.ShelterTelegramBot.model.Report;
import pro.sky.ShelterTelegramBot.model.Request;
import pro.sky.ShelterTelegramBot.repository.RequestRepository;
import pro.sky.ShelterTelegramBot.service.impl.RequestRepoServiceImpl;

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
public class RequestRepoServiceTest {


    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestRepoServiceImpl requestService;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void addTest() throws IOException {
        Request request=new Request("fff","ff");


        when(requestRepository.save(request)).thenReturn(request);
        assertNotNull(requestService.create(request));
        assertEquals(request, requestService.create(request));
    }

    @Test
    public void delTest() throws IOException {
        Request request=new Request("fff","ff");


        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));


        requestService.delete(1L);


        verify(requestRepository, Mockito.times(1)).deleteById(1L);
    }


    @Test
    public void getTest() throws IOException {
        Request request=new Request("fff","ff");


        when(requestRepository.findById(1L)).thenReturn(Optional.of(request));
        assertNotNull(requestService.get(1L));
        assertEquals(request, requestService.get(1L));
    }


    @Test
    void getAll() {
        Request request=new Request("fff","ff");
        Request request2=new Request("fff","ff");
        List<Request> reports = Arrays.asList(request, request2);

        Collection<Request> result = Arrays.asList(request, request2);

        Mockito.when(requestRepository.findAll()).thenReturn(reports);


        Assert.assertEquals(reports, requestRepository.findAll());
    }

    @Test
    void findReportByNameTest() {
        Request request=new Request("fff","ffa");
        String requestName= "ffa";


        Mockito.when(requestRepository.findRequestByPetName(requestName)).thenReturn(request);
        requestService.findRequestByPetName(requestName);
    }
}
