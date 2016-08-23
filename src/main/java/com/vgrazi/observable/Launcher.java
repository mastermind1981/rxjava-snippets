package com.vgrazi.observable;

import rx.Observable;

/**
 * Created by vgrazi on 8/23/16.
 */
public class Launcher {

  public static void main(String[] args) throws InterruptedException {
    new Launcher().launch();
  }

  private void launch() throws InterruptedException {
    Observable.just("Hello, World")
      .subscribe(System.out::println);
  }
}

// 04_attach_two