package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@SuppressWarnings("serial")
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {

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
	private String Ext_Name = "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2,csv";
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
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 	request.setCharacterEncoding("UTf-8");
		 	Map<String, String> dataMap = new HashMap<String, String>();
		 	Map<String,Boolean> flagMap =  new HashMap<String, Boolean>();
		 	if(this.getServletContext().getAttribute("dataMap")==null){
		 		this.getServletContext().setAttribute("dataMap", dataMap);
		 	}else{
		 		dataMap=(Map<String, String>) this.getServletContext().getAttribute("dataMap");
		 	}
		 	if(this.getServletContext().getAttribute("flagMap")==null){
		 		this.getServletContext().setAttribute("flagMap", flagMap);
		 	}else{
		 		flagMap=(Map<String, Boolean>) this.getServletContext().getAttribute("flagMap");
		 	}
		    //获取tomcat下的up目录的路径   
	        JSONArray array=new JSONArray();            
	        CSVUtil util;  
	            try {  
	                util = new CSVUtil(request);  
	                int row=util.getRowNum();  
	                int col=util.getColNum(); 
	                System.out.println(row+"   "+col);
	                for(int i=1;i<row;i++){
	                	JSONObject jsonobject=new JSONObject();
	                for(int j=0;j<col;j++){  
	                      
	                    String value=util.getRow(i);  
	                    jsonobject.put(util.getString(0, j),util.getString(i,j));  
	                      
	                }
	                array.add(jsonobject);
	                }
	            } catch (Exception e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  		
		        for(int j=0;j<array.size();j++){
		        	System.out.println(array.getJSONObject(j).toString());
		        }
		       SendJson sJ = new SendJson();
		       String datachar = sJ.register(array);
		        
		        	System.out.println(array.size());
//		        	System.out.println(isSucessed);
//		        	if(isSucessed==1){
//		        		GetJsonListener GL = new GetJsonListener();
//		        		GL.Changeflag();
//		        		
//		        		System.out.println("sss");
//		        	}
		       //sJ.GetJson(response, request);
		        	/*String file = "测试结果数据.csv";
		    		response.setContentType(this.getServletContext().getMimeType(file));
		    		response.setHeader("Content-Disposition", "attachment;filename="+new String(file.getBytes("GBK"),"iso8859-1"));
		    		response.setCharacterEncoding("gbk");
		    		
		    		PrintWriter out=response.getWriter();
		    		out.println("商品名称,商品类型1,商品类型2,商品类型3,商品类型4,商品类型5");
		    		out.flush();
		    		out.close();*/
		        	if(datachar!=null){
		        		String onlyId = request.getSession().getId();
		        		System.out.println(onlyId);
		        		System.out.println(datachar);
		        		dataMap.put(onlyId, datachar);
		        		this.getServletContext().setAttribute("dataMap", dataMap);
		        		flagMap.put(onlyId, true);
//		        		this.getServletContext().setAttribute("flagMap", flagMap);
		        		response.getWriter().print(onlyId);
		        		
		        	}
		        	System.out.println("successdownload");
		    		
    }
}
