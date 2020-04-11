package newsplatform;

import newsplatform.Comment;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newsId;
    @NotNull
    private String newsTitle;
    @NotNull
    @Column(length = 16000)
    private String content;
    @CreationTimestamp
    private Date dateAndTime;
    @OneToMany(mappedBy = "news")
    private List<Comment> comment = new ArrayList<Comment>();


    public News() {
    }


    public News(int newsId, @NotNull String newsTitle, @NotNull String content, Date dateAndTime, List<Comment> comments) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.content = content;
        this.dateAndTime = dateAndTime;
        this.comment = comment;
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

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

}