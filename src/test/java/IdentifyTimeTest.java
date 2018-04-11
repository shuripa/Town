import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.*;

public class IdentifyTimeTest {
    //1. Определить время в зависимости от часового пояса
        //1.1 Не указан город вывести исключение
        //1.2 Указан только город. Сравнить со списком идентефикаторов часовх поясов.
            //1.2.1 Определяется тайм-зона. Определить время по определямеой тайм-зоне.
            //1.2.2 Не определяется тайм-зона. Определить системное время.
        //1.3 Указан город и тайм зона. Использовать параметр тайм-зона.
    //2. Вывести приветсвенное сообщение в зависимости от времени. Сообщения должны быть получены из Message Resource и переведены на русский язык.
    //3. Создание логфайла.



    @Test
    public void testConstructorIdentifyTime(){
        IdentifyTime idTime;
        TimeZone tz;

        //1.1 Параметры не заданы.
        try {
            idTime = new IdentifyTime();
        }catch (RuntimeException e){
            assertTrue(e.getMessage().equals("Не задан город"));
        }


        //1.2 Указать город. Получить таймзону если город определяется или системную таймзону если не определяется.
        idTime = new IdentifyTime("Kyiv");
//        assertTrue(idTime.identifyTimeZone().equals("GMT+02:00"));
        idTime = new IdentifyTime("Dnipro");
//        assertTrue(idTime.identifyTimeZone().equals("GMT+02:00"));

    }
}