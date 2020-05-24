package com.immanuelbayu.my.id.project.libraries.scheduler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("scheduler")
public class SchedulerProperties {

  private Integer maxPoolSize;
  private Integer corePoolSize;
  private Integer ttl;
  private Integer maxQueue;

  public Integer getMaxPoolSize() {
    return maxPoolSize;
  }

  public void setMaxPoolSize(Integer maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public Integer getCorePoolSize() {
    return corePoolSize;
  }

  public void setCorePoolSize(Integer corePoolSize) {
    this.corePoolSize = corePoolSize;
  }

  public Integer getTtl() {
    return ttl;
  }

  public void setTtl(Integer ttl) {
    this.ttl = ttl;
  }

  public Integer getMaxQueue() {
    return maxQueue;
  }

  public void setMaxQueue(Integer maxQueue) {
    this.maxQueue = maxQueue;
  }
}
