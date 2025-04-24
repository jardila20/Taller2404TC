package org.jpavlich;

import java.util.concurrent.TimeUnit;

import org.jpavlich.util.DataProcessingService;
import org.jpavlich.util.HttpClientFake;
import org.jpavlich.util.TimeSeriesService;

import io.reactivex.rxjava3.schedulers.TestScheduler;

public class FlatMap {

    public static void main(String[] args) throws InterruptedException {
        TestScheduler scheduler = new TestScheduler();
        TimeSeriesService tss = new TimeSeriesService(scheduler);
        DataProcessingService dps = new DataProcessingService(scheduler);

        tss.getTimeSeries1AtRandomIntervals()
            .flatMap(n -> dps.processData(n))
            .subscribe(n -> System.out.println(n));
        

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }

}
