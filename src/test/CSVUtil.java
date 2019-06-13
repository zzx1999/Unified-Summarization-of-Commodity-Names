package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class CSVUtil {
	private String fileName = null;  
    private BufferedReader br = null;  
    private List<String> list = new ArrayList<String>();  
  
    @SuppressWarnings("unchecked")
	public CSVUtil(HttpServletRequest request) throws Exception {
	      long progress = 0;//进度
          String stemp;
	      int readNumber = 0;
    	if(ServletFileUpload.isMultipartContent(request))
    	{
    	DiskFileItemFactory factory = new DiskFileItemFactory();
	    factory.setSizeThreshold(4*1024);
	     
	    ServletFileUpload upload = new ServletFileUpload(factory);
	     
	    List<FileItem> fileItems;
	    try {
	      fileItems = upload.parseRequest(new ServletRequestContext(request));
	      //获取文件域
	      FileItem fileItem = fileItems.get(0);
	      //文件名生成文件号
	      String id = fileItem.getName();
	      //向单例哈希表写入文件长度和初始进度
	      ProgressSingleton.put(id + "Size", fileItem.getSize());
	      System.out.println(fileItem.getSize());
	      //文件进度长度
	      //用流的方式读取文件，以便可以实时的获取进度
	      InputStream in = fileItem.getInputStream();
	      InputStreamReader read = new InputStreamReader (in,"gb2312");
	      //FileOutputStream out = new FileOutputStream(files+"/"+id);
          br = new BufferedReader(read);  
          int rowNum = this.getRowNum();
          while ((stemp = br.readLine()) != null) {
                  list.add(stemp);
                  
          }
	      InputStream in2 = fileItem.getInputStream();
	      //Thread up = new Thread(new uploadThread(progress,id,readNumber,in2));
	      //up.start();
	      //new Thread(new ProcessServlet(fileItem.getName())).start();
	      byte[] buffer = new byte[1024];
	     while((readNumber = in2.read(buffer))!=-1){
	        //每读取一次，更新一次进度大小
	        progress = progress + readNumber;
	        System.out.println(progress);
	        //向单例哈希表写入进度
	        ProgressSingleton.put(id + "Progress", progress);
	        //out.write(buffer);
	    	 
	      }
	      //当文件上传完成之后，从单例中移除此次上传的状态信息
	     ProgressSingleton.remove(id+"Progress");
	     ProgressSingleton.remove(id+"size");
	      in.close();
	      //out.close();
	    } catch (FileUploadException e) {
	      e.printStackTrace();
	    }
    	}
	    System.out.println("done");
            //this.fileName = fileName;
            //InputStreamReader read = new InputStreamReader (new FileInputStream(new File(fileName)),"gb2312");
            //br = new BufferedReader(read);  
            //String stemp;  
           // while ((stemp = br.readLine()) != null) {
            //        list.add(stemp);  
            //}  
    }  
  
    public List getList() {  
            return list;  
    }  
    /** 
     * 获取行数 
     * @return 
     */  
    public int getRowNum() {  
            return list.size();  
    }  
    /** 
     * 获取列数 
     * @return 
     */  
    public int getColNum() {  
            if (!list.toString().equals("[]")) {  
                    if (list.get(0).toString().contains(",")) {// csv为逗号分隔文件  
                            return list.get(0).toString().split(",").length;  
                    } else if (list.get(0).toString().trim().length() != 0) {  
                            return 1;  
                    } else {  
                            return 0;  
                    }  
            } else {  
                    return 0;  
            }  
    }  
    /** 
     * 获取制定行 
     * @param index 
     * @return 
     */  
    public String getRow(int index) {  
            if (this.list.size() != 0) {  
                    return (String) list.get(index);  
            } else {  
                    return null;  
            }  
    }  
    /** 
     * 获取指定列 
     * @param index 
     * @return 
     */  
    public String getCol(int index) {  
            if (this.getColNum() == 0) {  
                    return null;  
            }  
            StringBuffer sb = new StringBuffer();  
            String tmp = null;  
            int colnum = this.getColNum();  
            if (colnum > 1) {  
                    for (Iterator it = list.iterator(); it.hasNext();) {  
                            tmp = it.next().toString();  
                            sb = sb.append(tmp.split(",")[index] + ",");  
                    }  
            } else {  
                    for (Iterator it = list.iterator(); it.hasNext();) {  
                            tmp = it.next().toString();  
                            sb = sb.append(tmp + ",");  
                    }  
            }  
            String str = new String(sb.toString());  
            str = str.substring(0, str.length() - 1);  
            return str;  
    }  
    /** 
     * 获取某个单元格 
     * @param row 
     * @param col 
     * @return 
     */  
    public String getString(int row, int col) {  
            String temp = null;  
            int colnum = this.getColNum();  
            if (colnum > 1) {  
                    temp = list.get(row).toString().split(",")[col];  
            } else if(colnum == 1){  
                    temp = list.get(row).toString();  
            } else {  
                    temp = null;  
            }  
            return temp;  
    }  
  
    public void CsvClose()throws Exception{  
            this.br.close();  
    }  
    /** 
    *去表头 
    **/  
    public String removehead(String str){  
        String[] str_1=str.split(",");  
        String sb=new String();  
        for(int i=1;i<str_1.length;i++){  
            sb=sb+str_1[i]+",";  
        }  
        return sb;  
    }  

}
