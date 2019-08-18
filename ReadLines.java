package spmtest;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadLines {
	
	public static void readlines(File f) throws IOException {
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int Cs1 = 0;
		int Cs2 = 0;
		int Cs = 0;
		int Cs3 = 0;
		int Cs4 = 0;
		boolean b;
		
		HashMap<String, Integer> frequency = new HashMap<String, Integer>();
		
		while((line = br.readLine()) != null) {
			
			// "^\".*\"$"
			
				
			
			
			if(!line.trim().equals("")) 
			{
				String[] words = line.split(" "); 
				
				for(String word : words) {
					if(word == null || word.trim().equals("")) {
						continue;
					}
					String processed = word.toLowerCase();
					
					if(frequency.containsKey(processed)) {
						frequency.put(processed, frequency.get(processed) +1);
					} 
					else {
						frequency.put(processed, 1);
					}
					
					Pattern p = Pattern.compile("^\".*\"$");
					Matcher m = p.matcher(word);
					if( b = m.matches()) {
						Cs3++;	
					}
					if(word.matches(".*\\d.*")){
						Cs4++;
					}
					
					
				}
				
				
				
			
			}//end of the if
			
			
			
			
		}//end of while 
		
		 
		
		/*Cs = (frequency.get("+") + frequency.get("-") + frequency.get("++") + frequency.get("*") +frequency.get("/") + frequency.get("%") + frequency.get("--")
			+frequency.get("==") + frequency.get("!=") + frequency.get(">") + frequency.get("<") + frequency.get(">=") + frequency.get("<=") + frequency.get(">=")
			+ frequency.get("&&") + frequency.get("||") + frequency.get("!") + frequency.get("<<") + frequency.get(">>") + frequency.get(">>>") + frequency.get("<<<")
			+ frequency.get("_>") + frequency.get("::") + frequency.get("+=") + frequency.get("-=") + frequency.get("*=") + frequency.get("/=") + frequency.get(">>>=")
			+ frequency.get("|=") + frequency.get("&=") + frequency.get("%=") + frequency.get("<<=") + frequency.get(">>=") + frequency.get("^=") + frequency.get("void")
			+ frequency.get("double") + frequency.get("int") + frequency.get("float") + frequency.get(">")
				
				
				
				);*/
			
		
		
			try {
				Cs1 = (frequency.get("+") + frequency.get("-") + frequency.get("++") );
				Cs2 = (frequency.get("new") + frequency.get("throw") + frequency.get("throws"));
				Cs = (Cs2*2) + Cs1 + Cs3 +Cs4;
			}catch(NullPointerException e) {
				System.out.println("null pointers found");
			}
		
		
		System.out.println("Cs :" +Cs);
		System.out.println("Cs4 :" +Cs4);
				
		//System.out.println("frequency : " +frequency);
		br.close();
		fr.close();
		
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
