import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����һ�δ����ж��ٸ����С�ע���С�������. ���򵥵ķ�������String���startsWith()��endsWith()����
//�������еĴ���������

public class Practice_LineCount {
	
	private static int count = 0;
	private static int count1 = 0;
	private static int count2 = 0;
	private static int count3 = 0;
	static boolean note = false;
	
	public static void main(String[] args) {
		
		//һ���ļ����µ����� .java�ļ�
		File f = new File("D:\\eclipse-workspace\\About-1-RegularExpression\\src\\Practice_LineCount.java");
		//File codeFiles[] = f.listFiles();
		//for(File child : codeFiles) {  //��ǿ��forѭ��  �����¡�Collection��������
			Pattern p = Pattern.compile(".*java$",Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(f.getName());
			if(m.matches()) {
				parse(f);
			}
		//}
		System.out.println("�հ�����" + count1 + "��");
		System.out.println("ע������" + count2 + "��");
		System.out.println("��������" + (count-count1-count2) + "��");
	}
	
	private static void parse(File child) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(child));
			String line = null;
			while((line = br.readLine())!=null) {
				//������
				whiteLine(line);
				//��ע����
				noteLine(line);
				//��������
				codeLine(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//����
	private static void whiteLine(String line) {
		
		Pattern p = Pattern.compile("^[\\s&&[^\\n]]*$");  //����"^[\\s&&[^\\n]]*\\n$" ����ΪreadLine()��ȥ���ַ�����Ļ��з�
		Matcher m = p.matcher(line);
		while(m.find()) {
			count1 ++;
		}
	}
	
	//ע����
	private static void noteLine(String line) {
		
		//˫��б�ܵĵ���ע��
		//Pattern p1 = Pattern.compile("^[\\s&&[^\\n]]*//.*");
		/*Matcher m1 = p1.matcher(line);
		while(m1.find()) {
			count2 ++;
		}*/
		
		// /* */����ע��
		line = line.trim();  //String��trim()������ȥ��ÿ�����еĿո�
		if(line.startsWith("/*") && !line.endsWith("*/")) {  //����ע�Ϳ�ʼ
			count2 ++;
			note = true;
		}
		else if(true == note) {
			count2 ++;
			if(line.endsWith("*/")) {  //����ע�ͽ���
				note = false;
			}
		}
		else if(line.startsWith("/*") && line.endsWith("*/")) {  //�ö���ע�͵��﷨ע��һ��
			count2 ++;
		}
		else if(line.startsWith("//")) {  //˫б�ܵ���ע��
			count2 ++;
		}
	}
	
	//������
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
