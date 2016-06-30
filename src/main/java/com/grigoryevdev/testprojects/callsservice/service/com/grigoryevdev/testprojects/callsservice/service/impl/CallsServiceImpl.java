package com.grigoryevdev.testprojects.callsservice.service.com.grigoryevdev.testprojects.callsservice.service.impl;

import com.grigoryevdev.testprojects.callsservice.model.Call;
import com.grigoryevdev.testprojects.callsservice.service.CallsService;
import org.springframework.stereotype.Component;

@Component
public class CallsServiceImpl implements CallsService {

    @Override
    public boolean saveCallInfo(Call call) {
        System.out.println("Saved to disk");
        return false;
    }

}
