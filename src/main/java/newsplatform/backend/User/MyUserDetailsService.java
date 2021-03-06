package newsplatform.backend.User;

import newsplatform.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);

        user.orElseThrow(()->new UsernameNotFoundException("Not found:"+emailAddress));
        return user.map(MyUserDetails::new).get();
    }
}
