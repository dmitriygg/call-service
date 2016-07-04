package com.grigoryevdev.testprojects.callsservice.service.impl;

import com.grigoryevdev.testprojects.callsservice.exception.CallsServiceValidationException;
import com.grigoryevdev.testprojects.callsservice.service.ValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validatePhoneNumber(String phoneNumber) throws CallsServiceValidationException {

        if (phoneNumber.length() == 0) {
            throw new CallsServiceValidationException("Phone number length should be greater than 0!");
        }

        Pattern pattern = Pattern.compile("^(\\+)?[0-9-() ]+");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.matches()) {
            throw new CallsServiceValidationException("Phone number has incorrect format!");
        }

        if (!isBracketsBalanced(phoneNumber)) {
            throw new CallsServiceValidationException("The number of start and end brackets must be the same!");
        }

        int phoneNumberLengh = phoneNumber.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "").
                replaceAll("\\-", "").replaceAll("\\+", "00").length();

        if (!Arrays.asList(9, 12, 14).contains(phoneNumberLengh)) {
            throw new CallsServiceValidationException("Phone number has incorrect format!");
        }

        return true;
    }

    @Override
    public boolean validateName(String name, boolean isMandatory, String fieldLabel) throws Exception {
        if (StringUtils.isEmpty(name) && isMandatory || name.length() > 30) {
            throw new CallsServiceValidationException(fieldLabel + " length should be greater 0 and less 30 characters");
        }

        return true;
    }

    public boolean isBracketsBalanced(String phoneNumber) {

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) == '(') {
                stack.push(phoneNumber.charAt(i));
            } else if (phoneNumber.charAt(i) == ')') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '(') return false;
            }
        }
        return stack.isEmpty();
    }

}
