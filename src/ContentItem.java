import java.util.Calendar;

public abstract class ContentItem {
    private int id;
    private static int idGen = 1;
    private String title;
    private int year;
    private int durationMinutes;

    //constructor
    public ContentItem(String title, int year, int durationMinutes){
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);

    }

    //setters
    public void setTitle(String title){
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }
    public void setYear(int year){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(year < 1990 || year > currentYear){
            throw new IllegalArgumentException("Year out of range");
        }
        this.year = year;
    }
    public void setDurationMinutes(int durationMinutes){
        if(durationMinutes < 0) {
            throw new IllegalArgumentException("Duration cannot less than 0");
        }
        this.durationMinutes = durationMinutes;
    }

    //getters
    public int getId(){
        return this.id;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }

    //methods
    public int getAge(int currentYear){
        return (currentYear - this.year);
    }
    //abstract method
    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "Content ID: " + getId() + "\nTitle: " + getTitle() + "\nYear: " + getYear() + "\nDuration: " + getDurationMinutes() + " Minutes";
    }
}
