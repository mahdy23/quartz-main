package com.example.quartz.jobs;

import com.example.quartz.config.TimerInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor

public class HelloWorldJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        LOG.info("Remaining fire count is '{}'", info.getRemainingFireCount());
    }
}
