public class PodcastEpisode extends ContentItem{
    private final String hostName;

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
}
