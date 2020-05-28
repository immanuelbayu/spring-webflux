package com.immanuelbayu.my.id.project.libraries.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class SchedulerConfiguration {

  @Bean
  public Scheduler withTaskPoolExecutorAndUseTimeout(SchedulerProperties schedulerProperties) {
    return get(schedulerProperties, "with-threadPoolTask-useTimeOut-", true);
  }

  @Bean
  public Scheduler withTaskPoolExecutorAndWithoutTimeout(SchedulerProperties schedulerProperties) {
    return get(schedulerProperties, "with-threadPoolTask-withoutTimeOut-", false);
  }

  private Scheduler get(SchedulerProperties schedulerProperties, String prefix, Boolean allowTimeout) {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(schedulerProperties.getCorePoolSize());
      executor.setMaxPoolSize(schedulerProperties.getMaxPoolSize());
      executor.setKeepAliveSeconds(schedulerProperties.getTtl());
      executor.setQueueCapacity(schedulerProperties.getMaxQueue());
      executor.setAllowCoreThreadTimeOut(allowTimeout);
      executor.setThreadNamePrefix(prefix);
      executor.initialize();

      return Schedulers.fromExecutor(executor);
  }
}
