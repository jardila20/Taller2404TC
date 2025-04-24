package org.jpavlich;

import io.reactivex.rxjava3.core.Observable;

public class HelloWorld {
    public static void main(String[] args) {
        Observable<String> hw = Observable.create(
            emitter -> {
                emitter.onNext("Hello world");  // Equivalente a notify_all
            }
        );

        hw.subscribe(dato -> System.out.println(dato)); // Equivalente a bind
    }
}
