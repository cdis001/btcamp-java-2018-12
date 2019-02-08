package design_pattren.observer.after;

public class SunRoofCloseCarObserver implements CarObserver {

  @Override
  public void carStarted() {
    
  }

  @Override
  public void carStopped() {
    System.out.println("선루프 닫힘");
    
  }


}
