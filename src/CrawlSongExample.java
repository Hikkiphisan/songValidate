import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/playlist/nhac-nhat-hay-nhat-various-artists.oxf2WDl3Sp5d.html");
            Scanner scanner= new Scanner(new InputStreamReader(url.openStream()));

            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            scanner.close();
            content = content.replaceAll("\\n+","");
//            Pattern pattern = Pattern.compile("href='/'>(.*?)</a>");
//            Pattern pattern = Pattern.compile("name_song">(.*?)</a>");
            Pattern pattern = Pattern.compile("class=\"name_song\">(.*?)</a");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }


        } catch (IOException o) {
            o.printStackTrace();
        }

    }
}
