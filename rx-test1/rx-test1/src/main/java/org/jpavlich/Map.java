package org.jpavlich;

import io.reactivex.rxjava3.core.Observable;

public class Map {
    public static void main(String[] args) {
        // Observable.fromArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        Observable.range(0,10)
            .map(n -> {
                return n + 1;
            })
            .map(n -> n * 2)
            .subscribe(n -> System.out.println(n));
                                                                                                                  // a
                                                                                                                  // bind
    }
}
