package complexity_measuring_tool.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import javax.servlet.http.*;
import java.lang.String.*;

import complexity_measuring_tool.service.FileService;

/**
 * Servlet implementation class fileServlet
 */
@WebServlet("/fileServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,      
maxRequestSize=1024*1024*50) 
public class fileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("file");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    
	    File fileToSave = new File("C:/Users/Nimesh Madusanka/Documents/GitHub/WE_47/complexity_measuring_tool/WebContent/uploaded-files/nimesh.txt");
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//get the URL of the uploaded file
		String fileUrl = "http://localhost:8080/uploaded-files/" + "nimesh";
		
	      File f1=new File("C:/Users/Nimesh Madusanka/Documents/GitHub/WE_47/complexity_measuring_tool/WebContent/uploaded-files/nimesh.txt"); //Creation of File Descriptor for input file
	      String[] words=null;  //Intialize the word Array
	      FileReader fr = new FileReader(f1);  //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	      String s;     
	      String input1="if";   // Input word to be searched
	      String input2 ="&&", input3 = "&";
	      String input4 ="||", input5 = "|";
	      String input6="while", input7="for";
	      String input8="catch", input9="switch";
	      
	      int count=0;   //Intialize the word to zero
	      while((s=br.readLine())!=null)   //Reading Content from the file
	      {
	         words=s.split(" ");  //Split the word using space
	          for (String word : words) 
	          {
	                 if (word.equals(input1))   //Search for the given word
	                 {
	                   count++;    //If Present increase the count by one
	                 }
	                 else if(word.equals(input2)||word.equals(input2)) {
	                	 
	                	 count++; //If Present increase the count by one
	                 }
	                 else if(word.equals(input4)||word.equals(input5)) {
	                	 
	                	 count++; //If Present increase the count by one
	                 }
	                 else if(word.equals(input6)) {
	                	 count = count + 2;
	                 }
	                 else if(word.equals(input7)) {
	                	 count = count + 2;
	                 }
	                 else if(word.equals(input8)) {
	                	 count++;
	                 }
	                 else if(word.equals(input9)) {
	                	 for(int i=0; i < 3; i++)
	                	 {
	                		 count++;
	                	 } 
	                 }
	          }
	      }
	      if(count!=0)  //Check for count not equal to zero
	      {
	         System.out.println("The Ctc value "+count+ ".");
	      }
	      else
	      {
	         System.out.println("The given word is not present in the file");
	      }
	      
	         fr.close();
	         request.setAttribute("ctc", count);
	         request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
