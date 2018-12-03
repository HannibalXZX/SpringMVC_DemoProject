package com.xzx.dao;

import com.xzx.model.Doctor;
import com.xzx.model.Priority;
import com.xzx.test.DaoUtil;
import com.xzx.test.sqliteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository("DoctorDao")
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

 /*   @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }*/

    public DoctorDaoImpl(){}

    public DoctorDaoImpl(JdbcTemplate template) throws SQLException {
        this.jdbcTemplate = jdbcTemplate;

    }

    public void insert(Doctor doctor) {

        String sql = "insert into demo values(177,'123')";
        this.jdbcTemplate.update(sql);

    }

    public Doctor findDoctoryByDid(int Did) {
        String sql = "select * from Doctor where Did = ?";
        Object[] params = new Object[] { Did };
        List<Doctor> doctorList = this.jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<Doctor>(Doctor.class));
        if (doctorList.size()>0)
            return doctorList.get(0);
        else
            return null;
    }

    public int findDidByDname(String Dname) {
        String sql = "select Did from Doctor where Dname = ?";
        Object[] params = new Object[] { Dname };
        System.out.println(Dname);
        int Did = this.jdbcTemplate.queryForObject(sql,params,Integer.class);
        System.out.println(Did);
        return Did;
    }

    public List<Priority> ReminderListOrderByPriority(int Did) {
        String sql = "select DoctorPatient.Did_F,Pname,High,Middle,Low from DoctorPriorityCount,DoctorPatient,Patient\n" +
                "where DoctorPriorityCount.Did_F = DoctorPatient.Did_F and Pid_F = Pid";
        return null;
    }

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        String sql = "select DoctorPatient.Did,DoctorPatient.Pid,Pname,High,Middle,Low from Priority,DoctorPatient,Patient\n" +
                " where ? = Priority.Did = DoctorPatient.Did and Priority.Pid=DoctorPatient.Pid = Patient.Pid\n" +
                " order by High DESC ,Middle DESC,Low DESC ;";
        System.out.println(sql);
        Object[] params = new Object[] {1};
        List<Priority> priorityList = jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<Priority>(Priority.class));
        for (Priority priority : priorityList){
            System.out.println(priority.toString());
        }
  /*      String Dname ="Doctor1";
        String sql = "select Did from Doctor where Dname = ?";
        System.out.println(sql);
        Object[] params = new Object[] { Dname };
        int Did = jdbcTemplate.queryForObject(sql,params,Integer.class);
        System.out.println(Did);*/
    }

}
