package com.xzx.dao;

import com.xzx.model.Priority;
import com.xzx.model.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriorityDaoImpl implements PriorityDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void ChangePriorityByPid(String priority,int ChangeValue,int pid) {
        String sql = "update Priority set "+priority+"ChangeValue "+ " where Pid_F = " + pid;
    }

    public List<Priority> GetSortedResultByDid(int Did){
        String sql = "select DoctorPatient.Did,Patient.Pid,Patient.Pname,High,Middle,Low\n" +
                " from (Priority join DoctorPatient on Priority.Did = DoctorPatient.Did\n" +
                " and DoctorPatient.Pid = Priority.Pid) join Patient on Priority.Pid=Patient.Pid where Priority.Did = ? \n" +
                " order by High DESC ,Middle DESC,Low DESC";
        Object[] params = new Object[] {Did};
        List<Priority> priorityList = jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<Priority>(Priority.class));
        return priorityList;
    }

    public void AddPriority(Reminder reminder){
/*        int priority;
        if (reminder.getPriority().equals("High"))
            priority = 2;
        else if (reminder.getPriority().equals("Middle"))
            priority = 1;
        else priority = 0;*/
        String priority = reminder.getPriority();

        String sql= " Update Priority set " +priority+" = " + priority  +" +1 where Did = ? and Pid = ? ";
        Object [] parms = new Object[]{reminder.getDid(),reminder.getPid()};
        this.jdbcTemplate.update(sql);

    }
}
