package org.jpavlich;

import org.jpavlich.util.HttpClientFake;

public class HttpSimulation {

    public static void main(String[] args) throws InterruptedException {

        HttpClientFake http = new HttpClientFake();

        http.get("http://example.com/procesar", 5l)
            .subscribe(n -> {
                http.get("http://example2.com/procesar", n)
                    .subscribe(n2 -> System.out.println(n2));
        });

        System.out.println("Haciendo otra cosa");
        Thread.sleep(10000);
    }

}
