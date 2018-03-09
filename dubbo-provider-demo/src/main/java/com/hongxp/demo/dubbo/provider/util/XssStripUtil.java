package com.hongxp.demo.dubbo.provider.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @date 2018-03-06
 * @desc 过滤些容易引起xss的字符
 */
public class XssStripUtil {
	/**
	 * 过滤些容易引起xss的字符
	 * @param value
	 * @return
	 */
	public static String stripXSS(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		List<Object[]> ret = new ArrayList<>();
		ret.add(new Object[]{"<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE});
        //ret.add(new Object[]{"<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
		ret.add(new Object[] {
		        "<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|"
		                + "ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|"
		                + "onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|"
		                + "onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|"
		                + "onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|"
		                + "onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|"
		                + "onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|"
		                + "onstop|onsubmit|onunload)+\\s*=+",
		        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        for(Object[] arr : ret) {
            String regex = (String)arr[0];
            Integer flag = (Integer)arr[1];
            value = Pattern.compile(regex, flag).matcher(value).replaceAll("");
        }
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        return value;  
    }  
	
	public static void main(String[] args) {
		String str = "<html>\n" +
				"<head>\n" + 
				"  <meta charset=\"UTF-8\">\n" + 
				"  <title>Swagger UI</title>\n" + 
				"  <link rel=\"icon\" type=\"image/png\" href=\"webjars/springfox-swagger-ui/images/favicon-16x16.png\" sizes=\"16x16\"/>\n" + 
				"  <link href='webjars/springfox-swagger-ui/css/typography.css' media='screen' rel='stylesheet' type='text/css'/>\n" + 
				"\n" + 
				"  <script src='webjars/springfox-swagger-ui/springfox.js' type='text/javascript'></script>\n" + 
				"</head>\n" + 
				"\n" + 
				"<body class=\"swagger-section\" onload=''>\n" + 
				"<div id='header' onclick='javascript:xxx'>\n" + 
				"  <div class=\"swagger-ui-wrap\">\n" + 
				"    <a id=\"logo\" href=\"http://swagger.io\"><img class=\"logo__img\" alt=\"swagger\" height=\"30\" width=\"30\" src=\"webjars/springfox-swagger-ui/images/logo_small.png\" /><span class=\"logo__title\">swagger</span></a>\n" + 
				"    <form id='api_selector'>\n" + 
				"      <div class='input'>\n" + 
				"        <select id=\"select_baseUrl\" name=\"select_baseUrl\"/>\n" + 
				"      </div>\n" + 
				"      <div class='input'><input placeholder=\"http://example.com/api\" id=\"input_baseUrl\" name=\"baseUrl\" type=\"text\"/></div>\n" + 
				"      <div id='auth_container'></div>\n" + 
				"      <div class='input'><a id=\"explore\" class=\"header__btn\" href=\"#\" data-sw-translate>Explore</a></div>\n" + 
				"    </form>\n" + 
				"  </div>\n" + 
				"</div>\n" + 
				"\n" + 
				"<div id=\"message-bar\" class=\"swagger-ui-wrap\" data-sw-translate>&nbsp;</div>\n" + 
				"<div id=\"swagger-ui-container\" class=\"swagger-ui-wrap\"></div>\n" + 
				"</body>\n" + 
				"</html>";
		System.out.println(stripXSS(str));
	}
}