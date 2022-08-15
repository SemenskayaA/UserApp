package edu.openbank.digital.server;


public class UserStatisticDto {

    private String name;

    private boolean isOnline;

    private String url;

    public UserStatisticDto() {
    }

    public UserStatisticDto(String name, boolean isOnline, String url) {
        this.name = name;
        this.isOnline = isOnline;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean online) {
        isOnline = online;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
