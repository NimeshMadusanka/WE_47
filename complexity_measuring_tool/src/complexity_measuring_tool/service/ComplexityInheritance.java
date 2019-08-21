package complexity_measuring_tool.service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.CommonParams;
/*
 * @Author Team Members
 */
public class ComplexityInheritance {
	
	private static int complexityInheritanceValue=0;
	private static Logger logger = Logger.getLogger(ComplexityInheritance.class.getName()); 
	
	public static int calculateCi(CheckFile checkFile) {
		//File handler open to write logs 
		FileHandler fileHandler=null;
		try {
			///
			fileHandler = new FileHandler(CommonParams.LOG_FILE_PATH,true);
			logger.addHandler(fileHandler);
			SimpleFormatter formatter =new SimpleFormatter();
			fileHandler.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			logger.info("Error occured while handling the file in "+CommonParams.LOG_FILE_PATH+" exception ocured due to "+e.getCause());
			e.printStackTrace();
		}
		
		//Check line by line in the file
		for (String line : checkFile.getFileLines()) {
			line.trim();// removing spaces leading and trailing in a line
			if(line.contains("class ") || line.contains("interface ") ) {
				complexityInheritanceValue+=2;//Class or interface complexity default value is 2
				if(line.contains("extends ")) {
					complexityInheritanceValue +=1;//Always extends have one super class increment by 1
				}
				if(line.contains("implements ")) {
					String[] splitted= line.split("implements ");
					String keyWordAfterString=splitted[CommonParams.ARRAY_SECOND_ELEMENT];//Put implemented interfaces to String array
					String[] beforCurly = keyWordAfterString.split("\\{");//Removing {
					if(beforCurly.length > 0) {//Check weather that have interfaces > 0  
						String[] implementedSuper = beforCurly[CommonParams.ARRAY_FIRST_ELEMENT].split(",");//Interfaces put in to the String array
						for (int i = 0; i < implementedSuper.length; i++) {
							complexityInheritanceValue+=1;//Increase complexity by one once found inherited interface
							System.out.println("This class implemented interface "+(i+1)+" by "+implementedSuper[i].trim());
						}
					}
				}
			}
		}
		logger.info("Total inheritance complexity of "+checkFile.getFileName()+" is :"+ complexityInheritanceValue);
		logger.info("-----------------------------------------------------------------------------");
		fileHandler.close();
		return complexityInheritanceValue;
	}
	
	public static void resetCIValue() {
		complexityInheritanceValue = 0;
	}

}
