public class VideoLecture extends ContentItem{
    private final String quality;

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
        return super.toString() + "\nQuality" + this.quality;
    }
}
