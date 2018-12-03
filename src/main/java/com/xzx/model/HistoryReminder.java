package com.xzx.model;

import java.util.Date;
import java.util.List;

public class HistoryReminder {
    List<String> RecentSeventDay;
    List<Integer> SenventDayUnfinished;

    public HistoryReminder(List<String> recentSeventDay, List<Integer> senventDayUnfinished) {

        RecentSeventDay = recentSeventDay;
        SenventDayUnfinished = senventDayUnfinished;
    }

    public HistoryReminder() {
    }

    public List<String> getRecentSeventDay() {

        return RecentSeventDay;
    }

    public void setRecentSeventDay(List<String> recentSeventDay) {
        RecentSeventDay = recentSeventDay;
    }

    public List<Integer> getSenventDayUnfinished() {
        return SenventDayUnfinished;
    }

    public void setSenventDayUnfinished(List<Integer> senventDayUnfinished) {
        SenventDayUnfinished = senventDayUnfinished;
    }
}
