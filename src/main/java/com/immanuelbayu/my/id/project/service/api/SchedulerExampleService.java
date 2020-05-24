package com.immanuelbayu.my.id.project.service.api;

import reactor.core.publisher.Mono;

public interface SchedulerExampleService {

  Mono<Integer> testMonoWithoutScheduler();

  Mono<Integer> testMonoWithSchedulerImmediate();

  Mono<Integer> testMonoWithSchedulerSingle();

  Mono<Integer> testMonoWithSchedulerParallel();

  Mono<Integer> testMonoWithSchedulerElastic();

  Mono<Integer> testMonoWithSchedulerFromThreadPoolExecutor();

  Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithoutTimeout();

  Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithTimeout();

  Mono<Integer> testMonoWithWrongImplementationThreadPool();
}
