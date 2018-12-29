import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式
public class Test_RE {

	public static void main(String[] args) {
		
		//System.out.println("aBc".matches("...") );  //每个“.”代表一个字符
		
		//简单认识正则表达式的概念
				
		/*p("abc".matches("..."));
		p("a8729a".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");  //compile 编译。将该正则表达式编译后放入Pattern（字符串需要匹配的）模式里
		Matcher m = p.matcher("fgh");  //Matcher叫匹配器  需要传入一个CharSequence类型，而String实现了CharSequence 接口，多态
									   //将结果保存在Mather对象 m 里。结果具有多样性
		p(m.matches());
		p("fgha".matches("[a-z]{3}"));  //上面三条语句可以合成一条语句，但是效率会低，而且不方便扩展
		*/
		
		
		//初步认识. * + ?  叫做MetaCharacters 元字符。Greedy 数量词 
		/*//X* 代表X出现零次或多次；
		//X+ 代表X出现一次或多次； 
		//X? 代表X出现一次或零次 
		 * 
		p("a".matches("."));  //TRUE
		p("aa".matches("aa"));  //true
		p("aaaa".matches("a*"));  //true
		p("aaaa".matches("a+"));  //true
		p("".matches("a*"));  //true
		p("aaaa".matches("a?"));  //false
		p("".matches("a?"));  //true
		p("a".matches("a?"));  //true
		p("214523145234532".matches("\\d{3,100}"));  //3到100位的数字。X{n,m} 表示最少n位数字，最多m位数字
		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));  //“\\.” 表示“.”
		p("192".matches("[0-2][0-9][0-9]"));  //一位一位检测
*/		
		
		//范围   []匹配一个字符
		
		/*p("a".matches("[abc]"));  //a或b或c  匹配一个字符
		p("a".matches("[^abc]"));  //除a、b、c以外的其他字母
		p("A".matches("[a-zA-Z]"));  //a-z或A-Z
		p("A".matches("[a-z]|[A-Z]"));  //要么是a-z，要么是A-Z
		p("A".matches("[a-z[A-Z]]"));  //a-z或A-Z
		p("R".matches("[A-Z&&[RFG]]"));  //取交集，A-Z之间 并且是 R、F、G之中的一个  
		*/
		
		//认识\s \w \d \
		
		/*p(" \n\r\t".matches("\\s{4}"));  // “\s”表示空白字符：空格、换行、回车、tab
		p(" ".matches("\\S"));  // "\S"非空白字符
		p("a_8".matches("\\w{3}"));  //“\w”表示构成单词的字符，包含a-z，A-Z，0-9，“_”
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));  // a-z的字母出现1到3次；数字出现1次或多次；四者出现一次或多次
		p("\\".matches("\\\\"));  //匹配一个反斜线
		*/
		
		//POSIX Style  POSIX是unix系统的一套标准
		//p("a".matches("\\p{Lower}"));
		
		//boundary 边界检测  开头和结尾
		
		/*p("hello sir".matches("^h.*"));  //以h开头，后面接零个或多个字符
		p("hello sir".matches(".*ir$"));
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		//white lines  空白行
		p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));  //TODO 以空白字符且不是换行符开头，出现零次或多次；以换行符结尾
		p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}.")); //单词边界以空白字符结尾
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa8888c".matches(".*\\b\\d{4}."));
		*/
		
		
		//email 练习
		//p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));  //视频
		//p("asdfasdfsafsf@dsdfsdf.com".matches(".+@.+\\.com"));  //自己
		
		//matches find lookingAt
		
		/*Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);  //分析到“-”时，发现不匹配，因为它不是数字
		
		//matches()匹配整个字符串
		p(m.matches());  
		//将之前匹配过的字符重新放回去，下次匹配能找到
		m.reset();
		//找到第一个和模式匹配的子串
		p(m.find());  
		p(m.start() + "-" + m.end());  //如果不用reset(),这里会从第五个字符开始找，用了之后，会重头找
		//找到剩下的字符串里，第二个和模式匹配的子串
		p(m.find());  
		p(m.start() + "-" + m.end());  //start()和m.end()返回的是下标，从零开始
		
		p(m.find());
		p(m.start() + "-" + m.end());
		
		p(m.find());
		//p(m.start() + "-" + m.end());
		
		p(m.lookingAt());  //将输入序列与模式匹配，每次都从区域的开头开始。
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());
		*/
		
		//replacement 
		//**********************TODO 灵活替换方法*******************
		/*Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);  //不区分大小写的匹配
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()) {
			i++;
			if(i%2 == 0) {
				m.appendReplacement(buf, "java");  //将替换的结果放到buf里面
			} else {
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);  //将尾部的字符串放到buf后
		p(buf);*/
		
		
		//*********************TODO 分组  很常用***********************
		//group
		
		/*Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");  //分成了两组(两对小括号)：3到5位数字；2个a-z的字母
															  //严格上有三个组，整个正则表达式算一组
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());   //全部打印
			p(m.group(1));  //只打印数字
			p(m.group(2));  //只打印字母
		}*/
		
		
		
		//qualifiers  //限定词、修饰词/符
		
		/*Pattern p = Pattern.compile(".{3,10}+[0-9]");
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			p(m.start() + "-" + m.end());
		else 
			p("not match!");
		*/
		
		//TODO　non-capturing groups
		
		/*Pattern p = Pattern.compile("(?=a).{3}");  //(?=a).{3} 输出a66
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			p(m.group());
		}
		*/
		
		//TODO back refenrences  向前引用
		
		Pattern p = Pattern.compile("(\\d(\\d))\\2");  //分了两个组，“\2”表示被匹配的字符串的后面的字符，要与第二个组一样
		String s = "122";
		Matcher m = p.matcher(s);
		p(m.matches());
		
		
		//TODO flags的简写
		//Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);  //不区分大小写
		p("Java".matches("(?i)(java)"));  //上种写法的简写
				
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}

}
