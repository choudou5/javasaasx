package com.choudou5.javasaasx.framework.exception;

/**
 * @Name：业务异常
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 15:33
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 6362782762086492531L;

    private Integer errorCode;

    private String message;

    private Throwable throwable;

    public BizException() {
        super();
    }

    public BizException( String message ) {
        super();
        this.message = message;
    }

    public BizException( int errorCode, Throwable throwable ) {
        super();
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public BizException( String message, Throwable throwable ) {
        super();
        this.message = message;
        this.throwable = throwable;
    }

    public BizException(int errorCode,String message){
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode( Integer errorCode ) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable( Throwable throwable ) {
        this.throwable = throwable;
    }

}