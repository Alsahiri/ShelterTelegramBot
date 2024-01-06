package pro.sky.ShelterTelegramBot.handlers;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

import static pro.sky.ShelterTelegramBot.constants.Constants.*;

/**
 * Класс для хранеия static методов с  InlineKeyboard
 */
public class Button {

    public static InlineKeyboardMarkup animalSelectionButtons() {

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        InlineKeyboardButton catButton = new InlineKeyboardButton(Cat_Message).
                callbackData(CAT_SHELTER_CALLBACK);
        InlineKeyboardButton dogButton = new InlineKeyboardButton(Dog_Message).
                callbackData(DOG_SHELTER_CALLBACK);

        markupInline.addRow(catButton);
        markupInline.addRow(dogButton);

        return markupInline;
    }

    public static InlineKeyboardMarkup infoShelterCatButtons() {
        InlineKeyboardMarkup markupShelterCat = new InlineKeyboardMarkup();
        InlineKeyboardButton workScheduleButton = new InlineKeyboardButton(Info_Message1).
                callbackData(WORK_SCHEDULE);
        InlineKeyboardButton carPassButton = new InlineKeyboardButton(Info_Message2).
                callbackData(REGISTRATION_CARCat);
        InlineKeyboardButton safetyButton = new InlineKeyboardButton(Info_Message3).
                callbackData(SAFETYCat);
        InlineKeyboardButton createButton = new InlineKeyboardButton(Info_Message4).
                callbackData(CREATECat);
        InlineKeyboardButton callButton = new InlineKeyboardButton(Info_Message5).
                callbackData(CALLCat);
        markupShelterCat.addRow(workScheduleButton);
        markupShelterCat.addRow(carPassButton);
        markupShelterCat.addRow(safetyButton);
        markupShelterCat.addRow(createButton);
        markupShelterCat.addRow(callButton);


        return markupShelterCat;
    }

    public static InlineKeyboardMarkup infoShelterDogButtons() {
        InlineKeyboardMarkup markupShelterDog = new InlineKeyboardMarkup();
        InlineKeyboardButton workScheduleButton = new InlineKeyboardButton(Info_Message1).
                callbackData(WORK_SCHEDULEDog);
        InlineKeyboardButton carPassButton = new InlineKeyboardButton(Info_Message2).
                callbackData(REGISTRATION_CARDog);
        InlineKeyboardButton safetyButton = new InlineKeyboardButton(Info_Message3).
                callbackData(SAFETYDog);
        InlineKeyboardButton createButton = new InlineKeyboardButton(Info_Message4).
                callbackData(CREATEDog);
        InlineKeyboardButton callButton = new InlineKeyboardButton(Info_Message5).
                callbackData(CALLDog);
        markupShelterDog.addRow(workScheduleButton);
        markupShelterDog.addRow(carPassButton);
        markupShelterDog.addRow(safetyButton);
        markupShelterDog.addRow(createButton);
        markupShelterDog.addRow(callButton);


        return markupShelterDog;
    }

    public static InlineKeyboardMarkup infoPetsCatButtons() {
        InlineKeyboardMarkup markupPetsCat = new InlineKeyboardMarkup();
        InlineKeyboardButton PetCatsListButton = new InlineKeyboardButton(Info_Pet_Message1).
                callbackData(PetCatsList);
        InlineKeyboardButton RulesDatingCatButton = new InlineKeyboardButton(Info_Pet_Message2).
                callbackData(RulesDatingCat);
        InlineKeyboardButton DocCatButton = new InlineKeyboardButton(Info_Pet_Message3).
                callbackData(DocCat);
        InlineKeyboardButton TransportOfCatButton = new InlineKeyboardButton(Info_Pet_Message4).
                callbackData(TransportOfCat);
        InlineKeyboardButton HomeCatsChildButton = new InlineKeyboardButton(Info_Pet_Cat_Message1).
                callbackData(HomeCatsChild);
        InlineKeyboardButton HomeCatsAdultButton = new InlineKeyboardButton(Info_Pet_Cat_Message2).
                callbackData(HomeCatsAdult);
        InlineKeyboardButton HomeCatsDisabilitiesButton = new InlineKeyboardButton(Info_Pet_Cat_Message3).
                callbackData(HomeCatsDisabilities);
        InlineKeyboardButton FailCatsButton = new InlineKeyboardButton(Info_Pet_Message5).
                callbackData(FailCats);
        InlineKeyboardButton CREATECats_31Button = new InlineKeyboardButton(Info_Pet_Message6).
                callbackData(CREATECats_31);
        InlineKeyboardButton CALLCats_31Button = new InlineKeyboardButton(Info_Pet_Message7).
                callbackData(CALLCats_31);
        markupPetsCat.addRow(PetCatsListButton);
        markupPetsCat.addRow(RulesDatingCatButton);
        markupPetsCat.addRow(DocCatButton);
        markupPetsCat.addRow(TransportOfCatButton);
        markupPetsCat.addRow(HomeCatsChildButton);
        markupPetsCat.addRow(HomeCatsAdultButton);
        markupPetsCat.addRow(HomeCatsDisabilitiesButton);
        markupPetsCat.addRow(FailCatsButton);
        markupPetsCat.addRow(CREATECats_31Button);
        markupPetsCat.addRow(CALLCats_31Button);


        return markupPetsCat;
    }


    public static InlineKeyboardMarkup infoPetsDogButtons() {
        InlineKeyboardMarkup markupPetsDog = new InlineKeyboardMarkup();
        InlineKeyboardButton PetDogListButton = new InlineKeyboardButton(Info_Pet_Message1).
                callbackData(PetDogList);
        InlineKeyboardButton RulesDatingDogButton = new InlineKeyboardButton(Info_Pet_Message2).
                callbackData(RulesDatingDog);
        InlineKeyboardButton DocDogButton = new InlineKeyboardButton(Info_Pet_Message3).
                callbackData(DocDog);
        InlineKeyboardButton TransportOfDogButton = new InlineKeyboardButton(Info_Pet_Message4).
                callbackData(TransportOfDog);
        InlineKeyboardButton HomeDogsChildButton = new InlineKeyboardButton(Info_Pet_Dog_Message1).
                callbackData(HomeDogsChild);
        InlineKeyboardButton HomeDogsAdultButton = new InlineKeyboardButton(Info_Pet_Dog_Message2).
                callbackData(HomeDogsAdult);
        InlineKeyboardButton HomeDogsDisabilitiesButton = new InlineKeyboardButton(Info_Pet_Dog_Message3).
                callbackData(HomeDogsDisabilities);
        InlineKeyboardButton DogHandlerFirstTimeButton = new InlineKeyboardButton(Info_Pet_Dog_Message4).
                callbackData(DogHandlerFirstTime);
        InlineKeyboardButton DogHandlerRecommendationButton = new InlineKeyboardButton(Info_Pet_Dog_Message5).
                callbackData(DogHandlerRecommendation);
        InlineKeyboardButton FailDogsButton = new InlineKeyboardButton(Info_Pet_Message5).
                callbackData(FailDogs);
        InlineKeyboardButton CREATEDogs_32Button = new InlineKeyboardButton(Info_Pet_Message6).
                callbackData(CREATEDogs_32);
        InlineKeyboardButton CALLDogs_32Button = new InlineKeyboardButton(Info_Pet_Message7).
                callbackData(CALLDogs_32);
        markupPetsDog.addRow(PetDogListButton);
        markupPetsDog.addRow(RulesDatingDogButton);
        markupPetsDog.addRow(DocDogButton);
        markupPetsDog.addRow(TransportOfDogButton);
        markupPetsDog.addRow(HomeDogsChildButton);
        markupPetsDog.addRow(HomeDogsAdultButton);
        markupPetsDog.addRow(HomeDogsDisabilitiesButton);
        markupPetsDog.addRow(DogHandlerFirstTimeButton);
        markupPetsDog.addRow(DogHandlerRecommendationButton);
        markupPetsDog.addRow(FailDogsButton);
        markupPetsDog.addRow(CREATEDogs_32Button);
        markupPetsDog.addRow(CALLDogs_32Button);


        return markupPetsDog;
    }


    public static InlineKeyboardMarkup MenuShelterDogButtons() {
        InlineKeyboardMarkup markupMenuDog = new InlineKeyboardMarkup();
        InlineKeyboardButton DogShelterInfoButton = new InlineKeyboardButton(Menu1).
                callbackData(DogShelterInfo);
        InlineKeyboardButton DogsPetsInfoButton = new InlineKeyboardButton(Menu2).
                callbackData(DogsPetsInfo);
        InlineKeyboardButton DogsControlServiceButton = new InlineKeyboardButton(Menu3).
                callbackData(DogsControlService);
        InlineKeyboardButton CALLDogs_12Button = new InlineKeyboardButton(Menu4).
                callbackData(CALLDogs_12);
        markupMenuDog.addRow(DogShelterInfoButton);
        markupMenuDog.addRow(DogsPetsInfoButton);
        markupMenuDog.addRow(DogsControlServiceButton);
        markupMenuDog.addRow(CALLDogs_12Button);

        return markupMenuDog;
    }

    public static InlineKeyboardMarkup MenuShelterCatButtons() {
        InlineKeyboardMarkup markupMenuCat = new InlineKeyboardMarkup();
        InlineKeyboardButton CatShelterInfoButton = new InlineKeyboardButton(Menu1).
                callbackData(CatShelterInfo);
        InlineKeyboardButton CatsPetsInfoButton = new InlineKeyboardButton(Menu2_1).
                callbackData(CatsPetsInfo);
        InlineKeyboardButton CatsControlServiceButton = new InlineKeyboardButton(Menu3).
                callbackData(CatsControlService);
        InlineKeyboardButton CALLCats_12Button = new InlineKeyboardButton(Menu4).
                callbackData(CALLCats_12);
        markupMenuCat.addRow(CatShelterInfoButton);
        markupMenuCat.addRow(CatsPetsInfoButton);
        markupMenuCat.addRow(CatsControlServiceButton);
        markupMenuCat.addRow(CALLCats_12Button);

        return markupMenuCat;
    }

    public static InlineKeyboardMarkup MenuVolunteerButtons() {
        InlineKeyboardMarkup markupMenuCat = new InlineKeyboardMarkup();
        InlineKeyboardButton VolunteerGetRequestButton = new InlineKeyboardButton(VolunteerMenu1).
                callbackData(Get_Request);
        InlineKeyboardButton VolunteerGetReportButton = new InlineKeyboardButton(VolunteerMenu2).
                callbackData(Get_Report);
        markupMenuCat.addRow(VolunteerGetRequestButton);
        markupMenuCat.addRow(VolunteerGetReportButton);

        return markupMenuCat;
    }

    public static InlineKeyboardMarkup MenuReportButtons() {
        InlineKeyboardMarkup markupMenuReport = new InlineKeyboardMarkup();
        InlineKeyboardButton ReportInfoButton = new InlineKeyboardButton(ControlMenu1).
                callbackData(ReportInfo);
        InlineKeyboardButton GetReportNameButton = new InlineKeyboardButton(ControlMenu2).
                callbackData(GetReportName);
        InlineKeyboardButton PetsPhotoButton = new InlineKeyboardButton(ControlMenu3).
                callbackData(PetsPhoto);
        InlineKeyboardButton ReportControlButton = new InlineKeyboardButton(ControlMenu4).
                callbackData(ReportControl);
        InlineKeyboardButton PushReportButton = new InlineKeyboardButton(ControlMenu5).
                callbackData(PushReport);
        InlineKeyboardButton CALLButton = new InlineKeyboardButton(ControlMenu6).
                callbackData(CALL);
        markupMenuReport.addRow(ReportInfoButton);
        markupMenuReport.addRow(GetReportNameButton);
        markupMenuReport.addRow(PetsPhotoButton);
        markupMenuReport.addRow(ReportControlButton);
        markupMenuReport.addRow(PushReportButton);
        markupMenuReport.addRow(CALLButton);

        return markupMenuReport;
    }
}
