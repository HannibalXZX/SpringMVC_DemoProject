package com.xzx.dao;

import com.xzx.model.Reminder;

import java.util.List;

public interface ReminderDao {

    public List<Reminder> findRemindersByDid(String Did);

  //  public void ChangePriorityByPid(int pid,int priority);
}
