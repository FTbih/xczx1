package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

public class CustomException extends RuntimeException{

    private ResultCode resultCode;

    //构造方法
    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    //获取错误代码的方法
    public ResultCode getResultCode(){
        return this.resultCode;
    }

}
