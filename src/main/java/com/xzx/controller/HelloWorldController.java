package com.xzx.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    //这里的/hello相当于struts2里的一个action
    //返回一个字符串给视图
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ModelAndView  sayHello()
    {
        ModelAndView mav = new ModelAndView();
        System.out.println("123123213213");
        mav.setViewName("HelloWorld");
        mav.addObject("message","hhhhhh");

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("oracle");
        mav.addObject("bookList", list);

        //Map
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhangsan", "北京");
        map.put("lisi", "上海");
        map.put("wangwu", "深圳");
        mav.addObject("map",map);

        return mav;
    }

}
