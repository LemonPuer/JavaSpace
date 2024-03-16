package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 11:29:22
 */

public class quartzTest {
    public static void main(String[] args) throws SchedulerException {
        // 创建一个HolidayCalendar对象，定义假期日期（1月1日）
        HolidayCalendar holidayCalendar = new HolidayCalendar();
        Calendar christmas = new GregorianCalendar();
        // 1月
        christmas.set(Calendar.MONTH, Calendar.JANUARY);
        // 1日
        christmas.set(Calendar.DAY_OF_MONTH, 1);
        holidayCalendar.addExcludedDate(christmas.getTime());

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                // 存储数据
                .usingJobData("job", "jobDetail")
                .usingJobData("name", "jobDetail")
                .usingJobData("count", 1)
                .build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "trigger1")
                .usingJobData("trigger", "trigger")
                .usingJobData("name", "trigger")
                .usingJobData("count", 2)
                // 设置触发器的启动时间
                .startNow()
                // 设置启动策略
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        // 设置延迟时间
                        .withIntervalInSeconds(2)
                        // 设置一直重复执行
                        .repeatForever())
                .modifiedByCalendar("holidayCalendar")
                .build();
        // StdSchedulerFactory使用配置文件创建调度器；这里使用默认的
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 注册Trigger和JobDetail到Scheduler
        scheduler.scheduleJob(jobDetail, trigger);
        // 将HolidayCalendar关联到Scheduler
        /*
        name（名称）：Calendar 对象指定的唯一标识符。
        calendar（日历）：用于定义排除特定日期和时间的规则。
        replace（替换）：设置为 true，新的 Calendar 对象将替换掉已存在的。
            为 false，如果同名的 Calendar 对象已经存在，将会抛出 ObjectAlreadyExistsException 异常。
        updateTriggers（更新触发器）：设置为 true，那么与 Calendar 相关联的所有 Trigger 对象（使用 modifiedByCalendar(name) 方法关联的 Trigger）将会被更新，以反映新的 Calendar 规则。
            如果设置为 false，只有在新建 Trigger 时才会使用新的 Calendar 规则，已存在的 Trigger 不会受到影响。
         */
        scheduler.addCalendar("holidayCalendar", holidayCalendar, false, false);
        // 启动
        scheduler.start();
    }
}
