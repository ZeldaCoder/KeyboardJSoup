import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdGenerator {

    private String clientName = "Jeff";
    private String companyName = "Shoe Boys";
    private String targetWord = "color";
    private String product = "shoe";
    private String review = " BLANK REVIEW";

    private ArrayList<String> targetWords = new ArrayList<String>();

    public AdGenerator(ArrayList<DataStruct> revData) {
        System.out.println("\nAd Generator Created!");

        try {
            File targetWordsFile = new File("targetWords.txt");
            Scanner myReader = new Scanner(targetWordsFile);

            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                targetWords.add(word);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        selectTargetWord();
        selectReview(revData);
    }

    public void selectTargetWord() {
        Random rand = new Random();
        int targetChoice = rand.nextInt(0, targetWords.size());
        targetWord = targetWords.get(targetChoice);
    }

    public void selectReview(ArrayList<DataStruct> revData) {
        ArrayList<String> reviewsList = new ArrayList<String>();

        for (DataStruct data: revData) {
            String reviewText = data.getText();

            String[] reviewSplit = reviewText.split(" ");

            for (String word : reviewSplit) {
                String wordLower = word.toLowerCase();
                if (wordLower.equals(targetWord.toLowerCase())) {
                    reviewsList.add(reviewText);
                }
            }
        }

        Random rand = new Random();
        int chosenReview = rand.nextInt(0, reviewsList.size());

        review = reviewsList.get(chosenReview);
    }

    public String createAd() {
        String ad = "Hey " + clientName + ", we at " + companyName + " noticed that you like things that are related to " + targetWord + ". The " + product + " fits under " + targetWord + " because " + review + ". Please consider looking at " + product + ".";

        return ad;
    }

}