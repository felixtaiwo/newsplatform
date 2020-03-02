package newsplatfrom;

import newsplatfrom.Repository.NewsRepository;
import newsplatfrom.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RegService {
    @Autowired
    newsplatfrom.Repository.UserRepository UserRepository;
    @Autowired
    NewsRepository newsRepository;
    public void addUser(User users) {
        UserRepository.save(users);
    }
    public List<User> getall(){
        return UserRepository.findAll();
    }
    public Page<News> getallNews(int page) {
        Pageable paging = PageRequest.of(page, 10, Sort.Direction.DESC, "dateAndTime");
        return newsRepository.findIt(paging);
    }
    public void postNews(News news) {
        newsRepository.save(news);
    }

    public void deleteNews(int id) {
        newsRepository.deleteById(id);
    }

    public void deleteUser(String emailAddress) {
        UserRepository.deleteByEmailAddress(emailAddress);
    }

    public Optional<News> getNews(int newsId) {
        return newsRepository.findById(newsId);
    }
}
