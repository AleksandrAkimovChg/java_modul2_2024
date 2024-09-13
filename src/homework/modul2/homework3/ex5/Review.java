package homework.modul2.homework3.ex5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Review {
    private static int count;
    private Integer id;
    private String text;
    private Integer like;
    private LocalDateTime dateTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private LocalDateTime timestamp;
    private final ZoneId zoneId = ZoneId.of("Europe/Moscow");

    public Review(int id, String text, Integer like, String dateTime) {
        ++count;
        this.id = id;
        this.text = text;
        this.like = like;
        this.dateTime = LocalDateTime.parse(dateTime, formatter);
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
