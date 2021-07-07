package newsplatform.backend;

import newsplatform.backend.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController("/api")
public class Controller {
    @Autowired
    RegService regService;

    @RequestMapping(method = RequestMethod.POST, value="/signUp")
    public String signUp(@RequestBody User user) {
        regService.addUser(user);
        return "Hi"+user.getEmailAddress()+"Registration successful!";
    }
    @RequestMapping("/getAllUsers")
    public Slice<User> getAll(){

        return regService.getall();
    }
    @RequestMapping(value ="/")
    public Page<News> home(@RequestParam(name = "page", defaultValue = "0") int page)  {
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
    }@RequestMapping(value="/delete/news/{id}", method = RequestMethod.DELETE)
    public String deleteNews(@PathVariable int id) {
        regService.deleteNews(id);
        return "News Successfully deleted";
    }
    @RequestMapping(value="/delete/user/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int userId) {
        regService.deleteUser(userId);
        return "User Successfully Deleted";
    }
    @RequestMapping(value="/news/{newsId}/comment", method = RequestMethod.POST)
    public String addComment(@RequestBody Comment comment, @PathVariable int newsId) {
        comment.setNews(new News(newsId,"","",null,null));
        regService.addComment(comment);
        return "comment added successfully";
    }
}
