package com.example.quartz;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;


@SpringBootApplication
@EnableScheduling
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }
    @Bean("customSchedulerFactoryBean1")
    public SchedulerFactoryBean customSchedulerFactoryBean1(DataSource dataSource) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("org.quartz.threadPool.threadNamePrefix", "my-custom-scheduler1_Worker");
        factory.setQuartzProperties(properties);
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean("customSchedulerFactoryBean2")
    public SchedulerFactoryBean customSchedulerFactoryBean2(DataSource dataSource) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("org.quartz.threadPool.threadNamePrefix", "my-custom-scheduler2_Worker");
        factory.setQuartzProperties(properties);
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean("customScheduler1")
    public Scheduler customScheduler1(@Qualifier("customSchedulerFactoryBean1") SchedulerFactoryBean factory) throws SchedulerException {
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        return scheduler;
    }

    @Bean("customScheduler2")
    public Scheduler customScheduler2(@Qualifier("customSchedulerFactoryBean2") SchedulerFactoryBean factory) throws SchedulerException {
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        return scheduler;
    }


}
