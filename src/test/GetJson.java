package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/GetJson")
public class GetJson extends HttpServlet {
	private String[] strs = null;
	private static JSONArray jsonarry = new JSONArray();
	private boolean isgetdata = false;
	public void splitString(String datachar){
//		String tempstr = null;
//		tempstr = datachar.substring(1, datachar.length()-2);
//		int index = 0,i = 0;
//		while(index>=0){
//			index = tempstr.indexOf("}");
//			System.out.println(index);
//			System.out.println(tempstr.substring(0, index+1));
//			tempstr = tempstr.substring(index+2);
//			//System.out.println(strs[i]);
//			i++;
//		}
		jsonarry = JSONArray.fromObject(datachar);
		if(jsonarry.size()>0){
			isgetdata = true;
			for(int i=0;i<jsonarry.size();i++){
				JSONObject jsonObj = jsonarry.getJSONObject(i);
				System.out.println(jsonObj.toString());
			}
		}
		
		
	}
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
		String id = new String();
		id = request.getParameter("id");
		Map tempMap = (Map) this.getServletContext().getAttribute("dataMap");
		if(tempMap.get(id)!=null){
		jsonarry = JSONArray.fromObject(tempMap.get(id));
		System.out.println(jsonarry.toString());
		if(jsonarry.size()>0){
			@SuppressWarnings("unused")
//			HttpSession session = request.getSession();
//			String[] newdata = new String[jsonarry.size()];
	        String file = "≤‚ ‘ ˝æ›.csv";
			response.setContentType(request.getServletContext().getMimeType(file));
			response.setHeader("Content-Disposition", "attachment;filename="+new String(file.getBytes("GBK"),"iso8859-1"));
			response.setCharacterEncoding("gbk");
			PrintWriter out=response.getWriter();
			String tempstr = "";
			System.out.println("done");
			for(int j=0;j<jsonarry.size();j++){
				JSONObject jsonObj = jsonarry.getJSONObject(j);
				String jsonstring=jsonObj.toString();
				String[] jsonStrArray = jsonstring.split(",");
				for(int ju = 0;ju<jsonStrArray.length;ju++)
				{
				tempstr = jsonStrArray[ju].substring(jsonObj.toString().indexOf(":")+1, jsonObj.toString().indexOf(",")+1);
				System.out.println(tempstr);
				System.out.println(jsonObj.toString());
	    		out.print(tempstr);
	    		out.flush();
//				newdata[j] = tempstr;
				tempstr = null;
				}
				out.println();
			}
			out.close();
		}
//			session.setAttribute("newdata", newdata);
		}
		
		
		
	}

}
