package com.immanuelbayu.my.id.project.libraries.scheduler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class SchedulerConfiguration {

  @Bean
  public Scheduler withPoolExecutor(SchedulerProperties schedulerProperties) {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
        schedulerProperties.getCorePoolSize(),
        schedulerProperties.getMaxPoolSize(),
        schedulerProperties.getTtl(),
        TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(schedulerProperties.getMaxQueue()));

    return Schedulers.fromExecutor(executor);
  }

  @Bean
  public Scheduler withTaskPoolExecutorAndUseTimeout(SchedulerProperties schedulerProperties) {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(schedulerProperties.getCorePoolSize());
    executor.setMaxPoolSize(schedulerProperties.getMaxPoolSize());
    executor.setKeepAliveSeconds(schedulerProperties.getTtl());
    executor.setQueueCapacity(schedulerProperties.getMaxQueue());
    executor.setAllowCoreThreadTimeOut(true);
    executor.setThreadNamePrefix("with-threadPoolTask-");
    executor.initialize();

    return Schedulers.fromExecutor(executor);
  }

  @Bean
  public Scheduler withTaskPoolExecutorAndWithoutTimeout(SchedulerProperties schedulerProperties) {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(schedulerProperties.getCorePoolSize());
    executor.setMaxPoolSize(schedulerProperties.getMaxPoolSize());
    executor.setKeepAliveSeconds(schedulerProperties.getTtl());
    executor.setQueueCapacity(schedulerProperties.getMaxQueue());
    executor.setAllowCoreThreadTimeOut(false);
    executor.setThreadNamePrefix("with-threadPoolTask-");
    executor.initialize();

    return Schedulers.fromExecutor(executor);
  }
}
