package org.jpavlich.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DataProcessingService {
    private Random random = new Random(1);
    private Scheduler scheduler;

    public DataProcessingService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public DataProcessingService() {
        this.scheduler = Schedulers.single();
    }

    public Observable<Long> processData(Long dato) {
        return Observable.just(dato * 100).delay(random.nextInt(100), TimeUnit.MILLISECONDS, scheduler);
    }

}
