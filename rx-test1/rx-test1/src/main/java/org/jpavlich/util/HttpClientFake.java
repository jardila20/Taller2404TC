package org.jpavlich.util;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class HttpClientFake {
    private Random random = new Random(1);

    public Observable<Long> get(String url, Long dato) {
        return Observable.just(dato * 2).delay(random.nextInt(100), TimeUnit.MILLISECONDS);
    }

}
