package quartz;

import org.quartz.*;


/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 11:25:39
 */
@PersistJobDataAfterExecution
public class MyJob implements Job {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 判断是否是恢复执行的任务
        boolean recovering = context.isRecovering();
        // 获取各自存储的数据
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        JobDataMap mergedMap = context.getMergedJobDataMap();
        // 框架自动调用set方法，结果为 trigger
        System.out.println("name:" + name);
        // 1
        System.out.println("jobDataMap:" + jobDataMap.get("count"));
        jobDataMap.put("count", jobDataMap.getIntValue("count") + 1);
        // 2
        System.out.println("mergedMap:" + mergedMap.get("count"));
    }
}
