package com.example.common.exception.ReturnInfo;

import com.example.vo.AjaxResult;

/*返回信息体组织*/

public class ResultEntity {
	
	public static AjaxResult fail(String message) {
		AjaxResult ajaxResult  = new AjaxResult ();
		ajaxResult.setStatus(-1);
		ajaxResult.setStatusText(message);
		return ajaxResult;
	}
}
