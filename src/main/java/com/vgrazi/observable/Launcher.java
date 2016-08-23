package com.vgrazi.observable;

import rx.Observable;

import java.io.IOException;

/**
 * Created by vgrazi on 8/23/16.
 */
public class Launcher {

  public static void main(String[] args) {
    new Launcher().launch();
  }

  private void launch() {
    Observable<Object> observable = Observable.create(
      subscriber -> {
        subscriber.onNext("Hello,");
        subscriber.onNext("World");
        subscriber.onError(new IOException("test exception"));
        subscriber.onNext("Ignored after error");
        subscriber.onCompleted();
      }
    );

    observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Complete"));
  }
}

// 02_attachfeed