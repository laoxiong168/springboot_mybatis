package com.example.controller;

import com.example.service.CourseService;
import com.example.service.NoteService;
import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.apache.ibatis.javassist.tools.reflect.ClassMetaobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author xzy
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private NoteService noteService;


    @RequestMapping("/deleteModule")
    @ResponseBody
    public Map<String,Object> deleteModule(String data){
        Map resultMap=new HashMap();
        if (!"21500".equals(data)){
            resultMap.put("result","error");
            return resultMap;
        }
        resultMap.put("result","success");
        return resultMap;
    }



    /**
     * 读取记录列表
     * @param
     * @return
     */
    @RequestMapping("/getAllContents")
    @ResponseBody
    public List<Map<String,Object>>  getAllContents(){
        List<Map<String,Object>> contentResultList=noteService.queryContents();
        return contentResultList;

    }

    @RequestMapping("/ajaxTest")
    @ResponseBody
    public Map ajaxTest(String data){
        Map<String,Object> insertMap=new HashMap();
        String id= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        insertMap.put("id",id);
        insertMap.put("content",data);
        Integer insertCount=noteService.insertNote(insertMap);
        Map tempMap=new HashMap();
        tempMap.put("success","success");
        return tempMap;
    }

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
