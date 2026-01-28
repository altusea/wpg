package com.example.wpg.util;

import cn.idev.excel.annotation.ExcelIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.fesod.sheet.FesodSheet;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {

    @Getter
    @Setter
    // Sample data class
    public static class DemoData {
        @ExcelProperty("String Title")
        private String string;
        @ExcelProperty("Date Title")
        private Date date;
        @ExcelProperty("Number Title")
        private Double doubleData;
        @ExcelIgnore
        private String ignore;
    }

    // Prepare data to write
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("String" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    static void main(String[] args) {
        String fileName = "demo.xlsx";
        // Create a "Template" sheet and write data
        FesodSheet.write(fileName, DemoData.class).sheet("Template").doWrite(data());
    }
}
