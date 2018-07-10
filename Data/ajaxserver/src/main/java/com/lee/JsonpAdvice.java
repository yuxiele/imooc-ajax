package com.lee;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**   
 * @ClassName:  JsonpAdvice   
 * @author: liqiuyu
 * @Description:TODO  
 * @date:   2018年7月5日 上午12:32:42   
 */  
@SuppressWarnings("deprecation")
@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{

	public JsonpAdvice() {
		super("callback2");
	}
	
}
