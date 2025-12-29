import java.util.ArrayList;
import java.util.Calendar;

public class ContentDemo {
    public static void main(String[] args){
        ArrayList<ContentItem> items = new ArrayList<>();
        //creating items
        ContentItem video1 = new VideoLecture("Learn Java for beginners", 2023, 43, "HD");
        ContentItem video2 = new VideoLecture("Learn how to draw", 2019, 50, "480p");
        items.add(video1);
        items.add(video2);
        ContentItem podcastEP1 = new PodcastEpisode("Sam with Diana", 2020,23,"Sam Borrow");
        ContentItem podcastEP2 = new PodcastEpisode("Sam with Leo", 2020,31,"Sam Borrow");
        items.add(podcastEP1);
        items.add(podcastEP2);
        //printing
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(ContentItem item: items){
            System.out.println(item + " | Licence Cost: $" + item.getLicenseCost(currentYear)); //automatically called toString
            if(item instanceof Downloadable){
                Downloadable d = (Downloadable) item; //Casting
                d.download();
                System.out.println("Left available downloads per day: " + d.getMaxDownloadsPerDay());
            }
            System.out.println("---------------------------------------");
        }

    }
}
