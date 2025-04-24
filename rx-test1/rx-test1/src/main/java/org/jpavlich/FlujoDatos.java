package org.jpavlich;

import io.reactivex.rxjava3.core.Observable;

public class FlujoDatos {
    public static void main(String[] args) {
        Observable<Long> hw = Observable.create(
            emitter -> {
                for (long i = 0; i < 10; i++) {
                    // if (i == 5) {
                    //     throw new Exception("Ocurrió un error");
                    // }
                    emitter.onNext(i);

                }
                emitter.onComplete();
                
            }
        );

        hw.subscribe(
            dato -> System.out.println(dato),
            exception -> System.err.println("Excepción: " + exception),
            () -> System.out.println("Terminó")
        ); // Equivalente a bind
    }
}
