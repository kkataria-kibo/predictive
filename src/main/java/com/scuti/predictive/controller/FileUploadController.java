package com.scuti.predictive.controller;

import com.scuti.predictive.util.ImportUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * Created by kkataria on 9/4/2016.
 */
@Slf4j
@Controller
public class FileUploadController {

    @Autowired
    ImportUtil importUtil;

    @RequestMapping(value = "/file/uploadProducts", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AjaxResponse productUpload(@RequestParam("file") MultipartFile file)
            throws Exception {

        AjaxResponse resp = new AjaxResponse();
        CSVParser parser = null;
        String fileName = file.getOriginalFilename();
        try {
            File realFile = File.createTempFile("fileUpload", "csv");
            realFile.deleteOnExit();

            file.transferTo(realFile);
            if (fileName.contains("tsv")) {

                parser = CSVParser.parse(realFile, Charset.forName(StandardCharsets.UTF_8.name()), CSVFormat.newFormat('\t').withHeader());
            }else {
                parser = CSVParser.parse(realFile, Charset.forName(StandardCharsets.UTF_8.name()), CSVFormat.DEFAULT.withHeader());
            }

        }
        catch(IOException e) {
            log.error(e.getMessage(), e);
            resp.setSuccess(false);
            resp.addProperty("banner", "Failure parsing file. No records saved." + e.getMessage());
            return resp;
        }
        boolean result = importUtil.parseCSV(parser);
        if(result) {
            resp.addProperty("success", "success");
            resp.setSuccess(true);
        } else {
            resp.addProperty("failure", "failure");
            resp.setSuccess(false);
        }
        return resp;
    }
    @RequestMapping(value = "/file/uploadOrders", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AjaxResponse orderUpload(@RequestParam("file") MultipartFile file)
            throws Exception {

        AjaxResponse resp = new AjaxResponse();
        CSVParser parser = null;
        String fileName = file.getOriginalFilename();
        try {
            File realFile = File.createTempFile("fileUpload", "csv");
            realFile.deleteOnExit();
            file.transferTo(realFile);
            parser = CSVParser.parse(realFile, Charset.forName(StandardCharsets.UTF_8.name()), CSVFormat.DEFAULT.withHeader());
        }
        catch(IOException e) {
            log.error(e.getMessage(), e);
            resp.setSuccess(false);
            resp.addProperty("banner", "Failure parsing file. No records saved." + e.getMessage());
            return resp;
        }
        boolean result = importUtil.parseOrderCSV(parser);
        if(result) {
            resp.addProperty("success", "success");
            resp.setSuccess(true);
        } else {
            resp.addProperty("failure", "failure");
            resp.setSuccess(false);
        }
        return resp;
    }

}
