package edu.openbank.digital.server;

import java.util.List;

public class StatisticDto {
    private long idStatistic;

    private List<UserStatisticDto> list;

    public StatisticDto(long id, List<UserStatisticDto> list){
        this.idStatistic = id;
        this.list = list;
    }

    public long getIdStatistic() {
        return idStatistic;
    }

    public void setIdStatistic(long idStatistic) {
        this.idStatistic = idStatistic;
    }

    public List<UserStatisticDto> getList() {
        return list;
    }

    public void setList(List<UserStatisticDto> list) {
        this.list = list;
    }
}
