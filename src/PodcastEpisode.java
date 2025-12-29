public class PodcastEpisode extends ContentItem implements Downloadable{
    private final String hostName;
    private static int maxDownloadsPerDay = 10;


    public PodcastEpisode(String title, int year, int durationMinutes, String hostName) {
        super(title, year, durationMinutes);
        this.hostName = hostName;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int ageFactor;
        if(getAge(currentYear) <= 2) {
            ageFactor = 3;
        }else {
            ageFactor = 1;
        }
        double cost = 0.03 * getDurationMinutes() + ageFactor;

        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHost Name: " + this.hostName;
    }


    @Override
    public void download() {
        if(maxDownloadsPerDay > 0)
        {
            System.out.println("Downloading episode: \""+ getTitle() + "\" by " + this.hostName);
            maxDownloadsPerDay--;
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
