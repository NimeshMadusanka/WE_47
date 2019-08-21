package complexity_measuring_tool.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.service.ComplexityInheritance;
import complexity_measuring_tool.service.FileRead;
import complexity_measuring_tool.util.CommonParams;


/**
 * Servlet implementation class ComplexityInheritanceController
 */
@WebServlet("/ComplexityInheritanceController")
@MultipartConfig
public class ComplexityInheritanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File logFolder = new File("C:/COMPLEXITY/LOG");
	private File logFile = new File(CommonParams.LOG_FILE_PATH);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplexityInheritanceController() {
        super();
        // TODO Auto-generated constructor stub
      //Creating Log folder if does not exist in Windows system
  		if(!logFolder.exists()) {
  			logFolder.mkdirs();
  		}
  		//Creating if log file does not exist
  		if(!logFile.exists()) {
  			try {
  				logFile.createNewFile();
  			}catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Resetting static value of ComplexityInheritance for next check ,
		//Resetting static ci value to 0 when the total complexity measuring
//		ComplexityInheritance.resetCIValue();
		
		//Get file part
		Part filePart= request.getPart("file");
		
		String fileName = "";
		//Get file parts and retrieve the received file name
		for (Part part : request.getParts()) {
            fileName = extractFileName(part);
        }
		InputStream inputStream=filePart.getInputStream();
		String[] arrayFile = fileName.split("\\\\");
		String fname = arrayFile[arrayFile.length - 1];
		//Create file object to save the file in Local folder
		File requestFile = new File(CommonParams.LOCAL_UPLOAD_FILE_FOLDER_PATH+fname);
		Files.copy(inputStream, requestFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//Read file and get file line by line as String Array object
		ArrayList<String> fileLines = FileRead.getFileStringLines(requestFile);
		long curMilliseconds=System.currentTimeMillis();
		Date date=new Date(curMilliseconds);
		CheckFile checkFile=new CheckFile(fileName,fileLines,date);
		int ciValue=0;
		if(null != checkFile) {
			ciValue = ComplexityInheritance.calculateCi(checkFile);
		}
		
		request.setAttribute("tci", ciValue);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
	
	//Private method to extract file name
	private String extractFileName(Part part) {
		 String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	}

}
