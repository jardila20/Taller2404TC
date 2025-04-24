package org.jpavlich;

import org.jpavlich.util.HttpClientFake;

public class HttpSimulation_FlatMap {

    public static void main(String[] args) throws InterruptedException {

        HttpClientFake http = new HttpClientFake();

        http.get("http://example.com/procesar", 5l)
            .flatMap(n -> http.get("http://example2.com/procesar", n))
            .flatMap(n -> http.get("http://example2.com/procesar", n))
            .flatMap(n -> http.get("http://example2.com/procesar", n))
            .flatMap(n -> http.get("http://example2.com/procesar", n))
            .subscribe(n -> System.out.println(n));
        

        System.out.println("Haciendo otra cosa");
        Thread.sleep(2000);
    }

}
