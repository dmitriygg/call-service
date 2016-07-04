package com.grigoryevdev.testprojects.callsservice.service;

public interface ValidationService {

    boolean validatePhoneNumber(String phoneNumber) throws Exception;

    boolean validateName(String name, boolean isMandatory, String fieldLabel) throws Exception;

}
