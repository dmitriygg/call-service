package com.grigoryevdev.testprojects.callsservice.service.impl;


import com.grigoryevdev.testprojects.callsservice.exception.CallsServiceValidationException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationServiceImplTest {
    ValidationServiceImpl validationService;


    @Before
    public void setUp() throws Exception {
        validationService = new ValidationServiceImpl();

    }

    @Test
    public void testIsBracketsBalanced() throws Exception {
        assertTrue (validationService.isBracketsBalanced("(()())"));
        assertTrue (validationService.isBracketsBalanced("()()"));
        assertFalse (validationService.isBracketsBalanced(")("));
        assertFalse (validationService.isBracketsBalanced(")"));
        assertFalse (validationService.isBracketsBalanced("())"));
    }

    @Test
    public void testValidatePhoneNumberIsValid() throws Exception {

        assertTrue (validationService.validatePhoneNumber("+(420) 111 222 333"));
        assertTrue (validationService.validatePhoneNumber("+(420)-111222333"));
        assertTrue (validationService.validatePhoneNumber("+420111222333"));
        assertTrue (validationService.validatePhoneNumber("00420111222333"));
        assertTrue (validationService.validatePhoneNumber("123456789"));
    }

    @Test(expected = CallsServiceValidationException.class)
    public void testValidatePhoneNumberNotValid() throws Exception {
        validationService.validatePhoneNumber("1111 222 333");
        validationService.validatePhoneNumber("++(420) 111 222 333");
        validationService.validatePhoneNumber("(420+) 111 222 333");
        validationService.validatePhoneNumber("(420)а !111 222 333");
    }

}