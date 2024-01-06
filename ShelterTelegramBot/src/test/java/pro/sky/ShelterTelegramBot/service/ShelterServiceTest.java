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
import pro.sky.ShelterTelegramBot.constants.ShelterType;
import pro.sky.ShelterTelegramBot.model.Client;
import pro.sky.ShelterTelegramBot.model.Pet;
import pro.sky.ShelterTelegramBot.model.Report;
import pro.sky.ShelterTelegramBot.model.Shelter;
import pro.sky.ShelterTelegramBot.repository.ShelterRepository;
import pro.sky.ShelterTelegramBot.service.impl.ShelterServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
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
public class ShelterServiceTest {

    @Mock
    private ShelterRepository shelterRepository;

    @InjectMocks
    private ShelterServiceImpl shelterService;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void addTest() throws IOException {
        Shelter shelter=new Shelter("ff", ShelterType.CAT_SHELTER,"fffd","11","444");


        when(shelterRepository.save(shelter)).thenReturn(shelter);
        assertNotNull(shelterService.create(shelter));
        assertEquals(shelter, shelterService.create(shelter));
    }

    @Test
    public void delTest() throws IOException {
        Shelter shelter=new Shelter("ff", ShelterType.CAT_SHELTER,"fffd","11","444");


        when(shelterRepository.findById(1L)).thenReturn(Optional.of(shelter));


        shelterService.delete(1L);


        verify(shelterRepository, Mockito.times(1)).deleteById(1L);
    }


    @Test
    public void getTest() throws IOException {
        Shelter shelter=new Shelter("ff", ShelterType.CAT_SHELTER,"fffd","11","444");


        when(shelterRepository.findById(1L)).thenReturn(Optional.of(shelter));
        assertNotNull(shelterService.get(1L));
        assertEquals(shelter, shelterService.get(1L));
    }


    @Test
    void getAll() {
        Shelter shelter=new Shelter("ff", ShelterType.CAT_SHELTER,"fffd","11","444");
        Shelter shelter2=new Shelter("ffd", ShelterType.CAT_SHELTER,"fffd","11","444");
        List<Shelter> reports = Arrays.asList(shelter, shelter2);

        //Collection<Shelter> result = Arrays.asList(shelter, shelter2);

        Mockito.when(shelterRepository.findAll()).thenReturn(reports);


        Assert.assertEquals(reports, shelterRepository.findAll());
    }

    @Test
    void findReportByNameTest() {
        Shelter shelter=new Shelter("ff", ShelterType.CAT_SHELTER,"fffd","11","444");
        String reportName= "qq";


        Mockito.when(shelterRepository.findByName(reportName)).thenReturn(shelter);
        shelterService.findByName(reportName);
    }



    @Test
    public void testUpdateWithClient() {

        Shelter shelter=Mockito.mock(Shelter.class);
        Pet pet=Mockito.mock(Pet.class);
        when(shelterRepository.save(shelter)).thenReturn(shelter);
        shelterService.updateWithPet(shelter,pet);
    }
}
