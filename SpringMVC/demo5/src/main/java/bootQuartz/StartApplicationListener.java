package bootQuartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.TimerTask;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 17:57:56
 */
// @Component
// public class StartApplicationListener implements ApplicationListener<ContextClosedEvent> {
//     @Autowired
//     private Scheduler scheduler;
//
//     @Override
//     public void onApplicationEvent(ContextClosedEvent event) {
//         TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "trigger1");
//         try {
//             Trigger trigger = scheduler.getTrigger(triggerKey);
//             if (Objects.isNull(trigger)) {
//                 trigger = TriggerBuilder.newTrigger()
//                         .withIdentity(triggerKey)
//                         .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ? "))
//                         .build();
//                 JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class)
//                         .withIdentity("job1", "group1")
//                         .build();
//                 scheduler.scheduleJob(jobDetail, trigger);
//                 scheduler.start();
//             }
//         } catch (SchedulerException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
