package com.controller;

import com.service.MyProService;
import com.system.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("business")
@Slf4j
public class MyHandleController {
    @Autowired
    private MyProService myProService;
    public static  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
    @PostMapping("/handle")
    public RespData handle(){
        myProService.handle();
        return RespData.getSuccessResp();
    }

    /**
     * 线程池
     * @return
     */
    @PostMapping("/thread")
    public RespData threadHandle(){
            for(int i=0;i<50;i++){
                fixedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        String name=Thread.currentThread().getName();
                        log.info("当前线程:{}",name);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        log.info("api调用结束!");
        return RespData.getSuccessResp();
    }



}
