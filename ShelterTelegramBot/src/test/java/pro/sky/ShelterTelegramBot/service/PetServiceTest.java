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
import pro.sky.ShelterTelegramBot.model.ClientStatus;
import pro.sky.ShelterTelegramBot.model.Pet;
import pro.sky.ShelterTelegramBot.model.Report;
import pro.sky.ShelterTelegramBot.repository.ClientRepository;
import pro.sky.ShelterTelegramBot.repository.PetRepository;
import pro.sky.ShelterTelegramBot.service.impl.ClientServiceImpl;
import pro.sky.ShelterTelegramBot.service.impl.PetServiceImpl;

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
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Test
    public void addTest() throws IOException {
        Pet pet=new Pet("кошка","name","gender");


        when(petRepository.save(pet)).thenReturn(pet);
        assertNotNull(petService.create(pet));
        assertEquals(pet, petService.create(pet));
    }

    @Test
    public void delTest() throws IOException {
        Pet pet=new Pet("кошка","name","gender");


        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));


        petService.delete(1L);


        verify(petRepository, Mockito.times(1)).deleteById(1L);
    }


    @Test
    public void getTest() throws IOException {
        Pet pet=new Pet("кошка","name","gender");


        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));
        assertNotNull(petService.get(1L));
        assertEquals(pet, petService.get(1L));
    }


    @Test
    void getAll() {
        Pet pet=new Pet("кошка","name","gender");
        Pet pet2=new Pet("кошка","name2","gender");

        List<Pet> pets = Arrays.asList(pet, pet2);

        Collection<Pet> result = Arrays.asList(pet, pet2);

        Mockito.when(petRepository.findAll()).thenReturn(pets);


        Assert.assertEquals(pets, petRepository.findAll());
    }

    @Test
    void findAllByPetTypeTest() {
        Pet pet=new Pet("кошка","name","gender");
        Pet pet2=new Pet("кошка","name2","gender");
        String petType= "кошка";
        List<Pet> pets=new ArrayList<>();
        pets.add(pet);
        pets.add(pet2);


        Mockito.when(petRepository.findAllByPetType(petType)).thenReturn(pets);
        petService.findAllByPetType(petType);
    }



    @Test
    public void testUpdateWithReport() {

        Pet pet=new Pet("кошка","name","gender");
         Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");
        List<Report> reports = new ArrayList<>();
        reports.add(report);
        pet.setReport(reports);
        when(petRepository.save(pet)).thenReturn(pet);
        petService.updateWithReport(pet,report);
    }
    @Test
    public  void createWithReportTest(){
        Pet pet=new Pet("кошка","name","gender");
        List<Report> reports = new ArrayList<>();
        pet.setReport(reports);
        when(petRepository.save(pet)).thenReturn(pet);
        petService.createWithReports(pet);

    }


}
