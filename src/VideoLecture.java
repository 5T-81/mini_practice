public class VideoLecture extends ContentItem implements Downloadable{
    private final String quality;
    private static int maxDownloadsPerDay = 5;

    //constructor
    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes); //call parent's(contentItem) constructor
        this.quality = quality;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        int ageFactor;
        if(getAge(currentYear) <= 2)
        {
            ageFactor = 5;
        }
        else {
            ageFactor = 2;
        }
        double cost = 0.05 * getDurationMinutes() + ageFactor;



        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + "\nQuality: " + this.quality;
    }

    @Override
    public void download() {
        if(maxDownloadsPerDay > 0)
        {
            System.out.println("Downloading \"" + getTitle() +"\" in " + this.quality);
            maxDownloadsPerDay --;
        }
        else {
            System.out.println("Sorry you reached the maximum downloads for today. ");
        }

    }

    @Override
    public int getMaxDownloadsPerDay() {
        return maxDownloadsPerDay;
    }
}
