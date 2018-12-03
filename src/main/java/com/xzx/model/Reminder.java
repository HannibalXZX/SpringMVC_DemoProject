package com.xzx.model;

import java.sql.Timestamp;

public class Reminder {
    int Rid;
    int Pid;
    int Did;
    StringBuffer description;
    String priority;
    Timestamp startTime;
    Timestamp durationTime;
    Timestamp endTime;
    int isExceeded;


    public Reminder(int pid, int did, StringBuffer description, String priority, Timestamp startTime, Timestamp durationTime, Timestamp endTime, int isExceeded) {
        Pid = pid;
        Did = did;
        this.description = description;
        this.priority = priority;
        this.startTime = startTime;
        this.durationTime = durationTime;
        this.endTime = endTime;
        this.isExceeded = isExceeded;
    }
    public int getRid() {
        return Rid;
    }

    public void setRid(int rid) {
        Rid = rid;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public int getDid() {
        return Did;
    }

    public void setDid(int did) {
        Did = did;
    }

    public StringBuffer getDescription() {
        return description;
    }

    public void setDescription(StringBuffer description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Timestamp durationTime) {
        this.durationTime = durationTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getIsExceeded() {
        return isExceeded;
    }

    public void setIsExceeded(int isExceeded) {
        this.isExceeded = isExceeded;
    }
}
