package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
@SuppressWarnings("serial")
@WebServlet("/GetJsonListener")
public class GetJsonListener extends HttpServlet {
	private static boolean isdataget = false;

	public GetJsonListener() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void Changeflag(){
		this.isdataget = true;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject tempjson = new JSONObject();
		tempjson.put("isgetdata", isdataget);
		response.getWriter().print(tempjson.toString());
	}

}
