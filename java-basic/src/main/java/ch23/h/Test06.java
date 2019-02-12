package ch23.h;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test06 {
  public static void main(String[] args) throws Exception {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet get = new HttpGet("http://sk.co.kr");
    
    CloseableHttpResponse response = httpClient.execute(get);
    
    HttpEntity entity = response.getEntity();
    if(entity != null) {
    System.out.printf("응답 데이터 크기: %d", 
        entity.getContentLength());
    System.out.printf("응답 데이터의 MIME 타입: %d", 
        entity.getContentType());
    }
    InputStream in = entity.getContent();
    System.out.println(in);
    String content = EntityUtils.toString(entity);
    System.out.println(content);
    
  }
}
