package com.grigoryevdev.testprojects.callsservice.controller;

import com.grigoryevdev.testprojects.callsservice.model.Call;
import com.grigoryevdev.testprojects.callsservice.service.CallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/calls")
public class CallsController {

    @Autowired
    CallsService callsService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addCall(@RequestBody Call call, BindingResult result) {

        callsService.saveCallInfo(call);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
