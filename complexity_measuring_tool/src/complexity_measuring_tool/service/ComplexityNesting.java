package complexity_measuring_tool.service;

import java.util.ArrayList;
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

	public static int calculateNestingComplexity(CheckFile checkFile) {
		int complexityNestingValue = 0;
		System.out.println(checkFile.getDate());
		final Pattern forLoopPattern = Pattern.compile(CommonParams.REGEX_FOR_LOOP);
		final Pattern forEachPattern = Pattern.compile(CommonParams.REGEX_FOR_EACH);
		final Pattern whileLoopPattern = Pattern.compile(CommonParams.REGEX_WHILE_LOOP);
		final Pattern ifPattern = Pattern.compile(CommonParams.REGEX_IF);
		final Pattern switchPattern = Pattern.compile(CommonParams.REGEX_SWITCH);
		final Pattern elsePattern = Pattern.compile(CommonParams.REGEX_ELSE);

		for (int i = 0; i < 10; i++) {

		}

		for (String line : checkFile.getFileLines()) {
			line.trim();// removing all the leading and traling spaces in a line
			System.out.println(line);
			if (null != line) {
				Matcher forLoopMatcher = forLoopPattern.matcher(line);
				if (forLoopMatcher.matches()) {
					System.out.println("For loop found syntax is " + line);
					myStack.push(line);
				}
				Matcher forEachMatcher = forEachPattern.matcher(line);
				if (forEachMatcher.matches()) {
					myStack.push(line);
				}
				Matcher whileLoopMatcher = whileLoopPattern.matcher(line);
				if (whileLoopMatcher.matches()) {
					myStack.push(line);
				}
				Matcher ifMatcher = ifPattern.matcher(line);
				if (ifMatcher.matches()) {
					myStack.push(line);
				}
				Matcher switchMatcher = switchPattern.matcher(line);
				if (switchMatcher.matches()) {
					myStack.push(line);
				}
				Matcher elseMatcher = elsePattern.matcher(line);
				if (elseMatcher.matches()) {
					myStack.push(line);
				}
				// removing closing brackets in the stack
				if (myStack.peek() > 0 && line.startsWith("}") /* || line.endsWith("{") */) {
					myStack.pop();
				}
				complexityNestingValue += myStack.peek();
			}
		}
		return complexityNestingValue;

	}

}
