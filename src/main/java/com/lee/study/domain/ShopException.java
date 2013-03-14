package com.lee.study.domain;

public class ShopException extends RuntimeException{

	private static final long serialVersionUID = 6612433648060101357L;

	public ShopException(){
		super();
	}
	
	public ShopException(String message,Throwable e){
		super(message,e);
	}
	
	public ShopException(String message){
		super(message);
	}
	
	public ShopException(Throwable e){
		super(e);
	}
}
