package Service.Test;

/*
 * This example shows how to use Java to build http connection and request
 * the ltp-cloud service for perform full-stack Chinese language analysis
 * and get results in specified formats
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TestYun {
    public static void main(String[] args) throws IOException {

        String api_key = "P1Z647n0FRgfDd3DSrqqntRr6ESLsHSWIPqFQwIE";
        String pattern = "all";
        String format  = "json";
        String text    = "我爱北京天安门。";
        text = URLEncoder.encode(text, "utf-8");

        URL url     = new URL("http://api.ltp-cloud.com/analysis/?"
                              + "api_key=" + api_key + "&"
                              + "text="    + text    + "&"
                              + "format="  + format  + "&"
                              + "pattern=" + pattern);
        URLConnection conn = url.openConnection();
        conn.connect();

        BufferedReader innet = new BufferedReader(new InputStreamReader(
                                conn.getInputStream(),
                                "utf-8"));
        String line;
        while ((line = innet.readLine())!= null) {
            System.out.println(line);
        }
        innet.close();
    }
}