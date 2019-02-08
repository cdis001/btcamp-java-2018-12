package design_pattren.observer.after;

import java.util.HashSet;

public class Car {
  
  HashSet<CarObserver> ovservers = new HashSet<>(); 
  
  public void addObserver (CarObserver observer) {
    ovservers.add(observer);
  }
    
  public void removeObserver (CarObserver observer) {
    ovservers.remove(observer);
  }

  public void notifyObserverOnStarted () {
    for(CarObserver observer : ovservers) {
      observer.carStarted();
    }
  }
  
  public void notifyObserverOnStopped () {
    for(CarObserver observer : ovservers) {
      observer.carStopped();
    }
  }
  
  public void start() {
    System.out.println("시동을 건다");
    
    notifyObserverOnStarted();
    
  }
  
  public void run() {
    System.out.println("달린다");
  }
  
  public void stop() {
    System.out.println("시동을 끈다");
    
    notifyObserverOnStopped();
    
  }
}
