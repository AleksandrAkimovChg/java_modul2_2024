package homework.modul2.homework3.ex5;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Comparator<Review> compareReview = (arg1, arg2) -> {
            int getLike = arg1.getLike().compareTo(arg2.getLike());
            int getDateTime = arg1.getDateTime().compareTo(arg2.getDateTime());
            int getId = arg1.getId().compareTo(arg1.getId());

            if (getLike != 0) {
                return getLike;
            } else if (getDateTime != 0) {
                return getDateTime;
            }
            return getId;
        };

        Review review1 = new Review(1, "отличный товар", 200, "25.01.2024 13:37");
        Review review2 = new Review(2, "так себе товар", 100, "25.01.2024 16:37");
        Review review3 = new Review(4, "плохой товар", 100, "25.01.2024 13:37");
        Review review4 = new Review(3, "плохой товар", 100, "25.01.2024 13:37");
        ArrayList<Review> reviews = new ArrayList<>(List.of(review1, review2, review3, review4));
        reviews.sort(compareReview.reversed());
        System.out.println(reviews);
    }
}
