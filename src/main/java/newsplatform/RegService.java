package newsplatform;

import newsplatform.Comment;
import newsplatform.News;
import newsplatform.Repository.CommentRepository;
import newsplatform.Repository.NewsRepository;
import newsplatform.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RegService {
    @Autowired
    newsplatform.Repository.UserRepository UserRepository;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    CommentRepository commentRepository;
    public void addUser(User users) {
        UserRepository.save(users);
    }
    public Slice<User> getall(){
        return UserRepository.findIt();
    }
    public Page<News> getallNews(int page) {
        Pageable paging = PageRequest.of(page, 10, Sort.Direction.DESC, "dateAndTime");
        return newsRepository.findIt(paging);
    }
    public void postNews(News news) {
        newsRepository.save(news);
    }
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteNews(int id) {
        newsRepository.deleteById(id);
    }

    public void deleteUser(int userId) {
        UserRepository.deleteById(userId);
    }

    public Optional<News> getNews(int newsId) {
        return newsRepository.findById(newsId);
    }
}
