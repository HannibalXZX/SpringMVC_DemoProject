package com.xzx.model;

public class Priority {
    int Did;
    int Pid;
    String Pname;
    int High;
    int Middle;
    int Low;

    public int getDid() {
        return Did;
    }

    public void setDid(int did) {
        this.Did = did;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public int getHigh() {
        return High;
    }

    public void setHigh(int high) {
        High = high;
    }

    public int getMiddle() {
        return Middle;
    }

    public void setMiddle(int middle) {
        Middle = middle;
    }

    public int getLow() {
        return Low;
    }

    public void setLow(int low) {
        Low = low;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "Did=" + Did +
                ", Pid=" + Pid +
                ", Pname='" + Pname + '\'' +
                ", High=" + High +
                ", Middle=" + Middle +
                ", Low=" + Low +
                '}';
    }
}
