package com.plf.learn.base;

public class Msg {
	// 状态码 1 处理成功 0 处理失败
	private int code;
	// 提示信息
	private String msg;

	// 填入的数据
	private Object data;

	public Msg() {
		super();
	}

	public Msg(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static Msg message(int code, String msg, Object data) {
		return new Msg(code, msg, data);
	}

	public static Msg success(String msg, Object data) {
		return new Msg(1, msg, data);
	}

	public static Msg success(Object data) {
		return new Msg(1, "处理成功", data);
	}

	public static Msg success() {
		return new Msg(1, "处理成功", null);
	}

	public static Msg fail(String msg, Object data) {
		return new Msg(0, msg, data);
	}

	public static Msg fail(Object data) {
		return new Msg(0, "处理失败", data);
	}

	public static Msg fail() {
		return new Msg(0, "处理失败", null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
