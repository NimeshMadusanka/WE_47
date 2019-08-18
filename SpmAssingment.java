package spmtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class SpmAssingment {
	
	public static void readlines(File f) throws IOException {
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int lineNo = 0;
		int Cs1 = 0;
		int Cs2 = 0;
		int Cs = 0;
		
		while((line = br.readLine()) != null) {
			
			if(!line.trim().equals("")) {
				
				lineNo++;
				System.out.println("Line " +lineNo+ " : " +line);
				
			    Pattern P1 = Pattern.compile("\"^if\\(.*\\)$|^switch\\(.*\\)$|^case.*:$|^for\\(.*\\)$|^do\\(.*\\)$|^while\\(.*\\)$|void|double|int|float|string|printf|println|cout|cin|\\+|\\-|\\*|^.*\\++$|^.*\\--$|\\%|\\/|&|[0-9]|\\+=|\\-=|\\*=|\\/=|\\|=|>>>=|\\\\^=|>>=|<<=|,|_>|class");
			    Matcher M1 = P1.matcher(line);
			    if(M1.find()) {
				  Cs1++; 
			   }
			    
			    Pattern P2 = Pattern.compile("new|delete|throw|throws|\\(&\\)|\\(*\\)");
			    Matcher M2 = P2.matcher(line);
			    if(M2.find()) {
				  Cs2 = Cs2+2; 
			   }
			   
			   
			    
			}
			
		}
		Cs = Cs1+Cs2;
		System.out.println("Total Cs : " +Cs);
		System.out.println("Cs2 : " +Cs2);
		System.out.println("Cs1 : " +Cs1);

	}

	public static void main(String[] args) {
		File f = new File("C:\\Users\\HP\\Desktop\\spmtest.txt");
		try {
			readlines(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
