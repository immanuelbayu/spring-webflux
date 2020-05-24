package com.immanuelbayu.my.id.project.service.impl;

import com.immanuelbayu.my.id.project.service.api.SchedulerExampleService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SchedulerExampleServiceImpl implements SchedulerExampleService {

  @Override
  public Mono<Integer> testMonoWithoutScheduler() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerImmediate() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerSingle() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerParallel() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerElastic() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolExecutor() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithoutTimeout() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithTimeout() {
    return null;
  }

  @Override
  public Mono<Integer> testMonoWithWrongImplementationThreadPool() {
    return null;
  }
}
