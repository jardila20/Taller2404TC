package org.jpavlich;

import java.util.concurrent.TimeUnit;

import org.jpavlich.util.DataProcessingService;
import org.jpavlich.util.HttpClientFake;
import org.jpavlich.util.TimeSeriesService;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.TestScheduler;

public class Zip {

    public static void main(String[] args) throws InterruptedException {
        TestScheduler scheduler = new TestScheduler();
        TimeSeriesService tss = new TimeSeriesService(scheduler);


        Observable<Long> obs1 = tss.getTimeSeries1AtRandomIntervals();
        Observable<Long> obs2 = tss.getTimeSeries2AtRandomIntervals();

        Observable.zip(obs1, obs2, (n1, n2) -> n1 + n2)
            .subscribe(n -> System.out.println(n));
        

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }

}
