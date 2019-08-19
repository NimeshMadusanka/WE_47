package complexity_measuring_tool.service;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.util.CommonParams;

public class ComplexityInheritance {
	
	private static int complexityInheritanceValue=0;
	
	public static int calculateCi(CheckFile checkFile) {
		System.out.println(checkFile.getDate());

		for (String line : checkFile.getFileLines()) {
			line.trim();// removing spaces
			if(line.contains("class ") || line.contains("interface ") ) {
				complexityInheritanceValue+=2;
				
				if(line.contains("implements ")) {
					String[] splitted= line.split("implements ");
					String keyWordAfterString=splitted[CommonParams.ARRAY_SECOND_ELEMENT];
					String[] beforCurly = keyWordAfterString.split("\\{");
					String[] implementedSuper = beforCurly[CommonParams.ARRAY_FIRST_ELEMENT].split(",");
					for (int i = 0; i < implementedSuper.length; i++) {
						System.out.println(implementedSuper[i].trim());
						complexityInheritanceValue+=1;
					}
				}
				if(line.contains("extends ")) {
					complexityInheritanceValue +=1;
				}
				break;
			}
		}
		return complexityInheritanceValue;
	}
	
	public static void resetCIValue() {
		complexityInheritanceValue = 0;
	}

}
