package com.fullnesssboot2.text.exception;

/**
 * 演習-09 提供
 * @author Fullness,Inc.
 * @version 1.0
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg){
        super(msg);
    }
}
