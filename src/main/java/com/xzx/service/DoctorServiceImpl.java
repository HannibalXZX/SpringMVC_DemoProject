package com.xzx.service;

import com.xzx.dao.DoctorDaoImpl;
import com.xzx.dao.PriorityDaoImpl;
import com.xzx.model.Doctor;
import com.xzx.model.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("DoctorService")
public class DoctorServiceImpl implements DoctorService {
    private static List<Doctor> Doctors;

    @Autowired
    private DoctorDaoImpl doctorDaoImpl;

    @Autowired
    private PriorityDaoImpl priorityDaoImpl;

    public void AddDoctor(Doctor doctor) {
        doctorDaoImpl.insert(doctor);
    }

    public boolean Match(int Did, String password) {
        Doctor doctor = doctorDaoImpl.findDoctoryByDid(Did);
        if (password.equals(doctor.getDpwd()))
            return true;
        return false;
    }


    public int findDidByDname(String Dname) {

        int Did = doctorDaoImpl.findDidByDname(Dname);
        return Did;
    }

    public List<Priority> ReminderListOrderByPriority(int Did) {
       // doctorDaoImpl.
        return priorityDaoImpl.GetSortedResultByDid(Did);
    }
}
