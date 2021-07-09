package com.poi.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.poi.example.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname StudentListener
 * @Description TODO
 * @Date 2021/7/9 15:15
 * @Created by jinshuai
 */
public class StudentListener extends AnalysisEventListener<Student> {

    private List<Student> list = new ArrayList<>();

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        list.add(student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        System.out.println(list);
    }
}
