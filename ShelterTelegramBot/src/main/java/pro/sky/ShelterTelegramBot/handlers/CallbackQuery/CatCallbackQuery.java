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
import java.util.Arrays;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static pro.sky.ShelterTelegramBot.constants.Constants.*;
/**
 * Класс для обработки CallbackQuery из клавиатур для кошачьего питомника
 */
@Service
public class CatCallbackQuery {

    private final TelegramBot telegramBot;
    private final AttachmentService attachmentService;
    private final ClientStatusService clientStatusService;
    private final VolunteerService volunteerService;
    private final RequestRepoService requestRepoService;
    private final UserStatementService userStatementService;
    private final PetService petService;
    private final ShelterService shelterService;
    private final Send send;

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    public CatCallbackQuery(TelegramBot telegramBot, AttachmentService attachmentService,
                            ClientStatusService clientStatusService, VolunteerService volunteerService,
                            RequestRepoService requestRepoService, UserStatementService userStatementService,
                            PetService petService, ShelterService shelterService,Send send) {
        this.telegramBot = telegramBot;
        this.attachmentService = attachmentService;
        this.clientStatusService = clientStatusService;
        this.volunteerService = volunteerService;
        this.requestRepoService = requestRepoService;
        this.userStatementService = userStatementService;
        this.petService = petService;
        this.shelterService = shelterService;
        this.send=send;
    }

    /**
     * обработка CallBackQuery для клавиатуры CAT
     * Общая инфа по питомнику
     *
     * @param update
     */
    public void handlerCatButton(Update update) throws IOException {
        logger.info("method handlerCatButton is invoke");
        CallbackQuery callbackQuery = update.callbackQuery();
        long chatId = callbackQuery.message().chat().id();

        switch (callbackQuery.data()) {
            case WORK_SCHEDULE:
                clientStatusService.clickCat(chatId, 1);
                SendPhoto sendPhoto = new SendPhoto(chatId, attachmentService.loadFile(A__11));
                SendResponse response = telegramBot.execute(sendPhoto);
                break;
            case REGISTRATION_CARCat:
                clientStatusService.clickCat(chatId, 3);
                SendMessage sendMessage2 = new SendMessage(chatId, shelterCat.getContactDetails());
                SendResponse response2 = telegramBot.execute(sendMessage2);
                break;
            case SAFETYCat:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc = new SendDocument(chatId, attachmentService.loadFile(A__01));
                SendResponse response3 = telegramBot.execute(sendDoc);
                break;
            case CREATECat:
                clientStatusService.clickCat(chatId, 3);
                UserStatement userStatement = clientStatusService.findClient(chatId).getUserStatement();
                userStatement.setStatement("@");
                userStatementService.update(userStatement);
                SendMessage sendMessage4 = new SendMessage(chatId, CREATE);
                SendResponse response4 = telegramBot.execute(sendMessage4);
                break;
            case CALLCat:
                clientStatusService.clickCat(chatId, 1);
                Volunteer volunteer = volunteerService.findByStatus(0, 2);
                String volunteerName = Name_1_Volunteer + volunteer.getUserName() + Name_2_Volunteer;
                SendMessage sendMessage5 = new SendMessage(chatId, volunteerName);
                SendResponse response5 = telegramBot.execute(sendMessage5);
                break;


        }
    }

    /**
     * Обработка сallBackQuery для клавиатуры CAT
     * информация, документация и список питомцев
     * @param update
     */
    public void infoPetsCatButton(Update update) throws IOException {
        logger.info("method infoPetsCatButton is invoke");
        CallbackQuery callbackQuery = update.callbackQuery();
        long chatId = callbackQuery.message().chat().id();
        clientStatusService.clickCat(chatId, 2);
        //Client client = clientStatusService.findClient(chatId).getClient();
        switch (callbackQuery.data()) {

            case PetCatsList:
                Optional<Client>client=Optional.ofNullable( clientStatusService.findClient(chatId).getClient());
                if (client.isPresent()){
                petService.findAllByPetType(Cats_Shelter).forEach(pet -> {
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
//                    send.sendMessageReturn(sendMessage.replyMarkup(keyboardMarkup));
                });
                }
                else {
                    SendMessage sendMessage=new SendMessage(chatId,ErrorGetPet);
                    send.sendMessage(sendMessage);
                }
                break;
            case RulesDatingCat:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc2 = new SendDocument(chatId, attachmentService.loadFile(A__021));
                SendResponse response7 = telegramBot.execute(sendDoc2);
                break;
            case DocCat:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc3 = new SendDocument(chatId, attachmentService.loadFile(A__022));
                SendResponse response8 = telegramBot.execute(sendDoc3);
                break;
            case TransportOfCat:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc4 = new SendDocument(chatId, attachmentService.loadFile(A__023));
                SendResponse response9 = telegramBot.execute(sendDoc4);
                break;
            case HomeCatsChild:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc5 = new SendDocument(chatId, attachmentService.loadFile(A__24));
                SendResponse response10 = telegramBot.execute(sendDoc5);
                break;
            case HomeCatsAdult:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc6 = new SendDocument(chatId, attachmentService.loadFile(A__25));
                SendResponse response11 = telegramBot.execute(sendDoc6);
                break;
            case HomeCatsDisabilities:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc7 = new SendDocument(chatId, attachmentService.loadFile(A__26));
                SendResponse response12 = telegramBot.execute(sendDoc7);
                break;
            case FailCats:
                clientStatusService.clickCat(chatId, 1);
                SendDocument sendDoc8 = new SendDocument(chatId, attachmentService.loadFile(A__27));
                SendResponse response13 = telegramBot.execute(sendDoc8);
                break;
            case CREATECats_31:
                clientStatusService.clickCat(chatId, 4);
                UserStatement userStatement = clientStatusService.findClient(chatId).getUserStatement();
                userStatement.setStatement("@");
                userStatementService.update(userStatement);
                SendMessage sendMessage8 = new SendMessage(chatId, CREATE);
                SendResponse response14 = telegramBot.execute(sendMessage8);
                break;
            case CALLCats_31:
                clientStatusService.clickCat(chatId, 2);
                Volunteer volunteer2 = volunteerService.findByStatus(0, 2);
                String volunteerName2 = Name_1_Volunteer + volunteer2.getUserName() + Name_2_Volunteer;
                SendMessage sendMessage9 = new SendMessage(chatId, volunteerName2);
                SendResponse response15 = telegramBot.execute(sendMessage9);
                break;
        }
    }
    /**
     * Обработка сallBackQuery из кнопки PetCatsList
     * информация,  и генерация запроса на усыновления питомца
     * @param update
     */
    public void getPetsCatButton(Update update) throws IOException {
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
