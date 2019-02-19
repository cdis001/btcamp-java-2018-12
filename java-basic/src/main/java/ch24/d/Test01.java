package ch24.d;

public class Test01 {
  
  public static void main(String[] args) {
    Account acc = new Account("홍길동", 10000000);
    
    ATM kang101 = new ATM("강남 101", acc);
    ATM kang102 = new ATM("강남 102", acc);
    ATM kang103 = new ATM("강남 103", acc);
    
    kang101.start();
    kang102.start();
    kang103.start();
    
    //다른 스레드가 같은 값을 가지고 동시에 실행하기 때문에 스레드가 run()에서 언제 멈출지 모름
    // -> 스레드마다 잔액 값을 각각 가지고 있기 때문
    // -> 스레드마다 자신만의 로컬변수를 가지고 있기 때문
    // -> Account클래스의 this.balance가 동일한 메모리를 가지게끔 함
  }
  
}
