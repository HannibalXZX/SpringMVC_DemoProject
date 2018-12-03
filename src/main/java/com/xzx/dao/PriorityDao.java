package com.xzx.dao;

import com.xzx.model.Priority;
import com.xzx.model.Reminder;

import java.util.List;

public interface PriorityDao {
    public void ChangePriorityByPid(String priority,int ChangeValue,int pid);
    public List<Priority> GetSortedResultByDid(int Did);
    public void AddPriority(Reminder reminder);
}
