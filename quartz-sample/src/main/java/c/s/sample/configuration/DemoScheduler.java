package c.s.sample.configuration;

import c.s.sample.modules.demo.job.DemoJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * quartz 定时任务 demo
 *
 * @author chineshine
 */
@Configuration
public class DemoScheduler {

    private @Autowired
    DemoJob demoJob;

    @Bean
    public JobDetail job() {
        JobBuilder builder = JobBuilder.newJob();
        builder.withIdentity(demoJob.getJobKey());
        builder.ofType(demoJob.getClass());
        builder.storeDurably();
        return builder.build();
    }

    @Bean
    public Trigger trigger() {
        final String expression = "/5 * * * * ? ";
        TriggerBuilder<Trigger> builder = TriggerBuilder.newTrigger();
//  --  	CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.dailyAtHourAndMinute(18, 01);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(expression);
        builder.withSchedule(cronScheduleBuilder);
        builder.forJob(this.job());
        return builder.build();
    }


}
