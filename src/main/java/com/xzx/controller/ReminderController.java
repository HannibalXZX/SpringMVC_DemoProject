package com.xzx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xzx.model.Reminder;
import com.xzx.service.ReminderService;
import com.xzx.service.ReminderServiceImpl;
import com.xzx.util.DateToTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class ReminderController {
    protected HttpHeaders httpHeaders = new HttpHeaders();
    @Autowired
    private ReminderServiceImpl reminderServiceImpl;


    public ResponseEntity<String> findRemindersByDid(){
        int Did = 1;
        List<Reminder> reminderList = reminderServiceImpl.findRemindersByDid(Did);
        String result = JSON.toJSONString(reminderList);
        System.out.println(result);
        return new ResponseEntity<String>(result,httpHeaders,HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/Docotor",method = RequestMethod.GET)
    public ResponseEntity<String> AddReminder(@RequestParam("Did") int Did,@RequestParam("Pid") int Pid,
                                              @RequestParam("description") StringBuffer description,
                                              @RequestParam("priority") String  priority,
                                              @RequestParam("starttime") Date starttime,
                                              @RequestParam("endTime") Date endtime,
                                              @RequestParam("durationTime") Date durationtime)
    {
        Timestamp startTime = DateToTimestamp.DateTransTimestamp(starttime);
        Timestamp durationTime = DateToTimestamp.DateTransTimestamp(durationtime);
        Timestamp endTime = DateToTimestamp.DateTransTimestamp(endtime);

        Reminder reminder = new Reminder(Did,Pid,description,priority,startTime,durationTime,endTime,0);
        reminderServiceImpl.AddReminder(reminder);

        List<Reminder> reminderList = reminderServiceImpl.findRemindersByDid(Did);
        String result = JSON.toJSONString(reminderList);
        System.out.println(result);
        return new ResponseEntity<String>(result,httpHeaders,HttpStatus.ACCEPTED);
    }
}
