package com.xzx.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import com.xzx.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SqliteController {
    protected HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private DoctorServiceImpl doctorService;




    public String path(@PathVariable int Did,@PathVariable String Dpwd){
        if (doctorService.Match(Did,Dpwd))
            return "redirect:/doctor";

        return "redirect:/index";
    }





    @RequestMapping("/ss")
    public String h(){
        System.out.println("-------");
      //  doctorService.AddDoctor(new Doctor());
        return "Doctor";
    }

    @ResponseBody
    @RequestMapping("/testAjax")
    public ResponseEntity<String> testAjax(){
        JSONObject result = new JSONObject();

        result.put("test","test");
      //  ResponseEntity<Doctor> rs = new ResponseEntity<Doctor>();


        return new ResponseEntity<String>(result.toJSONString(), httpHeaders, HttpStatus.OK);
    }

}
