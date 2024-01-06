package pro.sky.ShelterTelegramBot.handlers.CallbackQuery;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.ShelterTelegramBot.listener.TelegramBotUpdatesListener;
import pro.sky.ShelterTelegramBot.model.*;
import pro.sky.ShelterTelegramBot.service.*;
import pro.sky.ShelterTelegramBot.utils.Send;

import java.io.IOException;
import java.util.Optional;

import static pro.sky.ShelterTelegramBot.constants.Constants.*;

@Service
public class DogCallbackQuery {
    private final TelegramBot telegramBot;
    private final AttachmentService attachmentService;
    private final ClientStatusService clientStatusService;
    private final VolunteerService volunteerService;
    private final UserStatementService userStatementService;
    private final PetService petService;
    private final RequestRepoService requestRepoService;
    private final Send send;

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    /**
     * Класс для обработки CallbackQuery из клавиатур для собачьего питомника
     */
    public DogCallbackQuery(TelegramBot telegramBot, AttachmentService attachmentService,
                            ClientStatusService clientStatusService,
                            VolunteerService volunteerService, UserStatementService userStatementService
            , PetService petService, RequestRepoService requestRepoService, Send send) {
        this.telegramBot = telegramBot;
        this.attachmentService = attachmentService;
        this.clientStatusService = clientStatusService;
        this.volunteerService = volunteerService;
        this.userStatementService = userStatementService;
        this.petService = petService;
        this.requestRepoService = requestRepoService;
        this.send=send;
    }

    /**
     * Обработка сallBackQuery для клавиатуры DOG
     * Общая инфа по питомнику
     * @param update
     */
    public void handlerDogButton(Update update) throws IOException {
        logger.info("method handlerDogButton is invoke");
        CallbackQuery callbackQuery = update.callbackQuery();
        long chatId = callbackQuery.message().chat().id();
        //String shelterAddress=attachmentService.loadFileAsResource("attach__00.jpg").getURL().toString();
        switch (callbackQuery.data()) {
            case WORK_SCHEDULEDog:
                clientStatusService.clickDog(chatId, 1);
                SendPhoto sendPhoto = new SendPhoto(chatId, attachmentService.loadFile(A__00));
                SendResponse response = telegramBot.execute(sendPhoto);
                break;
            case REGISTRATION_CARDog:
                clientStatusService.clickDog(chatId, 3);
                SendMessage sendMessage2 = new SendMessage(chatId, shelterDog.getContactDetails());
                SendResponse response2 = telegramBot.execute(sendMessage2);
                break;
            case SAFETYDog:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc = new SendDocument(chatId, attachmentService.loadFile(A__01));
                SendResponse response3 = telegramBot.execute(sendDoc);
                break;
            case CREATEDog:
                clientStatusService.clickDog(chatId, 3);
                UserStatement userStatement = clientStatusService.findClient(chatId).getUserStatement();
                userStatement.setStatement("@");
                userStatementService.update(userStatement);
                SendMessage sendMessage4 = new SendMessage(chatId, CREATE);
                SendResponse response4 = telegramBot.execute(sendMessage4);
                break;
            case CALLDog:
                clientStatusService.clickDog(chatId, 1);
                Volunteer volunteer = volunteerService.findByStatus(0, 2);
                String volunteerName = Name_1_Volunteer + volunteer.getUserName() + Name_2_Volunteer;
                SendMessage sendMessage5 = new SendMessage(chatId, volunteerName);
                SendResponse response5 = telegramBot.execute(sendMessage5);
                break;
        }
    }

    /**
     * Обработка сallBackQuery для клавиатуры DOG
     * информация, документация и список питомцев
     * @param update
     */
    public void infoPetsDogButton(Update update) throws IOException {
        logger.info("method infoPetsDogButton is invoke");
        CallbackQuery callbackQuery = update.callbackQuery();
        long chatId = callbackQuery.message().chat().id();
        //String shelterAddress=attachmentService.loadFileAsResource("attach__00.jpg").getURL().toString();
        switch (callbackQuery.data()) {
            case PetDogList:
                Optional<Client>client=Optional.ofNullable( clientStatusService.findClient(chatId).getClient());
                if (client.isPresent()){
                petService.findAllByPetType(Dogs_Shelter).forEach(pet -> {
                    InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
                    String CallBackInfo = Create_Report + Pet_Foreach3 + Pets_Information + Pet_Foreach3 + chatId + Pet_Foreach3 + pet.getId();
                    String CallBackGet = Create_Report + Pet_Foreach3 + Pets_Get + Pet_Foreach3 + chatId + Pet_Foreach3 + pet.getId();
                    InlineKeyboardButton AcceptButton = new InlineKeyboardButton(Pet_Foreach).
                            callbackData(CallBackInfo);
                    InlineKeyboardButton DenyButton = new InlineKeyboardButton(Pet_Foreach2).
                            callbackData(CallBackGet);
                    keyboardMarkup.addRow(AcceptButton);
                    keyboardMarkup.addRow(DenyButton);
                    try {
                        SendPhoto sendPhoto = new SendPhoto(chatId, attachmentService.loadFile(pet.getAttachment().getAttachTitle()));
                        SendResponse sendResponse = telegramBot.execute(sendPhoto);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    SendMessage sendMessage = new SendMessage(chatId, pet.getName());
                    SendResponse sendResponse = telegramBot.execute(sendMessage.replyMarkup(keyboardMarkup));
                });
                }
                else {
                    SendMessage sendMessage=new SendMessage(chatId,ErrorGetPet);
                    send.sendMessage(sendMessage);
                }
                break;
            case RulesDatingDog:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc2 = new SendDocument(chatId, attachmentService.loadFile(A__021));
                SendResponse response7 = telegramBot.execute(sendDoc2);
                break;
            case DocDog:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc3 = new SendDocument(chatId, attachmentService.loadFile(A__022));
                SendResponse response8 = telegramBot.execute(sendDoc3);
                break;
            case TransportOfDog:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc4 = new SendDocument(chatId, attachmentService.loadFile(A__023));
                SendResponse response9 = telegramBot.execute(sendDoc4);
                break;

            case HomeDogsChild:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc5 = new SendDocument(chatId, attachmentService.loadFile(A__024));
                SendResponse response10 = telegramBot.execute(sendDoc5);
                break;
            case HomeDogsAdult:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc6 = new SendDocument(chatId, attachmentService.loadFile(A__025));
                SendResponse response11 = telegramBot.execute(sendDoc6);
                break;
            case HomeDogsDisabilities:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc7 = new SendDocument(chatId, attachmentService.loadFile(A__026));
                SendResponse response12 = telegramBot.execute(sendDoc7);
                break;
            case DogHandlerFirstTime:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc8 = new SendDocument(chatId, attachmentService.loadFile(A__027));
                SendResponse response13 = telegramBot.execute(sendDoc8);
                break;
            case DogHandlerRecommendation:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc9 = new SendDocument(chatId, attachmentService.loadFile(A__028));
                SendResponse response14 = telegramBot.execute(sendDoc9);
                break;
            case FailDogs:
                clientStatusService.clickDog(chatId, 1);
                SendDocument sendDoc10 = new SendDocument(chatId, attachmentService.loadFile(A__029));
                SendResponse response15 = telegramBot.execute(sendDoc10);
                break;
            case CREATEDogs_32:
                clientStatusService.clickDog(chatId, 4);
                UserStatement userStatement = clientStatusService.findClient(chatId).getUserStatement();
                userStatement.setStatement("@");
                userStatementService.update(userStatement);
                SendMessage sendMessage11 = new SendMessage(chatId, CREATE);
                SendResponse response16 = telegramBot.execute(sendMessage11);
                break;
            case CALLDogs_32:
                clientStatusService.clickDog(chatId, 2);
                Volunteer volunteer2 = volunteerService.findByStatus(0, 2);
                String volunteerName2 = Name_1_Volunteer + volunteer2.getUserName() + Name_2_Volunteer;
                SendMessage sendMessage12 = new SendMessage(chatId, volunteerName2);
                SendResponse response17 = telegramBot.execute(sendMessage12);
                break;
        }
    }
    /**
     * Обработка сallBackQuery из кнопки PetDogsList
     * информация,  и генерация запроса на усыновления питомца
     * @param update
     */
    public void getPetsDogButton(Update update) throws IOException {
        logger.info("method getPetsCatButton is invoke");
        CallbackQuery callbackQuery = update.callbackQuery();
        long chatId = callbackQuery.message().chat().id();
        String[] parts = callbackQuery.data().split(",");
        System.out.println(callbackQuery.data());
        Client client = clientStatusService.findClient(Long.valueOf(parts[2])).getClient();
        switch (parts[1]) {
            case Pets_Information:
                Pet pet = petService.get(Long.valueOf(parts[3]));
                SendMessage sendMessage1 = new SendMessage(client.getChatId(), Pet_Info + pet.getName() + Pet_Info2 + pet.getGender());
                SendResponse response1 = telegramBot.execute(sendMessage1);
                break;
            case Pets_Get:
                Pet pet2 = petService.get(Long.valueOf(parts[3]));
                Optional<Request> requestCheck = Optional.ofNullable(requestRepoService.findRequestByPetName(pet2.getName()));
                if (requestCheck.isEmpty()) {
                    Request request = new Request(client.getName(), pet2.getName());
                    requestRepoService.create(request);
                    SendMessage sendMessage2 = new SendMessage(client.getChatId(), Pet_Info3);
                    SendResponse response2 = telegramBot.execute(sendMessage2);
                    break;
                } else {
                    SendMessage sendMessage2 = new SendMessage(client.getChatId(), Pet_Info4);
                    SendResponse response2 = telegramBot.execute(sendMessage2);
                }
        }
    }

}
