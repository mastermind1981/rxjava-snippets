package com.vgrazi.observable;

import com.vgrazi.play.PriceTick;
import com.vgrazi.play.SomeFeed;
import com.vgrazi.play.SomeListener;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by vgrazi on 8/23/16.
 */
public class Launcher {

  public static void main(String[] args) throws InterruptedException {
    new Launcher().launch();
  }

  private void launch() throws InterruptedException {
    SomeFeed feed = new SomeFeed(3);
    Observable<PriceTick> observable = Observable.create(s ->
      feed.register(new SomeListener() {
        @Override
        public void priceTick(PriceTick event) {
          s.onNext(event);
        }

        @Override
        public void error(Throwable throwable) {
          s.onError(throwable);
        }

      })
    );

    Observable<PriceTick> take = observable.take(20);
    take.subscribe(System.out::println);
  }
}

// 04_attach_two