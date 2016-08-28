package com.scuti.predictive.beacon;

import com.scuti.predictive.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by kkataria on 8/27/2016.
 */
@Slf4j
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ProductImportBeacon extends QuartzJobBean {

    @Autowired
    private ProductService service;

    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {

        JobKey jobKey = ctx.getJobDetail().getKey();
        log.info("START GETTING PRODUCT DATA FROM SFTP.....", jobKey);


    }

}
