import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringEscapeUtils;


public class testurlencode {

	
	 public final static void main(String[] args) throws UnsupportedEncodingException {
	 
		 String name=java.net.URLEncoder.encode("chirag&ghag", "UTF-8");
		 System.out.println(name);
		 
		 
		 String unescaped = StringEscapeUtils.unescapeXml("S12.ACP – # RG & Project $ ");
		 System.out.println(unescaped);
		 String out = new String("S12.ACP – # RG &amp; Project $ ".getBytes("ISO-8859-1"), "UTF-8");
		 System.out.println(out);
	 }
}
