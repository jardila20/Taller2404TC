package org.jpavlich;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jpavlich.util.Stopwatch;

import io.reactivex.rxjava3.core.Observable;

public class Concat {
    
    public static void main(String[] args) throws InterruptedException {
        Stopwatch s = new Stopwatch();

        List<Observable<Long>> observables = new ArrayList<>();

        observables.add(Observable.interval(0, 100, TimeUnit.MILLISECONDS).take(10));
        observables.add(Observable.interval(0, 200, TimeUnit.MILLISECONDS).take(10).map(n -> n * 10));
        Observable.concat(observables)
            .subscribe(n -> System.out.println(n + "  " + s.elapsed()));

        Thread.sleep(10000);
    }

}
