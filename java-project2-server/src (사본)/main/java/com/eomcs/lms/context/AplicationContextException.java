package com.eomcs.lms.context;

public class AplicationContextException extends RuntimeException {
  
  //클래스 이름만으로 어떤 오류인지 쉽게 알게 하게끔 만들기 위해서 Exception class를 만듦
  
  private static final long serialVersionUID = 1L;
 
  public AplicationContextException() {
    super();
  }

  public AplicationContextException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public AplicationContextException(String message, Throwable cause) {
    super(message, cause);
  }

  public AplicationContextException(String message) {
    super(message);
  }

  public AplicationContextException(Throwable cause) {
    super(cause);
  }
  
  
}
