package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/showMap")
public class showMap extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
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
		@SuppressWarnings({ "unchecked", "unused" })
		Map<String,String> tempdataMap = (Map<String, String>) this.getServletContext().getAttribute("dataMap");
		String key = request.getParameter("requestid");
		if(key!=null){
		System.out.println(key);
		if(tempdataMap!=null){
		for(Map.Entry<String, String> map:tempdataMap.entrySet()){
			if(map.getKey().equals(key)){
				String str = map.getValue();
				System.out.println(str);
				if(str!=null){
					JSONArray jsonarry = new JSONArray();
					jsonarry = JSONArray.fromObject(str);
					response.setContentType("text/text");          //设置请求以及响应的内容类型以及编码方式
					response.setCharacterEncoding("gbk");
					response.setCharacterEncoding("gbk");
					PrintWriter out=response.getWriter();
					String tempstr = "";
					JSONObject tempobj = new JSONObject();
					for(int j=0;j<jsonarry.size();j++){
						JSONObject jsonObj = jsonarry.getJSONObject(j);
						tempstr = jsonObj.toString().substring(jsonObj.toString().indexOf(":")+2, jsonObj.toString().indexOf(",")-1);
						tempobj.put("name"+j, tempstr);
//						out.println(json);
//						out.flush();
				//		newdata[j] = tempstr;
						tempstr = null;
					}
					System.out.println(tempobj.toString());
					out.println(tempobj.toString());
					out.flush();
					out.close();
					}
			}
		}
		}
		}
		
	
	}

}
