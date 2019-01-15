package ch10;

public class Test14 {
  public static void main(String[] args) throws Exception {
    String s1 = new String();

    System.out.println(s1);

    String s2 = new String("Hello");
    char[] chars = {'H', 'E', 'L', 'L', 'O'};
    String s3 = new String(chars);
    byte[] bytes = {(byte)0xb0, (byte)0xa1, (byte)0xb0, 
        (byte)0xa2, 0x30};
    String s4 = new String(bytes); //한글코드값이 아니라서 글씨가 깨짐
    String s5 = new String(bytes, "euc-kr"); //배열에 있는 코드 값이 어디 코드값인지 알려줘야 함
    byte[] bytes2 = {(byte)0xac, 0x00, (byte)0xac, (byte)0x01,
        0x00, 0x61, 0x00, 0x62, 0x00, 0x63};
    String s6 = new String(bytes2, "UTF-16"); //코드값이 어느 문자표인지 '확실히' 알려줘야 함
    byte[] bytes3 = {(byte)0xea, (byte)0xb0, (byte)0x80,
        0x61, 0x62, 0x63};
    String s7 = new String(bytes3, "UTF-8");
    
    System.out.println(s2);
    System.out.println(s3);
    System.out.println(s4);
    System.out.println(s5);
    System.out.println(s6);
    System.out.println(s7);
  }  
}
