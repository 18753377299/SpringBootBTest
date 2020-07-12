package com.example.vo;

import java.util.Map;

import lombok.Data;

@Data
public class AjaxResult {
	private long status;
	private String statusText;
	private Object data;
	private Map<String, Object> datas;
}
