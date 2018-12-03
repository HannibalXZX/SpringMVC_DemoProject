package com.xzx.dao;

import com.xzx.model.Reminder;
import com.xzx.test.DaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReminderDaoImpl implements ReminderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void AddReminder(Reminder reminder) {
        String sql = "Insert into Reminder values(?,?,?,?)";
        String startTime = DaoUtil.TransTimestampToSqlDate(reminder.getStartTime());
        String durationTime = DaoUtil.TransTimestampToSqlDate(reminder.getDurationTime());
        String endTime = DaoUtil.TransTimestampToSqlDate(reminder.getEndTime());
    //    this.jdbcTemplate.update(sql,reminder.);

    }

    public List<Reminder> findRemindersByDid(String Did){
        String sql = "select * from Reminder where Did = "+Did;
        List<Reminder> reminderList =  this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<Reminder>(Reminder.class));
        return reminderList;
    }

    public List<Integer> getPriorityNum(String Did){
        List<Integer> priorityList = new ArrayList<Integer>();
        String sql = "select count(*) from Reminder where Did_F="+Did+" AND priority=0";
        int priority0count = this.jdbcTemplate.queryForObject(sql,Integer.class);
        sql = "select count(*) from Reminder where Did_F="+Did+" AND priority=1";
        int priority1count = this.jdbcTemplate.queryForObject(sql,Integer.class);
        sql = "select count(*) from Reminder where Did_F="+Did+" AND priority=2";
        int priority2count = this.jdbcTemplate.queryForObject(sql,Integer.class);
        priorityList.add(priority0count);
        priorityList.add(priority1count);
        priorityList.add(priority2count);
        return priorityList;
    }


}
