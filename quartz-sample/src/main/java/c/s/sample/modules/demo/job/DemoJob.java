package c.s.sample.modules.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoJob implements Job {

    private final String JOB_KEY_NAME = "job1";
    private final String JOB_KEY_GROUP = "demo";

    /**
     *  定义job key 相当于给 job 命名
     * @return
     */
    public JobKey getJobKey(){
        return new JobKey(JOB_KEY_NAME,JOB_KEY_GROUP);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("this job is being executed");
    }
}
