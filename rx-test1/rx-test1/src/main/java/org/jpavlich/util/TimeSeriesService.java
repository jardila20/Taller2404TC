package org.jpavlich.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TimeSeriesService {
    private Random random = new Random(1);
    private Scheduler scheduler;

    public TimeSeriesService() {
        scheduler = Schedulers.single();
    }

    public TimeSeriesService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * Emits numbers at regular intervals
     * 
     * @return
     */
    public Observable<Long> getTimeSeries1() {
        return Observable.rangeLong(0, 10)
                .concatMap(n -> Observable.just(n).delay(100, TimeUnit.MILLISECONDS, scheduler))
                .doOnNext(n -> System.out.println(Color.BLUE + "Emitted: " + n + Color.RESET + " "));
    }

    /**
     * Emits numbers at regular intervals
     * 
     * @return
     */
    public Observable<Long> getTimeSeries2() {
        return Observable.rangeLong(0, 15)
                .concatMap(n -> Observable.just(n * 5).delay(100, TimeUnit.MILLISECONDS, scheduler))
                .doOnNext(n -> System.out.println(Color.RED + "Emitted: " + n + Color.RESET + " "));
    }

    /**
     * Emits numbers at random intervals
     * 
     * @return
     */
    public Observable<Long> getTimeSeries1AtRandomIntervals() {
        return Observable.rangeLong(0, 10)
                .concatMap(n -> Observable.just(n).delay(random.nextInt(100), TimeUnit.MILLISECONDS, scheduler))
                .doOnNext(n -> System.out.println(Color.BLUE + "Emitted: " + n + Color.RESET + " "));
    }

    /**
     * Emits numbers at random intervals
     * 
     * @return
     */
    public Observable<Long> getTimeSeries2AtRandomIntervals() {
        return Observable.rangeLong(0, 15)
                .flatMap(n -> Observable.just(n * 5).delay(random.nextInt(100), TimeUnit.MILLISECONDS, scheduler))
                .doOnNext(n -> System.out.println(Color.RED + "Emitted: " + n + Color.RESET + " "));
    }

}
