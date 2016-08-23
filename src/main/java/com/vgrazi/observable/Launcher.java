package com.vgrazi.observable;

import rx.Observable;

/**
 * Created by vgrazi on 8/23/16.
 */
public class Launcher {

  public static void main(String[] args) {
    new Launcher().launch();
  }

  private void launch() {
    Observable.create(
      subscriber -> {
        subscriber.onNext("Hello,");
        subscriber.onNext("World");
        subscriber.onCompleted();
      }
    )
      .subscribe(System.out::println, System.out::println, () -> System.out.println("Complete"));
  }
}

// createwerror