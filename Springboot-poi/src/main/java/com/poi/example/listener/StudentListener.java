package com.poi.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.poi.example.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname StudentListener
 * @Description TODO
 * @Date 2021/7/9 15:15
 * @Created by jinshuai
 */
public class StudentListener extends AnalysisEventListener<Student> {


    //用于承载从Excel解读出的数据
    private List<Student> list = new ArrayList<>();

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        list.add(student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //解析完所有的数据后，最终要执行的方法。
        System.out.println(list);
    }
}
