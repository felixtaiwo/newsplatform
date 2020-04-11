package newsplatform.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="emailAddress"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String emailAddress;
    @NotNull
    private String password;
    private String role ="USER" ;


    public User() {
    }

    public User(int userId, String emailAddress, @NotNull String password,String role) {
        this.userId=userId;
        this.emailAddress = emailAddress;
        this.password =password;
        this.role=role;
    }

    public  String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress (String emailAddress) {
       this.emailAddress=emailAddress;}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =  new BCryptPasswordEncoder().encode(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
