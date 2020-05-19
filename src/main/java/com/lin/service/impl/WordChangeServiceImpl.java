package com.lin.service.impl;

import com.lin.service.WordChangeService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
@Service
public class WordChangeServiceImpl implements WordChangeService {
    @Override
    public boolean changeHtmlToPdf(String inputFilePath, String outFilePath) {
        File downloadFile = new File(inputFilePath);
        if (!downloadFile.exists()) {
            return false;
        }
        String inputFileName = downloadFile.getName();
        PD4ML pd4ml = new PD4ML();
        pd4ml.enableDebugInfo();
        PD4PageMark footer = new PD4PageMark();
        footer.setHtmlTemplate("<p style='font-size:16px;float:right;'><span>page $[page] of $[total]</span><p>");
        footer.setAreaHeight(-1);
        pd4ml.setPageFooter(footer);
        pd4ml.setPageInsets(new Insets(20, 10, 10, 10));
        pd4ml.setHtmlWidth(980);
        pd4ml.setPageSize(PD4Constants.A4);
        File destFile = null;
        FileOutputStream fos = null;
        String showType = "";
        try {
            pd4ml.useTTF("java:fonts", true);
            destFile = new File(outFilePath);
            if(!destFile.exists()){
                destFile.createNewFile();
            }
            fos = FileUtils.openOutputStream(destFile);
            pd4ml.render("file:" + inputFilePath, fos);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
