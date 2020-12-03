package org.my.skeleton.client.common;

import lombok.Data;

@Data
public class Response<T> {

	protected Integer code;
	protected String errMsg;
	protected T data;

	public Response() {
	}

	public Response(Integer code, String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}

	public static <T> Response<T> success(T data){
		Response  response = new Response();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(data);
		return response;
	}

}