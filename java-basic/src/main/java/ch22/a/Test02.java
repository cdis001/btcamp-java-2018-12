package ch22.a;

import java.io.File;

public class Test02 {
  public static void main(String[] args) throws Exception {
    File file = new File("build.gradle");
    System.out.println(file.getName()); //폴더명
    System.out.println(file.getPath()); //경로
    System.out.println(file.getAbsolutePath()); //절대 경로
    System.out.println(file.getCanonicalPath()); //계산된 경로
    System.out.println(file.getTotalSpace()); //HDD전체 용량
    System.out.println(file.getFreeSpace()); //빈 용량
    System.out.println(file.getUsableSpace()); //빈 용량중에 사용할 수 있는 용량
    System.out.println(file.length()); //파일 크기
    
    System.out.println(file.isDirectory());
    System.out.println(file.isFile());
    System.out.println(file.isHidden());
    System.out.println(file.exists());
    System.out.println(file.canExecute());
    
    System.out.println("-----------------------------");
    
    File dir2 = new File("bulid.gradle2");
    System.out.println(dir2.getName()); //폴더명
    System.out.println(dir2.getPath()); //경로
    
    //예외가 발생할 수 있으나, 중요치 않은 예외이기 때문에 경고 X
    System.out.println(dir2.getAbsolutePath()); //절대 경로
    
    //예외가 발생할 수 있으며 중요한 예외이기 때문에 경고 O
    System.out.println(dir2.getCanonicalPath()); //계산된 경로
    
    System.out.println(dir2.getTotalSpace()); //HDD전체 용량
    System.out.println(dir2.getFreeSpace()); //빈 용량
    System.out.println(dir2.getUsableSpace()); //빈 용량중에 사용할 수 있는 용량
    
    System.out.println(dir2.isDirectory());
    System.out.println(dir2.isFile());
    System.out.println(dir2.isHidden());
    System.out.println(dir2.exists());
    System.out.println(dir2.canExecute());
  }
}
