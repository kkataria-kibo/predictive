package com.scuti.predictive.job;

import com.scuti.predictive.beacon.ProductImportBeacon;
import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.PostConstruct;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class JobConfiguration {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    private void initialize() throws Exception {


        schedulerFactoryBean.getScheduler().addJob(jobDetailProductImport(), true, true);

        if (!schedulerFactoryBean.getScheduler().checkExists(new TriggerKey("productImport", "IMPORT_PRODUCT"))) {
            schedulerFactoryBean.getScheduler().scheduleJob(cronTriggerProductImport());
        }
    }

    private static JobDetail jobDetailProductImport() {

        JobDetailImpl jobDetail = new JobDetailImpl();
        jobDetail.setKey(new JobKey("productImport", "IMPORT_PRODUCT"));
        jobDetail.setJobClass(ProductImportBeacon.class);
        jobDetail.setDurability(true);
        JobDataMap map = new JobDataMap();
        map.put("org", "bobeau");

        jobDetail.setJobDataMap(map);

        return jobDetail;
    }

    private static Trigger cronTriggerProductImport() {
        return newTrigger()
                .forJob(jobDetailProductImport())
                .withIdentity("productImport", "IMPORT_PRODUCT")
                .withPriority(100)
                // Job is scheduled for every 1 minute
                .withSchedule(cronSchedule("0 10 * 1/1 * ? *"))
                .startAt(DateTime.now().plusSeconds(3).toDate())
                .build();
    }

}