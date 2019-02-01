package ch22.c;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
  
  InputStream in;
  byte[] buf = new byte[1024];
  int size = 0;
  int cursor = 0;
  
  public BufferedInputStream (InputStream in) {
    this.in = in;
  }
  
  public int read() throws IOException {
    if(cursor >= size) {
      size = in.read(buf);
      if (size == -1) {
        return -1; //읽는것이 끝나면 size는 -1이 됨
      }
      cursor = 0;
    }
    
  //바이트의 값을 온전히 4바이트 int값으로 변환하기 위해 & 비트연산 사용
    //& 비트연산을 사용하지 않을 경우 byte에서 int로 변환할 때,
    // ff값을 (1111 1111) -> (1111.....1111)로 변환하게 되어 
    //-1값으로 인식하게 되므로 연산이 끝나버림 (읽는것이 끝나면 -1)
    //그러므로 &연산자를 사용하여 ff값을 (0000.....1111 1111)로 변환시킴
    return buf[cursor++] & 0xff; 
  }
}
