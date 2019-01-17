package ch14.e;

public class PickupTruck extends Truck {
  int copacity; //승차인원
  
  @Override
  public void run() {
    System.out.println("꽈당당~~ 달린다");
  }

}
