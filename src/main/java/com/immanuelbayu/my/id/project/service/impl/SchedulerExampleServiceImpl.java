package com.immanuelbayu.my.id.project.service.impl;

import com.immanuelbayu.my.id.project.service.api.SchedulerExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Service
public class SchedulerExampleServiceImpl implements SchedulerExampleService {

  @Autowired
  Scheduler withTaskPoolExecutorAndWithoutTimeout;

  @Autowired
  Scheduler withTaskPoolExecutorAndUseTimeout;

  @Override
  public Mono<Integer> testMonoWithoutScheduler() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10));

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerImmediate() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(Schedulers.immediate());

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerSingle() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(Schedulers.single());

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerParallel() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(Schedulers.parallel());

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerElastic() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(Schedulers.elastic());

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithoutTimeout() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(withTaskPoolExecutorAndWithoutTimeout);

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithTimeout() {
    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(withTaskPoolExecutorAndUseTimeout);

    return mono;
  }

  @Override
  public Mono<Integer> testMonoWithWrongImplementationThreadPool() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    executor.setCorePoolSize(1);
    executor.setMaxPoolSize(1);
    executor.setQueueCapacity(1);
    executor.setKeepAliveSeconds(1);
    executor.setAllowCoreThreadTimeOut(false);
    executor.setThreadNamePrefix("executor-thread-");
    executor.initialize();

    Mono<Integer> mono = Mono.just(1)
        .flatMap(i -> Mono.just(i * 10))
        .subscribeOn(Schedulers.fromExecutor(executor));

    return mono;
  }
}
