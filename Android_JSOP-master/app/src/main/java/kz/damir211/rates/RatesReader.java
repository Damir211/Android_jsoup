package kz.damir211.rates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

// СОЗДАТЕЛЬ КОТИРОВОК ВАЛЮТ
public class RatesReader {


    public static String getRatesData() {
        StringBuilder data = new StringBuilder();
        try {
            data.append("***Овен***\n" + getRates("aries"));
            data.append("\n***Телец***\n" + getRates("taurus"));
            data.append("\n***Близнецы***\n" + getRates("gemini"));
            data.append("\n***Рак***\n" + getRates("cancer"));
            data.append("\n***Лев***\n" + getRates("leo"));
            data.append("\n***Дева***\n" + getRates("virgo"));
            data.append("\n***Весы***\n" + getRates("libra"));
            data.append("\n***Скорпион***\n" + getRates("scorpio"));
            data.append("\n***Стрелец***\n" + getRates("sagittarius"));
            data.append("\n***Козерог***\n" + getRates("capricorn"));
            data.append("\n***Водолей***\n" + getRates("aquarius"));
            data.append("\n***Рыбы***\n" + getRates("pisces"));
        } catch (Exception ignored) {
            return null; // При ошибке доступа возвращаем null
        }
        return data.toString(); // Возвращаем результат

    }

    public static String getRates (String url) throws IOException {
        String BASE_URL = "https://m.horoscopes.rambler.ru/" + url;
        Document doc = Jsoup.connect(BASE_URL).get();
        Elements e = doc.select("div._1dQ3 > span");
        return(e.text() + "\n");
    }

}