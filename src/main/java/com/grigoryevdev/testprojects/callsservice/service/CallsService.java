package com.grigoryevdev.testprojects.callsservice.service;

import com.grigoryevdev.testprojects.callsservice.model.Call;

import java.io.IOException;

public interface CallsService {

    boolean saveCallInfo(Call call) throws IOException;


}
