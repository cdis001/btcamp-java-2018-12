package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.eomcs.util.ConnectionFactory;

public abstract class AbstractCommand implements Command {

  public void execute(BufferedReader in, PrintWriter out) {
    try {
      execute(new Response(in, out));

      ConnectionFactory.create().commit();
    } catch (Exception e) {
      try {

        ConnectionFactory.create().rollback();
      } catch (SQLException e1) {

      }
      out.println("실행 오류: " + e.getMessage());
    }
  }

  public void execute(Response response) throws Exception {

  }
}
