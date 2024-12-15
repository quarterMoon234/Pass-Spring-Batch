package com.example.passbatch.util;

import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class CustomCSVWriter {

    public static int write(String fileName, List<String[]> data) {
        int row = 0;
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeAll(data);
            row = data.size();
        } catch (Exception e) {
            log.error("CustomCSVWriter - write: CSV 파일 생성 실패, fileName: {}", fileName);
        }

        return row;
    }
}
