package com.github.andromed.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by devme on 2/10/2018.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
