package edu.openbank.digital.user;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String url;

    private String name;

    @Column(unique = true)
    private String email;

    private Timestamp statusChangeTime;

    private boolean isOnline = false;

    public User(){
    }

    public User(String url, String name, String email){
        this.url = url;
        this.name = name;
        this.email = email;
    }

    public User(long id, String url, String name, String email, Timestamp statusChangeTime, boolean isOnline){
        this.id = id;
        this.url = url;
        this.name = name;
        this.email = email;
        this.statusChangeTime = statusChangeTime;
        this.isOnline = isOnline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Timestamp getStatusChangeTime() {
        return statusChangeTime;
    }

    public void setStatusChangeTime(Timestamp statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
    }
}
