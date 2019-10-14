package com.plf.learn.base;

import java.beans.PropertyEditorSupport;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 继承该Controller，就可以避免XSS攻击
 * @author plf 2019年10月14日下午2:34:09
 *
 */
public abstract class BaseController {
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null :  StringEscapeUtils.escapeHtml4(text.trim()));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value == null ? "" : value.toString();
			}
		});
	}
}