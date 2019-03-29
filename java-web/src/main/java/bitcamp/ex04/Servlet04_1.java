package bitcamp.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/s41")
public class Servlet04_1 extends GenericServlet {

  private String uploadDir;
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    /*
     * String age = req.getParameter("age"); String name = req.getParameter("name"); String photo =
     * req.getParameter("photo");
     * 
     * res.setContentType("text/plain;charset=UTF-8"); PrintWriter out = res.getWriter();
     * out.printf("이름=%s\n", name); out.printf("나이=%s\n", age); out.printf("사진=%s\n", photo);
     */
    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

    ServletFileUpload multipartDataHandler = new ServletFileUpload(fileItemFactory);

    HashMap<String, String> paramMap = new HashMap<String, String>();

    try {
      List<FileItem> parts = multipartDataHandler.parseRequest((HttpServletRequest) req);

      for (FileItem part : parts) {
        if (part.isFormField()) {
          paramMap.put(part.getFieldName(), part.getString("UTF-8"));
        } else {

          String filename = UUID.randomUUID().toString();

          File file = new File(uploadDir + "/" + filename);

          part.write(file);

          paramMap.put(part.getFieldName(), filename);
        }
      }

      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      out.println("<html>");
      out.println("<head><title>servlet04</title></head>");
      out.println("<body><h1>파일 업로드 결과</h1>");
      out.printf("이름=%s<br>\n", paramMap.get("name"));
      out.printf("나이=%s<br>\n", paramMap.get("age"));
      out.printf("사진=%s<br>\n", paramMap.get("photo"));
      out.printf("<img src='../upload/%s'>\n", paramMap.get("photo"));
      out.println("</body></html>");
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
