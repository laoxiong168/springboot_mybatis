package com.service.impl;

import com.service.MyProService;
import com.system.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyProserviceImpl implements MyProService {
    private int i=0;
    @Override
    @Async("asyncServiceExecutor")
    public RespData handle() {
        return RespData.getSuccessResp();
    }



}
