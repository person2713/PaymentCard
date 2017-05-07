package com.team.mvc.job.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;




@Configuration
@ComponentScan("com.team.mvc")
public class QuartzConfiguration {
   /* @Bean
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
        obj.setTargetBeanName("PaymentJob");
        obj.setTargetMethod("update");
        return obj;
    }
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        stFactory.setStartDelay(300);
        stFactory.setName("mytrigger");
        stFactory.setGroup("mygroup");
        stFactory.setCronExpression("0 0/1 * 1/1 * ? *");
        return stFactory;
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(cronTriggerFactoryBean().getObject(),cronTriggerFactoryBean().getObject());
        return scheduler;
    }*/
   /* @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
        stFactory.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        stFactory.setStartDelay(3000);
        stFactory.setRepeatInterval(3000);
        stFactory.setRepeatCount(3);
        return stFactory;
    }*/
   /* @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(MyJobTwo.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "RAM");
        map.put(MyJobTwo.COUNT, 1);
        factory.setJobDataAsMap(map);
        factory.setGroup("mygroup");
        factory.setName("myjob");
        return factory;
    }*/
   /* @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
        stFactory.setJobDetail(jobDetailFactoryBean().getObject());
        stFactory.setStartDelay(3000);
        stFactory.setName("mytrigger");
        stFactory.setGroup("mygroup");
        stFactory.setCronExpression("0 0/1 * 1/1 * ? *");
        return stFactory;
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(simpleTriggerFactoryBean().getObject(),cronTriggerFactoryBean().getObject());
        return scheduler;
    }*/
}