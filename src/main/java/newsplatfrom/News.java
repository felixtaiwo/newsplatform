package newsplatfrom;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.TextType;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue
    private int newsId;
    @NotNull
    private String newsTitle;
    @NotNull
    @Column(length = 16000)
    private String content;
    @CreationTimestamp
    private Date dateAndTime;


    public News() {
    }

    public News(@NotNull String newsTitle, @NotNull String content, Date dateAndTime) {
        this.newsTitle = newsTitle;
        this.content = content;
        this.dateAndTime = dateAndTime;

    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

}
