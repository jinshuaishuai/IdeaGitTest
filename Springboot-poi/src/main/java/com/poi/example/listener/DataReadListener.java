package com.poi.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.poi.example.entity.DataModel;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DataReadListener
 * @Description TODO
 * @Date 2021/7/9 14:45
 * @Created by jinshuai
 */
public class DataReadListener extends AnalysisEventListener<DataModel> {

    private List<DataModel> list = new ArrayList<>();

    @Override
    public void invoke(DataModel dataModel, AnalysisContext analysisContext) {
        list.add(dataModel);
    }

    @SneakyThrows
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {



        File file = new File("D:\\develop\\工作文件\\强哥数据修复\\data.txt");
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(DataModel data : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("UPDATE e_purchase_lot_no_item\n" +
                    "SET price = " +
                    data.getPrice() + ",\n" +
                    "arrive_price = " + data.getPrice() +
                    "\nWHERE ln_code = '" + data.getJhdh() + "'" +
                    "\nAND seller_sku = '" + data.getMsku() + "';");
            sb.append("\n\n\n");
            sb.append("UPDATE e_storage_inbound_item\n" +
                            "SET price = " +
                    data.getPrice() +
                            "\nWHERE fid = \n(\nSELECT id FROM e_storage_inbound \nWHERE type = 'In' \nAND op_type = 'LNInbound' \nAND fcode = " +
                    "'" + data.getJhdh() + "'\n)" +
                    "\nAND seller_sku = '" + data.getMsku() + "';"
                    );
            sb.append("\n\n\n");
            sb.append("UPDATE e_storage_serial\n" +
                    "SET purchase_cost = " + data.getPrice() +
                    "\nWHERE msku = '" + data.getMsku() + "'" +
                    "\nAND purchase_po_code = '" + data.getPurOrder() + "'" +
                    "\nAND purchase_ln_code = '" + data.getJhdh() + "';"
                    );

            sb.append("\n\n");
            bufferedWriter.write(sb.toString());
        }

        bufferedWriter.close();


    }
}
