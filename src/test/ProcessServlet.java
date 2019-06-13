package test;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import test.ProgressSingleton;
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  private String filename;
  
  public ProcessServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    JSONObject json = new JSONObject(); 
    this.filename = request.getParameter("filename");
    Object size = ProgressSingleton.get(this.filename + "Size");
    size = size == null ? 100 : size;
    Object progress = ProgressSingleton.get(filename + "Progress");
    progress = progress == null ? size : progress; 
    json.put("size", size);
    json.put("progress", progress);
    System.out.println(json.toString());
    response.getWriter().print(json.toString());
    //使用sessionid + 文件名生成文件号，与上传的文件保持一致

  }
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
  }
 
}