import java.util.regex.Matcher;
import java.util.regex.Pattern;

//������ʽ
public class Test_RE {

	public static void main(String[] args) {
		
		//System.out.println("aBc".matches("...") );  //ÿ����.������һ���ַ�
		
		//����ʶ������ʽ�ĸ���
				
		/*p("abc".matches("..."));
		p("a8729a".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");  //compile ���롣����������ʽ��������Pattern���ַ�����Ҫƥ��ģ�ģʽ��
		Matcher m = p.matcher("fgh");  //Matcher��ƥ����  ��Ҫ����һ��CharSequence���ͣ���Stringʵ����CharSequence �ӿڣ���̬
									   //�����������Mather���� m �������ж�����
		p(m.matches());
		p("fgha".matches("[a-z]{3}"));  //�������������Ժϳ�һ����䣬����Ч�ʻ�ͣ����Ҳ�������չ
		*/
		
		
		//������ʶ. * + ?  ����MetaCharacters Ԫ�ַ���Greedy ������ 
		/*//X* ����X������λ��Σ�
		//X+ ����X����һ�λ��Σ� 
		//X? ����X����һ�λ���� 
		 * 
		p("a".matches("."));  //TRUE
		p("aa".matches("aa"));  //true
		p("aaaa".matches("a*"));  //true
		p("aaaa".matches("a+"));  //true
		p("".matches("a*"));  //true
		p("aaaa".matches("a?"));  //false
		p("".matches("a?"));  //true
		p("a".matches("a?"));  //true
		p("214523145234532".matches("\\d{3,100}"));  //3��100λ�����֡�X{n,m} ��ʾ����nλ���֣����mλ����
		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));  //��\\.�� ��ʾ��.��
		p("192".matches("[0-2][0-9][0-9]"));  //һλһλ���
*/		
		
		//��Χ   []ƥ��һ���ַ�
		
		/*p("a".matches("[abc]"));  //a��b��c  ƥ��һ���ַ�
		p("a".matches("[^abc]"));  //��a��b��c�����������ĸ
		p("A".matches("[a-zA-Z]"));  //a-z��A-Z
		p("A".matches("[a-z]|[A-Z]"));  //Ҫô��a-z��Ҫô��A-Z
		p("A".matches("[a-z[A-Z]]"));  //a-z��A-Z
		p("R".matches("[A-Z&&[RFG]]"));  //ȡ������A-Z֮�� ������ R��F��G֮�е�һ��  
		*/
		
		//��ʶ\s \w \d \
		
		/*p(" \n\r\t".matches("\\s{4}"));  // ��\s����ʾ�հ��ַ����ո񡢻��С��س���tab
		p(" ".matches("\\S"));  // "\S"�ǿհ��ַ�
		p("a_8".matches("\\w{3}"));  //��\w����ʾ���ɵ��ʵ��ַ�������a-z��A-Z��0-9����_��
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));  // a-z����ĸ����1��3�Σ����ֳ���1�λ��Σ����߳���һ�λ���
		p("\\".matches("\\\\"));  //ƥ��һ����б��
		*/
		
		//POSIX Style  POSIX��unixϵͳ��һ�ױ�׼
		//p("a".matches("\\p{Lower}"));
		
		//boundary �߽���  ��ͷ�ͽ�β
		
		/*p("hello sir".matches("^h.*"));  //��h��ͷ���������������ַ�
		p("hello sir".matches(".*ir$"));
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		//white lines  �հ���
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));  //TODO �Կհ��ַ��Ҳ��ǻ��з���ͷ��������λ��Σ��Ի��з���β
		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}.")); //���ʱ߽��Կհ��ַ���β
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa8888c".matches(".*\\b\\d{4}."));
		*/
		
		
		//email ��ϰ
		//p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));  //��Ƶ
		//p("asdfasdfsafsf@dsdfsdf.com".matches(".+@.+\\.com"));  //�Լ�
		
		//matches find lookingAt
		
		/*Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);  //��������-��ʱ�����ֲ�ƥ�䣬��Ϊ����������
		
		//matches()ƥ�������ַ���
		p(m.matches());  
		//��֮ǰƥ������ַ����·Ż�ȥ���´�ƥ�����ҵ�
		m.reset();
		//�ҵ���һ����ģʽƥ����Ӵ�
		p(m.find());  
		p(m.start() + "-" + m.end());  //�������reset(),�����ӵ�����ַ���ʼ�ң�����֮�󣬻���ͷ��
		//�ҵ�ʣ�µ��ַ�����ڶ�����ģʽƥ����Ӵ�
		p(m.find());  
		p(m.start() + "-" + m.end());  //start()��m.end()���ص����±꣬���㿪ʼ
		
		p(m.find());
		p(m.start() + "-" + m.end());
		
		p(m.find());
		//p(m.start() + "-" + m.end());
		
		p(m.lookingAt());  //������������ģʽƥ�䣬ÿ�ζ�������Ŀ�ͷ��ʼ��
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		*/
		
		//replacement 
		//**********************TODO ����滻����*******************
		/*Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);  //�����ִ�Сд��ƥ��
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) {
				m.appendReplacement(buf, "java");  //���滻�Ľ���ŵ�buf����
			} else {
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);  //��β�����ַ����ŵ�buf��
		p(buf);*/
		
		
		//*********************TODO ����  �ܳ���***********************
		//group
		
		/*Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");  //�ֳ�������(����С����)��3��5λ���֣�2��a-z����ĸ
															  //�ϸ����������飬����������ʽ��һ��
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());   //ȫ����ӡ
			p(m.group(1));  //ֻ��ӡ����
			p(m.group(2));  //ֻ��ӡ��ĸ
		}*/
		
		
		
		//qualifiers  //�޶��ʡ����δ�/��
		
		/*Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			p(m.start() + "-" + m.end());
		else 
			p("not match!");
		*/
		
		//TODO��non-capturing groups
		
		/*Pattern p = Pattern.compile("(?=a).{3}");  //(?=a).{3} ���a66
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}
		*/
		
		//TODO back refenrences  ��ǰ����
		
		Pattern p = Pattern.compile("(\\d(\\d))\\2");  //���������飬��\2����ʾ��ƥ����ַ����ĺ�����ַ���Ҫ��ڶ�����һ��
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		
		
		//TODO flags�ļ�д
		//Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);  //�����ִ�Сд
		p("Java".matches("(?i)(java)"));  //����д���ļ�д
				
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}

}
