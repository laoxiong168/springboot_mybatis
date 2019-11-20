package com.controller;

import com.service.MyProService;
import com.system.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("business")
@Slf4j
public class MyHandleController {
    @Autowired
    private MyProService myProService;
    @PostMapping("/handle")
    public RespData handle(){
        myProService.handle();
        return RespData.getSuccessResp();
    }

}
