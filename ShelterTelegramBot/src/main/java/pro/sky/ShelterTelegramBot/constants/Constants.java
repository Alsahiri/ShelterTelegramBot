package pro.sky.ShelterTelegramBot.constants;

import pro.sky.ShelterTelegramBot.model.Shelter;

import static pro.sky.ShelterTelegramBot.constants.ShelterType.CAT_SHELTER;
import static pro.sky.ShelterTelegramBot.constants.ShelterType.DOG_SHELTER;

/**
 * Константы
 */

public class Constants {

    public static final String SAY_HELLO = "Привет! Я бот для работы с приютами для собак и кошек. " +
            "Здесь ты можешь получить о каждом приюте всю информацию, Пообщаться с волонтерами приютов." +
            "Кроме того, для тех кто заберет к себе домой животное, здесь нам будет удобно узнавать как поживает животное" +
            "Далее следуйте меню";

    public static final String Cats_Shelter = "кошка";
    public static final String Dogs_Shelter = "собака";
    public static final String Pets_Information = "получить информацию";
    public static final String Pets_Get = "приютить";

    public static final String ReportInfo = "1984_ReportInfo";
    public static final String GetReportName = "1984_GetReportName";
    public static final String PetsPhoto = "1984_PetsPhoto";
    public static final String PushReport = "1984_PushReport";
    public static final String ReportControl = "1984_ReportControl";
    public static final String CALL = "1984_CALL";

    public static final String Cat_Message = "Приют кошек";
    public static final String Dog_Message ="Приют собак";
    public static final String Info_Message1 ="Расписание работы";
    public static final String Info_Message2 ="Оформление пропуска на машину";
    public static final String Info_Message3 ="Техника безопасности на территории приюта";
    public static final String Info_Message4 ="Отправить контактные данные";
    public static final String Info_Message5 ="Позвать волонтера";
    public static final String Info_Pet_Message1 ="Получить список животных для усыновления";
    public static final String Info_Pet_Message2 ="Правила знакомства с животным в приюте";
    public static final String Info_Pet_Message3 ="Список документов для усыновления";
    public static final String Info_Pet_Message4 ="Рекомендации по транспортировке";
    public static final String Info_Pet_Message5 ="Причины для отказа в усыновлении";
    public static final String Info_Pet_Message6 ="Отправить контактные данные";
    public static final String Info_Pet_Message7 ="Позвать волонтера";
    public static final String Info_Pet_Cat_Message1="Рекомендаций по обустройству дома для котёнка";
    public static final String Info_Pet_Cat_Message2="Рекомендаций по обустройству дома для взрослой кошки";
    public static final String Info_Pet_Cat_Message3="Рекомендаций по обустройству дома для  кошки с ограниченными возможностями";
    public static final String Info_Pet_Dog_Message1="Рекомендаций по обустройству дома для щенка";
    public static final String Info_Pet_Dog_Message2="Рекомендаций по обустройству дома для взрослой собаки";
    public static final String Info_Pet_Dog_Message3="Рекомендаций по обустройству дома для  собаки с ограниченными возможностями";
    public static final String Info_Pet_Dog_Message4="Рекомендация кинолога по адаптации собаки/щенка на новом месте";
    public static final String Info_Pet_Dog_Message5="Контакты кинологов";
    public static final String Menu1="Общая информация о приюте";
    public static final String Menu2="Как взять собаку из приюта";
    public static final String Menu2_1="Как взять кошку из приюта";
    public static final String Menu3="Отправить отчет";
    public static final String Menu4="Позвать волонтера";
    public static final String VolunteerMenu1="Получить запросы об усыновлении";
    public static final String VolunteerMenu2="Получить отчеты об усыновлении";
    public static final String ControlMenu1="Правила сдачи отчета";
    public static final String ControlMenu2="Получить название текущего отчета для отправки";
    public static final String ControlMenu3="Отправить фото питмца";
    public static final String ControlMenu4="Отправить текст";
    public static final String ControlMenu5="Отправить отчет";
    public static final String ControlMenu6="Позвать волонтера";
    public static final String START_COMMAND = "/start";
    public static final String HELP_COMMAND = "/help";

    public static final String Error = "Вы провалили проверку, бот для вас заблокирован. Ожидайте приезда волонтеров";
    public static final String VolunteerHello ="Приятной работы ";
    public static final String Error_Main ="Данная комманда не поддерживается ботом";
    public static final String Welcome_Volunteer = "Вы успешно стали волонтером. Так как мы не реализовали функцию удления данных волонтера из приложения, Вы с нами надолго)))";
    public static final String Welcome_Error = "Вы уже являетесь волонтером. P.S - функция удаления по прежнему отсуствует((.РАБотайте! ";
    public static final String Name_1_Volunteer="@";
    public static final String Name_2_Volunteer=" -ваш личный помошник. Готов помочь с любой проблемой)";
    public static final String Pet_Foreach="Получить информацию о питомце";
    public static final String Pet_Foreach2="Приютить питомца";
    public static final String Pet_Foreach3=",";
    public static final String Pet_Info="Имя питомца - ";
    public static final String Pet_Info2=" пол ";
    public static final String Pet_Info3="Ваш запрос об усыновлении передан волотёру";
    public static final String Pet_Info4="Вы уже передали запрос об усыновлении волотёру";
    public static final String Pet_Error = "Вы провалили проверку, бот для вас заблокирован. Ожидайте приезда волонтеров";
    public static final String Control_Welcome ="Меню отправки отчета приветствует Вас";
    public static final String Control_Er ="Вы еще не взяли ни одного питомца на усыновление";
    public static final String VolunteerAdd ="Одобрить запрос";
    public static final String VolunteerNo ="Отклонить запрос";
    public static final String Volunteer1="Пользователь ";
    public static final String Volunteer2=" отправил заявку на усыновление";
    public static final String VolunteerDenyReport ="Ваш отчет не приняли, если есть вопросы свяжитесь с волонтером";
    public static final String VolunteerDenyAgain="Вам уже отправили отказ";
    public static final String VolunteerAcceptRequest ="Вам одобрили усыновление  питомца. С сегодняшнего дня в должны присылать отчет";
    public static final String VolunteerAcceptRequestAgain ="Вам уже одобрили эту заявку";
    public static final String VolunteerDenyRequest ="Вам отказали в усыновлении питомца. Для получения причин отказа свяжитесь с волонтером";
    public static final String VolunteerDenyReportAgain="Вам уже отправии отказ";
    public static final String VolunteerAcceptReport ="Ваш отчет одобрили";
    public static final String VolunteerAcceptReportAgain ="Вам уже одобрили этот отчет";

    public static final String Guest_Status = "Гость";
    public static final String Registration_Status = "Зарегистрирован";
    public static final String Report_Status = "На проверке";
    public static final String ReadyToShip = "готово к отправке";
    public static final String NotPassed = "Отчет не сдан";
    public static final String Passed = "Отчет  сдан";
    public static final String Probation_Period_Status = "На испытательном сроке";
    public static final String Successfully_Status = "Проверка пройдена";
    public static final String Failed_Status = "Проверка провалена";

    public static final String Volunteer = "000";
    public static final String Request_CallBack = "001";
    public static final String Report_CallBack = "002";
    public static final String Create_Report = "333";
    public static final String _CallBack = "_";



    public static final String Get_Request = "000_GetRequest";
    public static final String Get_Report = "000_GetReport";
    public static final String Accept = "Accept";
    public static final String Deny = "Deny";


    public static final String ASK_HELP = "Зовем волонтера";

    public static final String SHELTER_TYPE_SELECT_MSG_TEXT = "Выберите приют";


    public static final String ERROR = "Возникла ошибка, попробуйте еще раз";

    //1-й уровень кнопок

    public final static String DOG_SHELTER_WELCOME_MSG_TEXT = "Вас приветствует приют для собак. Чем я могу Вам помочь?";
    public final static String CAT_SHELTER_WELCOME_MSG_TEXT = "Вас приветствует приют для кошек. Чем я могу Вам помочь?";

    //2-й уровень кнопок
    public final static String CALL_MAIN_MENU_CAT = "011";
    public final static String CALL_MAIN_MENU_DOG = "012";
    public final static String CALL_ID_SHELTER_INFORMATION_CAT_MENU = "021";
    public final static String CALL_ID_SHELTER_INFORMATION_DOG_MENU = "022";
    public final static String CALL_Pet_MENU_CAT = "031";
    public final static String CALL_Pet_MENU_DOG = "032";
    public final static String DOWNLOAD_LINK = "Для скачивания файла перейдите по ссылке - http://localhost:8080/attachments/get/";
    public final static String WORK_SCHEDULE_CAT = "Для получения информации по расположению и режиму работы перейдите по ссылке - https://yandex.ru/maps/org/murkosha/1807729764/?ll=37.151500%2C55.881819&source=serp_navig&z=9";
    public final static String REGISTRATION_CAR_CAT = "Контакты охранника";
    public final static String WORK_SCHEDULE_DOG = "Для получения информации по расположению и режиму работы перейдите по ссылке -https://yandex.ru/maps/org/iskra/58489882123/?ll=37.503295%2C55.863665&source=serp_navig&z=10.8";
    public final static String REGISTRATION_CAR_DOG = "Контакты охранника";

    public final static Shelter shelterCat = new Shelter("Cats shelter", CAT_SHELTER, WORK_SCHEDULE_CAT, WORK_SCHEDULE_CAT, REGISTRATION_CAR_CAT);
    public final static Shelter shelterDog = new Shelter("Dogs shelter", DOG_SHELTER, WORK_SCHEDULE_DOG, WORK_SCHEDULE_DOG, REGISTRATION_CAR_DOG);
    public final static String CREATE = "Для регистрации в нашем приюте отправте контактые данные строго в формате:" +
            "Иван Иванов,21,999-000-11-11,Москва Название улицы 9.Внимание если вы хотите отменить операцию, отправте боту сообщение -//zero.Иначе дальнейшая работа бота приведет к ошибке";
    public final static String SendPhoto = "Далее  отправьте фото боту стандартным способом, с прикрепленной подписью к фото в формате -*Имя отчета(см конпка Получить название текущего отчета для отправки).Внимание если вы хотите отменить операцию, отправте боту сообщение -//zero.Иначе дальнейшая работа бота приведет к ошибке";
    public final static String Send = "Далее  отправьте Имя питомца боту  в сообщении.Внимание если вы хотите отменить операцию, отправте боту сообщение -//zero.Иначе дальнейшая работа бота приведет к ошибке";
    public final static String PhotoReport = "фото отчет";
    public final static String SendText = "Далее  отправьте в сообщении боту текст с отчетом в формате- Имя отчета(см конпка Получить название текущего отчета для отправки),текст отчета. Внимание если вы хотите отменить операцию, отправте боту сообщение -//zero.Иначе дальнейшая работа бота приведет к ошибке";
    public final static String Zero_CallBack = "//zero";
    public final static String Zero_Massage = "Операция отменена";
    public final static String CALLBACK = "@lexpav21";

    public final static String Close_Question = "Close_Question";

    public final static String DOG_SHELTER_HELLO = ":Добро пожаловать в мени питомника для собак";
    public final static String CAT_SHELTER_HELLO = "Добро пожаловать в мени питомника для кошек";


    public final static String DOG_SHELTER_CALLBACK = "DOG_SHELTER_CALLBACK";
    public final static String CAT_SHELTER_CALLBACK = "CAT_SHELTER_CALLBACK";
    public final static String WORK_SCHEDULE = "021_WORK_SCHEDULE";
    public final static String REGISTRATION_CARCat = "021_REGISTRATION_CAR";
    public final static String SAFETYCat = "021_SAFETY";
    public final static String CREATECat = "021_CREATE";
    public final static String CALLCat = "021_CALL";
    public final static String WORK_SCHEDULEDog = "022_WORK_SCHEDULE";
    public final static String REGISTRATION_CARDog = "022_REGISTRATION_CAR";
    public final static String SAFETYDog = "022_SAFETY";
    public final static String CREATEDog = "022_CREATE";
    public final static String CALLDog = "022_CALL";

    public final static Long CHAT_ID = 332L;


    public final static String PetCatsList = "031_PetCatsList";
    public final static String RulesDatingCat = "031_RulesDatingCat";
    public final static String DocCat = "031_DocCat";
    public final static String TransportOfCat = "031_TransportOfCat";
    public final static String HomeCatsChild = "031_HomeCatsChild";
    public final static String HomeCatsAdult = "031_HomeCatsAdult";
    public final static String HomeCatsDisabilities = "031_HomeCatsDisabilities";
    public final static String FailCats = "031_FailCats";
    public final static String CREATECats_31 = "031_CREATE";
    public final static String CALLCats_31 = "031_CALL";


    public final static String PetDogList = "032_PetDogList";
    public final static String RulesDatingDog = "032_RulesDatingDog";
    public final static String DocDog = "032_DocDog";
    public final static String TransportOfDog = "032_TransportOfDog";
    public final static String HomeDogsChild = "032_HomeDogsChild";
    public final static String HomeDogsAdult = "032_HomeDogsAdult";
    public final static String HomeDogsDisabilities = "032_HomeDogsDisabilities";
    public final static String DogHandlerFirstTime = "032_DogHandlerFirstTime";
    public final static String DogHandlerRecommendation = "032_DogHandlerRecommendation";
    public final static String FailDogs = "032_FailDogs";
    public final static String CREATEDogs_32 = "032_CREATE";
    public final static String CALLDogs_32 = "032_CALL";


    public final static String DogShelterInfo = "012_DogShelterInfo";
    public final static String DogsPetsInfo = "012_DogsPetsInfo";
    public final static String DogsControlService = "012_DogsControlService";
    public final static String CALLDogs_12 = "012_CALL";


    public final static String CatShelterInfo = "011_CatShelterInfo";
    public final static String CatsPetsInfo = "011_CatsPetsInfo";
    public final static String CatsControlService = "011_CatsControlService";
    public final static String CALLCats_12 = "011_CALLCat";
    public final static String Report_Name = "Для получения имени текущего отчета отправьте имя питомца";

    public final static String A__11 = "attach__11.jpg";
    public final static String A__00 = "attach__00.jpg";
    public final static String A__01 ="attach__01.docx";
    public final static String A__021 ="attach__021.docx";
    public final static String A__022 ="attach__022.docx";
    public final static String A__023 ="attach__023.docx";
    public final static String A__024 ="attach__22_024.docx";
    public final static String A__025 ="attach__22_025.docx";
    public final static String A__026 ="attach__22_026.docx";
    public final static String A__027 ="attach__22_027.docx";
    public final static String A__028 ="attach__22_028.docx";
    public final static String A__029 ="attach__22_029.docx";

    public final static String A__24 ="attach__21_024.docx";
    public final static String A__25 ="attach__21_025.docx";
    public final static String A__26 ="attach__21_026.docx";
    public final static String A__27 ="attach__21_027.docx";

    public final static String A__000="правила.txt";
    public final static String ErrorGetPet="Вы еще не зарегистрированы, пожалуйста пройдите регистрацию через отправку контактов";

    public final static String BUTTON_HOW_TO_PICK_UP_TEXT = "Как взять питомца из приюта";
    public final static String BUTTON_SEND_REPORT_TEXT = "Прислать отчет о питомце";
    public final static String BUTTON_CALL_VOLUNTEER_TEXT = "Позвать волонтера";
    public final static String BUTTON_BACK_TEXT = "Вернутся назад";





    //3-й уровень кнопок
    //Информация о приюте


}
