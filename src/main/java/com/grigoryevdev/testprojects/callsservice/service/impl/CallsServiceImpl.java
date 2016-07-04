package com.grigoryevdev.testprojects.callsservice.service.impl;

import com.grigoryevdev.testprojects.callsservice.model.Call;
import com.grigoryevdev.testprojects.callsservice.service.CallsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class CallsServiceImpl implements CallsService {

    @Override
    public boolean saveCallInfo(Call call) throws IOException {
        writeData(call);
        return true;
    }

    private void writeData(Call call) throws IOException {
        List<String> lines = Arrays.asList(normalizePhoneNumber(call.getPhoneNumber()), getCurentTime());
        Path file = Paths.get(getFileName(call));
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    private String getFileName(Call call) {
        StringBuilder sb = new StringBuilder();
        sb.append(call.getLastName().toUpperCase()).append("_");

        if (!StringUtils.isEmpty(call.getFirstName())) {
            sb.append(call.getFirstName().toUpperCase());
        }
        sb.append(".txt");

        return sb.toString();
    }

    private String getCurentTime() {
        SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return ft.format(date);
    }

    private String normalizePhoneNumber(String phoneNumber) {
        StringBuilder resultNumber = new StringBuilder(phoneNumber.replaceAll("\\(", "").replaceAll("\\)", "").
                replaceAll("\\-", "").replaceAll(" ", "").replaceAll("\\+", "00"));

        if (resultNumber.length() == 9) {
            resultNumber.insert(0, "00420");
        } else if (resultNumber.length() == 12) {
            resultNumber.insert(0, "00");
        }

        return resultNumber.insert(5, " ").insert(9, " ").insert(13, " ").toString();
    }

}
