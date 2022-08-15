package edu.openbank.digital.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Statistic {

    @Id
    @GeneratedValue
    private long statisticId;
    private Timestamp timeCreateStatistic;

    public long getStatisticId() {
        return statisticId;
    }

    public Statistic(){
    }

    public Statistic(long statisticId, Timestamp timeCreateStatistic){
        this.statisticId = statisticId;
        this.timeCreateStatistic = timeCreateStatistic;
    }

    public void setStatisticId(long statisticId) {
        this.statisticId = statisticId;
    }

    public Timestamp getTimeCreateStatistic() {
        return timeCreateStatistic;
    }

    public void setTimeCreateStatistic(Timestamp timeCreateStatistic) {
        this.timeCreateStatistic = timeCreateStatistic;
    }
}
