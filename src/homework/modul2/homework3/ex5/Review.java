package homework.modul2.homework3.ex5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Review {
    private static int count;
    private final Integer id;
    private final String text;
    private final Integer like;
    private final LocalDateTime dateTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final LocalDateTime timestamp;

    public Review(int id, String text, Integer like, String dateTime) {
        ++count;
        this.id = id;
        this.text = text;
        this.like = like;
        this.dateTime = LocalDateTime.parse(dateTime, formatter);
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        this.timestamp = LocalDateTime.now(zoneId);
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getLike() {
        return like;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Review{\n" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", like=" + like +
                ", dateTime=" + dateTime.format(formatter) +
                "\n" +
                '}';
    }
}
