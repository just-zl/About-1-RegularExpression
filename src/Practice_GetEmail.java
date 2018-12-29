import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//获取网页上的email地址

public class Practice_GetEmail {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\test\\getEmail\\test.html");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String s = br.readLine();
			while(s!=null) {
				getEmail(s);
				s = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getEmail(String s) {
		
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(s);  //一行行匹配
		while(m.find()) {  //如果找到则输出
			System.out.println(m.group());
		}
	}
}
