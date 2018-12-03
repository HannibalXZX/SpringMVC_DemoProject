package com.xzx.service;

import com.xzx.model.Doctor;
import com.xzx.model.Priority;

import java.util.List;

public interface DoctorService {

    public void AddDoctor(Doctor doctor);

  //  public boolean Match(String Dname,String password);

    public  int findDidByDname(String Dname);

    public List<Priority> ReminderListOrderByPriority(int Did);

}
