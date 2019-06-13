package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

import javax.servlet.jsp.tagext.TryCatchFinally;

import net.sf.json.JSONArray;

public class SendJson {
	 public final String IP_ADDR = "10.11.12.9";//鏈嶅姟鍣ㄥ湴鍧�  杩欓噷瑕佹敼鎴愭湇鍔″櫒鐨刬p  
	
	 
	    public final int PORT = 12345;//鏈嶅姟鍣ㄧ鍙ｅ彿    
	    Socket socket = null;    
	      
	    @SuppressWarnings("null")
		public String register(JSONArray jsonarray){  
	        int isRegSuccess = 0;     
	                try {  
	                    //鍒涘缓涓�涓祦濂楁帴瀛楀苟灏嗗叾杩炴帴鍒版寚瀹氫富鏈轰笂鐨勬寚瀹氱鍙ｅ彿  
	                    socket = new Socket(IP_ADDR, PORT);
	                    socket.setReuseAddress(true);  //璁剧疆绔彛澶嶇敤涓� true
	                    System.out.println("杩炴帴宸茬粡寤虹珛"); 
	                    System.out.println(jsonarray.size());
	                    	byte[] jsonByte = jsonarray.toString().getBytes("utf-8");
	                    	DataOutputStream outputStream = null;  
	                    	outputStream = new DataOutputStream(socket.getOutputStream());  
	                        System.out.println("鍙戠殑鏁版嵁闀垮害涓�:"+jsonByte.length);  
	                        outputStream.write(jsonByte);  
	                        outputStream.flush();  
	                        System.out.println("浼犺緭鏁版嵁瀹屾瘯"); 
	                        System.out.println(jsonByte.toString());


	                        byte[] databytes = new byte[40960000];
	            	        InputStream is=socket.getInputStream();
	            	        int inp = -1;
	            	        int cnt = 0;
	            	        while((inp = is.read()) != -1){
	            	        	databytes[cnt] = (byte)inp;
	            	        	System.out.print((byte)inp);
	            	        	cnt++;
	            	        	if(databytes[cnt-1] == 93){
	            	        		databytes[cnt] = 0;
	            	        		break;
	            	        	}
	            	        }
	            	        is.close();
	            	        if(databytes!=null){
	            	        	String datastr = new String(databytes);
	            	        	System.out.println(datastr);
	            	        	isRegSuccess = 1;
	            	        	return datastr;
	            	        }
	            	        socket.close();
	                    

	            	           
	                } catch (Exception e) {  
	                    System.out.println("瀹㈡埛绔紓甯�:" + e.getMessage());   
	                    e.printStackTrace();

	                } finally {  
	                    if (socket != null) {  
	                        try {  
	                            socket.close();  
	                        } catch (IOException e) {  
	                            socket = null;   
	                            System.out.println("瀹㈡埛绔� finally 寮傚父:" + e.getMessage());   
	                        }  
	                    }  
	                }  
	         return null;     
	    }

}
