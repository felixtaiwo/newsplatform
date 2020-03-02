package newsplatfrom.User;

import com.mysql.cj.protocol.ColumnDefinition;
import com.mysql.cj.protocol.a.ColumnDefinitionReader;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;


@Entity
public class User {

    @Id
    private String emailAddress;
    @NotNull
    private String password;
    private String role ="USER" ;

    public String getEmailAddress() {
        return emailAddress;
    }

    public User() {
    }

    public User(String emailAddress, @NotNull String password,String role) {
        this.emailAddress = emailAddress;
        this.password =password;
        this.role=role;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
