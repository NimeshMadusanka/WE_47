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
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,      
maxRequestSize=1024*1024*50)
public class ComplexityInheritanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplexityInheritanceController() {
        super();
        // TODO Auto-generated constructor stub
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

		Part filePart= request.getPart("file");
		String fileName=filePart.getName();
		InputStream inputStream=filePart.getInputStream();
		
		File saveFile = new File(CommonParams.LOCAL_UPLOAD_FILE_FOLDER_PATH+fileName);
		Files.copy(inputStream, saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		File requestFile = (File) request.getPart("file");
		ArrayList<String> fileLines = FileRead.getFileStringLines(requestFile);
		long curMilliseconds=System.currentTimeMillis();
		Date date=new Date(curMilliseconds);
		CheckFile checkFile=new CheckFile(fileName,fileLines,date);
		int ciValue = ComplexityInheritance.calculateCi(checkFile);
		//ComplexityInheritance.resetCIValue();//Resetting static ci value to 0 when the total complexity measuring
		
		request.setAttribute("tci", ciValue);
		request.getRequestDispatcher("testci.jsp").forward(request, response);
	}

}
