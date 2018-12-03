package com.xzx.controller;

import com.alibaba.fastjson.JSON;
import com.xzx.model.Priority;
import com.xzx.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(value="userName")

public class DoctorController {
    protected HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    DoctorServiceImpl doctorService;

    @RequestMapping(value = "/Login",produces="text/html;charset=UTF-8")
    public  ModelAndView  Index(String userName,String password) throws IOException{
        System.out.println("Class:DoctolController, Method:Index");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Login");
        return  mav;

    }


    @RequestMapping(value = "/LoginCheck",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public  ModelAndView  LoginCheck(String userName,String password) throws IOException{
        System.out.println("Class:DoctolController, Method:LoginCheck");
        ModelAndView mav = new ModelAndView("session");
        mav.addObject("userName",userName);
        int Did = doctorService.findDidByDname(userName);
        mav.setViewName("Doctor");
        mav.addObject("Did",Did);
        return  mav;

    }


    @RequestMapping(value = "/index",method = RequestMethod.GET,produces="application/json ;charset=UTF-8")
    public  ResponseEntity<String> test() throws IOException{
            String  result ="123";
            return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
    }
    @ResponseBody
    @RequestMapping(value = "/Doctor/{Did}/{pname}")
    public ModelAndView ListHistoryReminder(@PathVariable("Did") int Did
    ,@PathVariable("pname") String pname){
        ModelAndView mav = new ModelAndView();
        List<String> dateList =new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();
        Calendar c = Calendar.getInstance();
        Date d;
        String day;
        SimpleDateFormat format;
        for(int i=-7;i<0;i++){
            c = Calendar.getInstance();
            format = new SimpleDateFormat("yyyy-MM-dd");
            //过去七天
            c.setTime(new Date());
            c.add(Calendar.DATE, i);
            d = c.getTime();
            day = format.format(d);
            dateList.add(day);
            numList.add(i+20);
        }
        System.out.println(dateList.get(0));
        System.out.println(numList.get(0));
        System.out.println(dateList.get(5));

        mav.addObject("dateList",dateList);
        mav.addObject("numList",numList);
        mav.setViewName("History");

        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/Doctor/{Did}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> LoginSuccess(@PathVariable int Did,HttpServletResponse response){
        //  int Did = doctorService.findDidByDname("Doctor1");
        System.out.println("Did= " +1);
        List<Priority> priorityList = doctorService.ReminderListOrderByPriority(Did);
        String result = JSON.toJSONString(priorityList);
        System.out.println(result);
        if (result==null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
    }

    @RequestMapping("/test")
    public ModelAndView LoginSuccess(HttpSession session){
            int Did = doctorService.findDidByDname(session.getAttribute("userName").toString());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("Doctor");
            mav.addObject("Did",Did);
            return mav;
    }


}
