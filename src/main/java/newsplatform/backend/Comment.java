package newsplatform.backend;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    @Column(length = 16000)
    private String comment;
    @CreationTimestamp
    private Date time;
    private String postedBy;
    @ManyToOne
    private News news;


    public Comment() {
    }


    public Comment(int commentId, String comment, Date time, @NotNull String postedBy, int newsId) {
        this.commentId = commentId;
        this.comment = comment;
        this.time = time;
        this.postedBy = "postedBy";
        this.news = new News(newsId,"","",null,null);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }


    public void setNews(News news) {
        this.news = news;
    }
}

