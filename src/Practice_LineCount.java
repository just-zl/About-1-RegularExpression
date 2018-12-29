import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//数出一段代码有多少个空行、注释行、代码行. 更简单的方法是用String里的startsWith()和endsWith()方法
//数代码行的代码有问题

public class Practice_LineCount {
	
	private static int count = 0;
	private static int count1 = 0;
	private static int count2 = 0;
	private static int count3 = 0;
	static boolean note = false;
	
	public static void main(String[] args) {
		
		//一个文件夹下的所有 .java文件
		File f = new File("D:\\eclipse-workspace\\About-1-RegularExpression\\src\\Practice_LineCount.java");
		//File codeFiles[] = f.listFiles();
		//for(File child : codeFiles) {  //加强的for循环  第七章。Collection容器类里
			Pattern p = Pattern.compile(".*java$",Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(f.getName());
			if(m.matches()) {
				parse(f);
			}
		//}
		System.out.println("空白行有" + count1 + "行");
		System.out.println("注释行有" + count2 + "行");
		System.out.println("代码行有" + (count-count1-count2) + "行");
	}
	
	private static void parse(File child) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(child));
			String line = null;
			while((line = br.readLine())!=null) {
				//数空行
				whiteLine(line);
				//数注释行
				noteLine(line);
				//数代码行
				codeLine(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//空行
	private static void whiteLine(String line) {
		
		Pattern p = Pattern.compile("^[\\s&&[^\\n]]*$");  //不是"^[\\s&&[^\\n]]*\\n$" ，因为readLine()会去掉字符串后的换行符
		Matcher m = p.matcher(line);
		while(m.find()) {
			count1 ++;
		}
	}
	
	//注释行
	private static void noteLine(String line) {
		
		//双正斜杠的单行注释
		//Pattern p1 = Pattern.compile("^[\\s&&[^\\n]]*//.*");
		/*Matcher m1 = p1.matcher(line);
		while(m1.find()) {
			count2 ++;
		}*/
		
		// /* */多行注释
		line = line.trim();  //String的trim()方法，去除每行所有的空格？
		if(line.startsWith("/*") && !line.endsWith("*/")) {  //多行注释开始
			count2 ++;
			note = true;
		}
		else if(true == note) {
			count2 ++;
			if(line.endsWith("*/")) {  //多行注释结束
				note = false;
			}
		}
		else if(line.startsWith("/*") && line.endsWith("*/")) {  //用多行注释的语法注释一行
			count2 ++;
		}
		else if(line.startsWith("//")) {  //双斜杠单行注释
			count2 ++;
		}
	}
	
	//代码行
	private static void codeLine(String line) {
		
		/*line = line.trim();
		Pattern p = Pattern.compile("^[\\w{}]");
		Matcher m = p.matcher(line);
		while(m.find()) {
			count3 ++;
		}*/
		count ++;
	}

}
