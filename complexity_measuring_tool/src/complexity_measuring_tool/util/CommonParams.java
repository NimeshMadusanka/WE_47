package complexity_measuring_tool.util;

/*
 * @author IT16173064
 * Peiris M.R.P
 */

public class CommonParams {
	
	public static final int ARRAY_FIRST_ELEMENT = 0;
	public static final int ARRAY_SECOND_ELEMENT = 1;
	public static final String LOCAL_UPLOAD_FILE_FOLDER_PATH = "C:/Users/Asus/Desktop/SPM/WE_47/complexity_measuring_tool/WebContent/uploaded-files/";
	public static final String REGEX_FOR_LOOP = "^for([(a-zA-Z]+)\\s([(a-zA-Z]+)=([0-9]+);([(a-zA-Z)]+)(<|>|<=|>=)([0-9]+);([(a-zA-Z)]+)((\\++)|(\\--))\\)\\{";
	public static final String REGEX_FOR_EACH = "^for([(a-zA-Z]+)\\s([(a-zA-Z]+)\\s:\\s([(a-zA-Z)]+)\\{$";
	public static final String REGEX_WHILE_LOOP = "^while\\(([()0-9a-zA-Z]+)[<>+!]([()0-9a-zA-Z]+)\\)\\{$";
	public static final String REGEX_IF = "^if\\(([()0-9a-zA-Z]+)[<>=+!&|]+([()0-9a-zA-Z]+)\\)\\{$";
	public static final String REGEX_SWITCH = "^switch\\(([0-9a-zA-Z]+)\\)\\{$";
	public static final String REGEX_ELSE = "^\\}else\\{$";
	public static final String REGEX_METHOD_SIGNATURE=  "^([_0-9a-zA-Z()]+)\\{";
	public static final String LOG_FILE_PATH = "C:/COMPLEXITY/LOG/complexity.log";
}
