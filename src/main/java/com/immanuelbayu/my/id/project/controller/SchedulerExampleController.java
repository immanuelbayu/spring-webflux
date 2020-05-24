package com.immanuelbayu.my.id.project.controller;

import com.immanuelbayu.my.id.project.service.api.SchedulerExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("scheduler-example")
public class SchedulerExampleController {

  @Autowired
  SchedulerExampleService schedulerExampleService;

  @GetMapping("test-mono-without-scheduler")
  public Mono<Integer> testMonoWithoutScheduler() {
    return this.schedulerExampleService.testMonoWithoutScheduler();
  }

  @GetMapping("test-mono-with-scheduler-immediate")
  public Mono<Integer> testMonoWithSchedulerImmediate() {
    return this.schedulerExampleService.testMonoWithSchedulerImmediate();
  }

  @GetMapping("test-mono-with-scheduler-single")
  public Mono<Integer> testMonoWithSchedulerSingle() {
    return this.schedulerExampleService.testMonoWithSchedulerSingle();
  }

  @GetMapping("test-mono-with-scheduler-parallel")
  public Mono<Integer> testMonoWithSchedulerParallel() {
    return this.schedulerExampleService.testMonoWithSchedulerParallel();
  }

  @GetMapping("test-mono-with-scheduler-elastic")
  public Mono<Integer> testMonoWithSchedulerElastic() {
    return this.schedulerExampleService.testMonoWithSchedulerElastic();
  }

  @GetMapping("test-mono-with-thread-pool-executor")
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolExecutor() {
    return this.schedulerExampleService.testMonoWithSchedulerFromThreadPoolExecutor();
  }

  @GetMapping("test-mono-with-task-pool-executor-without-timeout")
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithoutTimeout() {
    return this.schedulerExampleService.testMonoWithSchedulerFromThreadPoolTaskExecutorWithoutTimeout();
  }

  @GetMapping("test-mono-with-task-pool-executor-with-timeout")
  public Mono<Integer> testMonoWithSchedulerFromThreadPoolTaskExecutorWithTimeout() {
    return this.schedulerExampleService.testMonoWithSchedulerFromThreadPoolTaskExecutorWithTimeout();
  }

  @GetMapping("test-mono-with-wrong-implementation-task-pool")
  public Mono<Integer> testMonoWithWrongImplementationThreadPool() {
    return this.schedulerExampleService.testMonoWithWrongImplementationThreadPool();
  }

}
