package complexity_measuring_tool.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.CommonParams;
import complexity_measuring_tool.util.MyStack;

/*
 * @Author Peiris.M.R.P
 * IT16173064
 */
public class ComplexityNesting {

	static ArrayList<String> stack = new ArrayList<String>();
	static MyStack myStack = new MyStack();
	private static Logger logger = Logger.getLogger(ComplexityInheritance.class.getName()); 

	public static int calculateNestingComplexity(CheckFile checkFile) {
		int complexityNestingValue = 0;
		
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
		
		//Pattern decelerations
		final Pattern forLoopPattern = Pattern.compile(CommonParams.REGEX_FOR_LOOP);
		final Pattern forEachPattern = Pattern.compile(CommonParams.REGEX_FOR_EACH);
		final Pattern whileLoopPattern = Pattern.compile(CommonParams.REGEX_WHILE_LOOP);
		final Pattern ifPattern = Pattern.compile(CommonParams.REGEX_IF);
		final Pattern switchPattern = Pattern.compile(CommonParams.REGEX_SWITCH);
		final Pattern elsePattern = Pattern.compile(CommonParams.REGEX_ELSE);
		final Pattern lineEndsPattern = Pattern.compile(CommonParams.LINE_ENDS_WITH_CURLY);
		final Pattern lineStartsPattern = Pattern.compile(CommonParams.LINE_STARTS_WITH_CURLY);
		
		
		for (String line : checkFile.getFileLines()) {
			line.trim();// removing all the leading and traling spaces in a line
			
			if (null != line) {
				Matcher forLoopMatcher = forLoopPattern.matcher(line);
				if (forLoopMatcher.matches()) {
					System.out.println("For loop found syntax is " + line);
					myStack.push(line);
				}
				Matcher forEachMatcher = forEachPattern.matcher(line);
				if (forEachMatcher.matches()) {
					System.out.println("For each found syntax is " + line);
					myStack.push(line);
				}
				Matcher whileLoopMatcher = whileLoopPattern.matcher(line);
				if (whileLoopMatcher.matches()) {
					System.out.println("while loop found syntax is " + line);
					myStack.push(line);
				}
				Matcher ifMatcher = ifPattern.matcher(line);
				if (ifMatcher.matches()) {
					System.out.println("if found syntax is " + line);
					myStack.push(line);
				}
				Matcher switchMatcher = switchPattern.matcher(line);
				if (switchMatcher.matches()) {
					System.out.println("Switch found syntax is " + line);
					myStack.push(line);
				}
				Matcher elseMatcher = elsePattern.matcher(line);
				if (elseMatcher.matches()) {
					System.out.println("else found syntax is " + line);
					myStack.push(line);
				}
				// removing finishing brackets in the stack
				Matcher lineEndMatcher = lineEndsPattern.matcher(line);
				Matcher lineStartMatcher = lineStartsPattern.matcher(line);
				if (myStack.peek() > 0 && (lineEndMatcher.matches() || lineStartMatcher.matches() )){
					myStack.pop();
				}
				System.out.println("Stack value : " + myStack.peek()+ line);
				complexityNestingValue += myStack.peek();
			}
		}
		logger.info("Total nesting complexity of "+checkFile.getFileName()+" is :"+ complexityNestingValue);
		logger.info("-----------------------------------------------------------------------------");
		fileHandler.close();
		return complexityNestingValue;

	}

}
