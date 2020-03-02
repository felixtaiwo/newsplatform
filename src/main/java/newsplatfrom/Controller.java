package newsplatfrom;

import newsplatfrom.Repository.NewsRepository;
import newsplatfrom.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    RegService regService;

    @RequestMapping(method = RequestMethod.POST, value="/signUp")
    public String signUp(@RequestBody User user) {
        regService.addUser(user);
        return "Registration successful!";
    }
    @RequestMapping("/getAllUsers")
    public List<User> getAll(){
        return regService.getall();
    }
    @RequestMapping(value ="/page={page}")
    public Page<News> home(@PathVariable int page)  {
        return regService.getallNews(page);
    }
    @RequestMapping(value="/news/{newsId}")
    public Optional<News> getNews(@PathVariable int newsId) {
        return regService.getNews(newsId);
    }
    @RequestMapping(value="/postNews", method = RequestMethod.POST)
    public String postNews (@RequestBody News news) {
        regService.postNews(news);
        return"News Successfully posted";
    }
    @RequestMapping(value="/delete/news/{id}", method = RequestMethod.DELETE)
    public String deleteNews(@PathVariable int id) {
        regService.deleteNews(id);
        return "News Successfully deleted";
    }
    @RequestMapping(value="/delete/user/{emailAddress}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String emailAddress) {
        regService.deleteUser(emailAddress);
        return "User Successfully Deleted";
    }
}
