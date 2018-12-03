package com.xzx.service;

import com.xzx.dao.PriorityDaoImpl;
import com.xzx.dao.ReminderDaoImpl;
import com.xzx.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReminderService")
public class ReminderServiceImpl implements ReminderService{
    @Autowired
    private  ReminderDaoImpl reminderDaoImpl;

    @Autowired
    private PriorityDaoImpl priorityDaoImpl;


    public void AddReminder(Reminder reminder) {
    /*    reminderDaoImpl.AddReminder(reminder);
        priorityDaoImpl.Add*/
    }

    public List<Reminder> findRemindersByDid(int Did) {
      //  List<Reminder> reminderList = reminderDaoImpl.findRemindersByDid(Did);
        return null;
    }



    public List<Reminder> SortByPriority(int Did){

        return null;
    }
}
