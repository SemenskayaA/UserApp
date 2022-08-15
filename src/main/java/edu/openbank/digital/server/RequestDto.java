package edu.openbank.digital.server;

public class RequestDto {

    private Boolean status;
    private long idStatistic;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public long getIdStatistic() {
        return idStatistic;
    }

    public void setIdStatistic(long idStatistic) {
        this.idStatistic = idStatistic;
    }
}
