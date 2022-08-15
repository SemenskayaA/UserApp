package edu.openbank.digital.user;

public class StatusDto {
    private long userId;
    private Boolean isOnlineActual;
    private Boolean isOnlineLast;

    public StatusDto(){
    }

    public StatusDto(long userId, Boolean isOnlineActual){
        this.userId = userId;
        this.isOnlineActual = isOnlineActual;
    }

    public StatusDto(long userId, Boolean isOnlineActual, Boolean isOnlineLast){
        this.userId = userId;
        this.isOnlineActual = isOnlineActual;
        this.isOnlineLast = isOnlineLast;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Boolean getIsOnlineActual() {
        return isOnlineActual;
    }

    public void setIsOnlineActual(Boolean onlineActual) {
        isOnlineActual = onlineActual;
    }

    public Boolean getIsOnlineLast() {
        return isOnlineLast;
    }

    public void setIsOnlineLast(Boolean onlineLast) {
        isOnlineLast = onlineLast;
    }
}
