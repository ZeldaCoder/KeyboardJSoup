public class DataStruct {
    private String reviewUserName = "";
    private String reviewText = "";
    private String reviewDate = "";
    private double reviewNum = 0;

    private String formattedReview = "";

    DataStruct(String rN, String rT, String rD, double  n) {
        reviewUserName = rN;
        reviewText = rT;
        reviewDate = rD;
        reviewNum = n;
    }

    public void setUserName(String uN) {
        reviewUserName = uN;
    }

    public String getUserName() {
        return reviewUserName;
    }

    public String getText() {
        return reviewText;
    }

    public String getDate() {
        return reviewDate;
    }

    public String printData() {
        formattedReview = "User: " + reviewUserName + ", Rating: " + reviewNum + ", Review: " + reviewText + ", Date: " + reviewDate;
        System.out.println("\n **");
        System.out.print(formattedReview);

        return formattedReview;
    }
}
