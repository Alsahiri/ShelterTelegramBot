package pro.sky.ShelterTelegramBot.service;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
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
import pro.sky.ShelterTelegramBot.model.Report;
import pro.sky.ShelterTelegramBot.model.UserStatement;
import pro.sky.ShelterTelegramBot.repository.UserStatementRepository;
import pro.sky.ShelterTelegramBot.service.impl.*;
import pro.sky.ShelterTelegramBot.utils.Send;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pro.sky.ShelterTelegramBot.constants.Constants.Guest_Status;
import static pro.sky.ShelterTelegramBot.constants.Constants.Registration_Status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserStatementServiceTest {
    @Mock
    private UserStatementRepository userStatementRepository;
    @Mock
    private ClientStatusServiceImpl clientStatusService;
    @Mock
    private ReportServiceImpl reportService;
    @Mock
    private ControlServiceImpl controlService;
   @Mock
    private ClientServiceImpl clientService;
   @Mock
   private Send send;

    @InjectMocks
    private UserStatementServiceImpl userStatementService;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    public void addTest() throws IOException {
        UserStatement userStatement=new UserStatement();


        when(userStatementRepository.save(userStatement)).thenReturn(userStatement);
        assertNotNull(userStatementService.create());
        assertEquals(userStatement, userStatementService.create());
    }

    @Test
    public void delTest() throws IOException {
        UserStatement userStatement=new UserStatement();


        when(userStatementRepository.findById(1L)).thenReturn(Optional.of(userStatement));


        userStatementService.delete(1L);


        verify(userStatementRepository, Mockito.times(1)).delete(userStatement);
    }


    @Test
    public void getTest() throws IOException {
        UserStatement userStatement=new UserStatement();


        when(userStatementRepository.findById(1L)).thenReturn(Optional.of(userStatement));
        assertNotNull(userStatementService.get(1L));
        assertEquals(userStatement, userStatementService.get(1L));
    }


    @Test
    void getAll() {
        UserStatement userStatement=new UserStatement();
        UserStatement userStatement2=new UserStatement();
        List<UserStatement> userStatements = Arrays.asList(userStatement, userStatement2);

        Mockito.when(userStatementRepository.findAll()).thenReturn(userStatements);


        Assert.assertEquals(userStatements, userStatementRepository.findAll());
    }
    @Test
    public void appointTest() throws IOException {
        Update update=Mockito.mock(Update.class);
        Message message = Mockito.mock(Message.class);
        Chat chat = Mockito.mock(Chat.class);
        ClientStatus clientStatus =Mockito.mock(ClientStatus.class);
        UserStatement userStatement=Mockito.mock(UserStatement.class);
        Report report=new Report("gg", LocalDate.now().format(FORMATTER),0,"На проверке");
        String text="";
        String name="name";
        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(1L);
        when(message.text()).thenReturn("ааа,fff");
        when(clientStatus.getUserStatement()).thenReturn(userStatement);
        when(userStatement.getStatement()).thenReturn("&");
        when(clientStatusService.findClient(1L)).thenReturn(clientStatus);
        when(reportService.findReportByName(name)).thenReturn(report);
        userStatementService.appoint(update,text);
    }
@Test
    public void saveClient(){
        Update update=Mockito.mock(Update.class);
        Message message = Mockito.mock(Message.class);
        Chat chat = Mockito.mock(Chat.class);
        ClientStatus clientStatusCheck=Mockito.mock(ClientStatus.class);
        Matcher matcher=Mockito.mock(Matcher.class);
        ClientStatus clientStatus =Mockito.mock(ClientStatus.class);
        Client client=Mockito.mock(Client.class);

        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(1L);
        when(message.text()).thenReturn("Иван Иванов,21,999-000-11-11,Москва Название улицы 9");
        when(clientStatusService.findClient(1L)).thenReturn(clientStatusCheck);
        when(clientStatusCheck.getClientStatus()).thenReturn(Guest_Status);
        when(matcher.matches()).thenReturn(true);
        when(clientService.create(client)).thenReturn(client);
        when(clientStatusService.updateStatus(1L, Registration_Status)).thenReturn(clientStatus);
        when(clientService.updateWithClientStatus(client, clientStatus)).thenReturn(client);

        userStatementService.saveClient(update);

    }
}
