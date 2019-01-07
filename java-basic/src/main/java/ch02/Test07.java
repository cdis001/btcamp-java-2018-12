package ch02;

public class Test07 {
  public static void main(String[] args) {
    // '가' 문자를 출력하라
    System.out.println(0xac00); //UTF-16코드 값을 지정한다
    //해당 숫자가 UTF-16의 문자 코드임을 알려주지 않으면 일반 숫자로 처리
    
    //해당 숫자 앞에 (char)값을 붙여 문자열임을 알려야 '가'라고 출력 가능
    System.out.println((char)0xac00);
    
    //문자의 코드를 알지 못한다면 ''를 이용할 수 있다
    System.out.println('가'); //한글 '가'의 UTF-16 값을 리턴함 & 이 값이 문자의 코드 값임을 알려줌
    
    System.out.println('가' + 2);
    //'가'라는 UTF-16 값(44032)에 2를 더해 44034가 나옴
    
    System.out.println((char)('가' + 2));
    
    //혹은 ''안에 직접 유니코드(UTF-16)를 표기할 수 있음
    System.out.println('\uac00');
    
    //''안에 직접 유니코드를 지정하는 경우는 '특수문자를 지정하고 싶을 때' 함
    // -> 폰트에 따라 해당되는 특수문자가 안 나올 수도 있음
    // -> 그러므로 특수문자를 출력하고 싶으면, 해당 특수문자를 출력할 폰트에서 찾아야 함
    System.out.println('\u32d4');
    
  }

}
