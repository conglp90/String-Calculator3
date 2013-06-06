import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;


public class Calculator {
	public int add(String input0) {
		int kq=0;
		String error="negatives not allowed:";
		boolean flag_negatives = false;
		if(input0==null||input0.isEmpty())
			return 0;
		// TODO Auto-generated method stub
		if(input0.contains("//")){
			String delimiters= input0.substring(input0.indexOf("["),input0.lastIndexOf("]")+1);
			while (delimiters.contains("]")) {
				String delimiter= delimiters.substring(delimiters.indexOf("[")+1,delimiters.indexOf("]"));
				input0=input0.substring(input0.indexOf("\n")+1);
				input0=input0.replaceAll(java.util.regex.Pattern.quote(delimiter),",");
				delimiters=delimiters.substring(delimiters.indexOf("]")+1);
			}
		}
		if(input0.contains("\n"))
			input0=input0.replaceAll("\n",",");
		while (true) {
			if(input0.contains(",")){
				String tempElement= input0.substring(0, input0.indexOf(","));
				input0=input0.substring(input0.indexOf(",")+1);
				kq+=Integer.parseInt(tempElement)%1000;
				if(Integer.parseInt(tempElement)<0){
					if (flag_negatives) {
						error += ", "+Integer.parseInt(tempElement);
					} else {
						error += " "+Integer.parseInt(tempElement);
					}
					flag_negatives=true;
				}
				continue;
			}
			kq+=Integer.parseInt(input0)%1000;
			if(Integer.parseInt(input0)<0){
				if (flag_negatives) {
					error += ", "+Integer.parseInt(input0);
				} else {
					error += " "+Integer.parseInt(input0);
				}
				flag_negatives=true;
			}
			if (flag_negatives) 
				throw new RuntimeException(error);
			break;
		}
		return kq;
	}

}
