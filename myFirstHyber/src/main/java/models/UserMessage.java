package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userMessage")
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_name;
    private String message;
    private String to_user;

    public UserMessage() {
    }

    public UserMessage(String user_name, String message, String to_user) {
        this.user_name = user_name;
        this.message = message;
        this.to_user = to_user;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String user_name) {
        this.user_name = user_name;
    }

    public String message() {
        return message;
    }

    public void message(String message) {
        this.message = message;
    }

    public String to_user() {
        return to_user;
    }

    public void to_user(String to_user) {
        this.to_user = to_user;
    }

    @Override
    public String toString() {
        return "models.userMessage{" +
                "id=" + id +
                ", name='" + user_name + '\'' +
                ", message=" + message +
                '}';
    }
}