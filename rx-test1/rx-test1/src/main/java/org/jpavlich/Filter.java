package org.jpavlich;

import java.util.ArrayList;
import java.util.List;

import org.jpavlich.util.Color;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Filter {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> obs = createObservable();
        for (int i = 0; i < 20; i++) {
            final int s = i;
            obs.subscribe(n -> System.out.println(s + ": " + Thread.currentThread().getName()));
        }

        System.out.println("Haciendo otra cosa");
        Thread.sleep(2000);
    }

    private static Observable<Long> createObservable() {
        return Observable.just(7l)
            // .observeOn(Schedulers.trampoline())
            // .observeOn(Schedulers.single())
            // .observeOn(Schedulers.newThread())
            // .observeOn(Schedulers.computation())
            // .observeOn(Schedulers.io())
            .doOnNext(n -> System.err.println(Color.BLUE + Thread.currentThread().getName() + Color.RESET))
            .map(n -> n * 2)
            .subscribeOn(Schedulers.computation());
    }

}
