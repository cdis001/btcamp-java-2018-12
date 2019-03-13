package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class AbstractCommand implements Command {
  
  protected String name;
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void execute(BufferedReader in, PrintWriter out) {
    try {
      execute(new Response(in, out));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void execute(Response response) throws Exception {

  }
}
