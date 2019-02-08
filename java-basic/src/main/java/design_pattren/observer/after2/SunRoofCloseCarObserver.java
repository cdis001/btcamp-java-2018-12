package design_pattren.observer.after2;

public class SunRoofCloseCarObserver extends AbstractCarObserver {

  @Override
  public void carStopped() {
    System.out.println("선루프 닫힘");
    
  }


}
