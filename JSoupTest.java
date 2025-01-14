import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import java.io.FileWriter;

public class JSoupTest
{

    static ArrayList<ArrayList<String>> reviewData = new ArrayList<ArrayList<String>>();



 
     public static void main(String[] args) throws IOException {  

        Document  doc = Jsoup.connect("https://www.bestbuy.com/site/reviews/corsair-k70-rgb-pro-full-size-wired-mechanical-cherry-mx-speed-linear-switch-gaming-keyboard-with-pbt-double-shot-keycaps-black/6491897?variant=A&skuId=6491897&rating=5%2C4%2C3%2C2%2C1")
        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
        .referrer("http://www.google.com")
        .timeout(1000)
        .get();

        
        
        Elements reviewNames = doc.select("p");
        Elements reviews = doc.select("[src]");
        Elements dates = doc.select("link[href]");

        

        try {
            FileWriter writer = new FileWriter("socialMediaPosts.txt");


            for (int i = 0; i < reviewNames.size(); i++) {
                ArrayList<String> data = new ArrayList<String>();
                reviewData.add(data);
                writer.write("#" + i + ": " + reviewData.get(i).get(0) + ", " + reviewData.get(i).get(1) + ", " + reviewData.get(i).get(2));
            }
            // Close the writer
            writer.close();

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}