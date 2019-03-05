package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.eomcs.lms.ApplicationInitializer;

public abstract class AbstractCommand implements Command {

  public void execute(BufferedReader in, PrintWriter out) {
    try {
    execute(new Response(in, out));
    ApplicationInitializer.con.commit();
    } catch (Exception e) {
      try {
        ApplicationInitializer.con.rollback();
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
    
  }
  
  public void execute(Response response) throws Exception {
    
    
  }
  
}
