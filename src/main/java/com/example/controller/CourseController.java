package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CourseService;

/**
 * @author xzy
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;


    @RequestMapping(value = {"/", "/view"})
    public String test() {
        System.out.println("123hello....");
        return "index";
    }




    @RequestMapping("/selectByCourseName")
    public List<Map<String, Object>> selectByCourseName(String courseName) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", courseName);
        List<Map<String, Object>> resultList = courseService.selectByCourseName(map);
        return resultList;
    }


    @RequestMapping("/transaction")
    @Transactional
    // 需要事务的时候加上
    public Boolean transaction() {
        return true;
    }

}
