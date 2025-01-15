import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import java.io.FileWriter;
import javax.lang.model.element.Element;

public class JSoupTest
{

    static ArrayList<DataStruct> reviewData = new ArrayList<DataStruct>();


    static ArrayList<String> listOfUsers = new ArrayList<String>();
    static ArrayList<String> listOfReviews = new ArrayList<String>();
    static ArrayList<String> listOfDates = new ArrayList<String>();
    static ArrayList<Double> listOfNums = new ArrayList<Double>();



 
     public static void main(String[] args) throws IOException {  

        Document  doc = Jsoup.connect("https://www.zappos.com/product/review/9912200/page/1/orderBy/best")
        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
        .referrer("http://www.google.com")
        .timeout(100000)
        .get();

        System.out.println("test1");
        
        Elements reviewNames = doc.select("[itemprop=author]");
        Elements reviews = doc.select("[itemprop=reviewBody]"); 
        Elements dates = doc.select("[itemprop=datePublished]");
        Elements reviewNum = doc.select("meta[itemprop=ratingValue]");

        for (Element e : reviewNames) {
            listOfUsers.add(e.text());
        }

        System.out.println("\n Review Names:");
        for (String u : listOfUsers) {
            System.out.println(u);
        }

        for (Element e : reviews) {
            listOfReviews.add(e.text());
        }

        System.out.println("\n Reviews:");
        for (String u : listOfReviews) {
            System.out.println(u);
        }

        for (Element e : dates) {
            listOfDates.add(e.text());
        }

        System.out.println("\n Dates:");
        for (String u : listOfDates) {
            System.out.println(u);
        }


        for(Element e : reviewNum) {
            double reviewNumber = Double.parseDouble(e.attr("content"));
            listOfNums.add(reviewNumber);
        }

        for (int i = 0; i < reviews.size(); i++) {
            DataStruct data = new DataStruct(listOfUsers.get(i), listOfReviews.get(i), listOfDates.get(i), listOfNums.get(i));
            reviewData.add(data);
        }

        System.out.print("test2");
          
        
        

        try {
            FileWriter writer = new FileWriter("socialMediaPosts.txt");

            System.out.print("test3");

            for (int i = 0; i < reviewData.size(); i++) {
                String formatData = reviewData.get(i).printData();
                writer.write(i + ") " + formatData + "\n");
            }
            // Close the writer
            writer.close();


            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}