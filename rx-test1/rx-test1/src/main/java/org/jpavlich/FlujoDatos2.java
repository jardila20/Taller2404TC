package org.jpavlich;

import io.reactivex.rxjava3.core.Observable;

public class FlujoDatos2 {
    public static void main(String[] args) {
        // Observable.fromArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        Observable.range(0,10)
            .subscribe(
                dato -> System.out.println(dato),
                exception -> System.err.println("Excepción: " + exception), 
                () -> System.out.println("Terminó")); // Equivalente
                                                                                                                  // a
                                                                                                                  // bind
    }
}
