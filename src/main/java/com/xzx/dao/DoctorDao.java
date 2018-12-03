package com.xzx.dao;


import com.xzx.model.Doctor;
import com.xzx.model.Priority;
import com.xzx.model.Reminder;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao {

    public void insert(Doctor doctor);

    public Doctor findDoctoryByDid(int Did);

    public int findDidByDname(String Dname);

    public List<Priority> ReminderListOrderByPriority(int Did);


}
