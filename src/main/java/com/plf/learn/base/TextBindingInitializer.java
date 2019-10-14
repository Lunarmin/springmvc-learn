package com.plf.learn.base;

import java.beans.PropertyEditorSupport;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

/**
 * 全局处理，避免xxs攻击，还需要在springmvc配置bean
 * @author plf 2019年10月14日下午2:32:54
 *
 */
public class TextBindingInitializer implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder) {
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
