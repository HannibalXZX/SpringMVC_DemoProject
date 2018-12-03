package com.xzx.service;

import com.xzx.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ReminderService {
    public List<Reminder> findRemindersByDid(int Did);



}
