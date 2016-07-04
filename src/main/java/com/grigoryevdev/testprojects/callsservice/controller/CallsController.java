package com.grigoryevdev.testprojects.callsservice.controller;

import com.grigoryevdev.testprojects.callsservice.exception.CallsServiceValidationException;
import com.grigoryevdev.testprojects.callsservice.model.Call;
import com.grigoryevdev.testprojects.callsservice.service.CallsService;
import com.grigoryevdev.testprojects.callsservice.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/calls")
public class CallsController {

    @Autowired
    CallsService callsService;
    @Autowired
    ValidationService validationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addCall(@RequestBody Call call, BindingResult result) throws Exception {
        validateInput(call);
        callsService.saveCallInfo(call);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(CallsServiceValidationException.class)
    @ResponseBody
    public String handleException(CallsServiceValidationException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Writing error!")
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public String handleException(IOException ex) {
        return ex.getMessage();
    }


    private void validateInput(Call call) throws Exception {
        validationService.validatePhoneNumber(call.getPhoneNumber());
        validationService.validateName(call.getLastName(), true, "Last name");
        validationService.validateName(call.getFirstName(), false, "First name");
    }

}
