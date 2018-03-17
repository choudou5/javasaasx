package com.choudou5.javasaasx.web.handler;

import com.alibaba.fastjson.JSONObject;
import com.choudou5.base.bean.ResponseData;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.exception.SysException;
import com.choudou5.javasaasx.base.constant.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Name：处理Api全局异常
 * @Author：xuhaowen
 * @Date：2018-03-17
 * To Use : add xml config <bean id="handlerExceptionResolver" class="com.choudou5.javasaasx.web.handler.ApiExceptionHandler" />
 */
public class ApiExceptionHandler implements HandlerExceptionResolver {

    private final static Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    private static final String DUBBO_RPC_EXCEPTION = "com.alibaba.dubbo.rpc.RpcException";

    /** 处理内部异常, 也就是未被其他异常方法处理的异常 */
    private ResponseData<String> handleExceptionInternal(Exception ex ) {
        return processResponseData( ErrorCodes.INTERNAL_EXCEPTION, "internal error",ex );
    }

    private ResponseData<String> handleMissingServletRequestPart(
            MissingServletRequestPartException ex ) {
        return processResponseData( ErrorCodes.MISSING_PATH_VARIABL_EEXCEPTION, "miss request part" );
    }

    private ResponseData<String> handleBindException(BindException ex ) {
        return processResponseData( ErrorCodes.BIND_EXCEPTION, "bind error" );
    }

    private ResponseData<String> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex ) {
        return processResponseData( ErrorCodes.METHOD_ARGUMENT_NOTVALID_EXCEPTION, "method argument not valid" );
    }

    private ResponseData<String> handleHttpMessageNotWritable(
            HttpMessageNotWritableException ex ) {
        return processResponseData( ErrorCodes.HTTP_MESSAGE_NOTWRITABLE_EXCEPTION, "message is not writable" );
    }

    private ResponseData<String> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex ) {
        return processResponseData( ErrorCodes.HTTP_MESSAGE_NOTREADABLE_EXCEPTION, "message is not readable" );
    }

    /**
     * 参数类型不匹配
     */
    private ResponseData<String> handleTypeMismatch(TypeMismatchException ex ) {
        return processResponseData( ErrorCodes.TYPEM_ISMATCH_EXCEPTION, "type mismatch" );
    }

    /**
     * 参数转换失败
     */
    private ResponseData<String> handleConversionNotSupported(
            ConversionNotSupportedException ex ) {
        return processResponseData( ErrorCodes.CONVERSION_NOTSUPPORTED_EXCEPTION, "conversion not supported" );
    }

    /**
     * 参数绑定失败
     */
    private ResponseData<String> handleServletRequestBindingException(
            ServletRequestBindingException ex ) {
        return processResponseData( ErrorCodes.SERVLETREQUEST_BINDING_EXCEPTION, "request bind error" );
    }

    /**
     * 缺少请求参数
     */
    private ResponseData<String> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex ) {
        return processResponseData( ErrorCodes.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION, "missing request params" );
    }

    /**
     * 响应的类型不匹配
     */
    private ResponseData<String> handleHttpMediaTypeNotAcceptable(
            HttpMediaTypeNotAcceptableException ex ) {
        return processResponseData( ErrorCodes.HTTP_MEDIATYPE_NOTACCEPTABLE_EXCEPTION, "media type not acceptable" );
    }

    /**
     * 请求的类型不存在
     */
    private ResponseData<String> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex ) {
        return processResponseData( ErrorCodes.HTTP_MEDIATYPE_NOTSUPPORTED_EXCEPTION, "media type not support" );
    }

    /**
     * 请求的方法不支持
     */
    private ResponseData<String> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex ) {
        return processResponseData( ErrorCodes.HTTPREQUEST_METHOD_NOTSUPPORTED_EXCEPTION, "method not support" );
    }

    /**
     * 请求的方法不存在
     */
    private ResponseData<String> handleNoSuchRequestHandlingMethod(
            NoSuchRequestHandlingMethodException ex ) {
        return processResponseData( ErrorCodes.NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION, "no handler" );
    }

    /**
     * 处理自定义异常
     */
    private ResponseData<String> handlBizException(BizException ex ) {
        Integer errorCodes = ErrorCodes.INTERNAL_EXCEPTION;
        if(ex.getErrorCode() != null && ex.getErrorCode().intValue()>0){
            errorCodes = ex.getErrorCode();
        }
        return processResponseData( errorCodes, ex.getMessage(),ex );
    }

    /**
     * 处理自定义异常
     */
    private ResponseData<String> handlSysException(SysException ex ) {
        Integer errorCodes = ErrorCodes.INTERNAL_EXCEPTION;
        if(ex.getErrorCode() != null && ex.getErrorCode().intValue()>0){
            errorCodes = ex.getErrorCode();
        }
        return processResponseData( errorCodes, ex.getMessage(),ex );
    }

    /**
     * 处理DUBBO RPC异常
     */
    private ResponseData<String> handlDubboRpcException(Exception ex ) {
        return processResponseData( ErrorCodes.INTERNAL_DUBBO_EXCEPTION, "网络异常",ex );
    }

    /**
     * 处理SQL异常
     */
    private ResponseData<String> handlDubboRpcException(BadSqlGrammarException ex ) {
        return processResponseData( ErrorCodes.INTERNAL_SQL_EXCEPTION, "内部错误",ex );
    }


    /**
     * 统一输出格式
     *
     * @param errorCode - @see com.ttwg.commons.constants.ErrorCodes
     * @param message - 消息
     * @return - ResponseData<String>
     */
    private static ResponseData<String> processResponseData(Integer errorCode, String message ) {
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setMessage( message == null ? "" : message );
        responseData.setStatusCode(errorCode);
        return responseData;
    }

    /**
     * 统一输出格式
     *
     * @param errorCode - @see com.ttwg.commons.constants.ErrorCodes
     * @param message - 消息
     * @return - ResponseData<String>
     */
    private ResponseData<String> processResponseData(Integer errorCode, String message , Throwable t) {
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setMessage( message == null ? "" : message );
        responseData.setStatusCode(errorCode );
        log.error(message,t);
        return responseData;
    }

    /*
     * 重写异常处理, 覆盖spring的所有异常处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) {
        ResponseData<String> responseData = null;
        if( ex instanceof NoSuchRequestHandlingMethodException) {
            responseData = handleNoSuchRequestHandlingMethod( (NoSuchRequestHandlingMethodException)ex );
        } else if( ex instanceof HttpRequestMethodNotSupportedException ) {
            responseData = handleHttpRequestMethodNotSupported( ( HttpRequestMethodNotSupportedException )ex );
        } else if( ex instanceof HttpMediaTypeNotSupportedException ) {
            responseData = handleHttpMediaTypeNotSupported( ( HttpMediaTypeNotSupportedException )ex );
        } else if( ex instanceof HttpMediaTypeNotAcceptableException ) {
            responseData = handleHttpMediaTypeNotAcceptable( ( HttpMediaTypeNotAcceptableException )ex );
        } else if( ex instanceof MissingServletRequestParameterException ) {
            responseData = handleMissingServletRequestParameter( ( MissingServletRequestParameterException )ex );
        } else if( ex instanceof ServletRequestBindingException ) {
            responseData = handleServletRequestBindingException( ( ServletRequestBindingException )ex );
        } else if( ex instanceof ConversionNotSupportedException ) {
            responseData = handleConversionNotSupported( ( ConversionNotSupportedException )ex );
        } else if( ex instanceof TypeMismatchException ) {
            responseData = handleTypeMismatch( ( TypeMismatchException )ex );
        } else if( ex instanceof HttpMessageNotReadableException ) {
            responseData = handleHttpMessageNotReadable( ( HttpMessageNotReadableException )ex );
        } else if( ex instanceof HttpMessageNotWritableException ) {
            responseData = handleHttpMessageNotWritable( ( HttpMessageNotWritableException )ex );
        } else if( ex instanceof MethodArgumentNotValidException ) {
            responseData = handleMethodArgumentNotValid( ( MethodArgumentNotValidException )ex );
        } else if( ex instanceof MissingServletRequestPartException ) {
            responseData = handleMissingServletRequestPart( ( MissingServletRequestPartException )ex );
        } else if( ex instanceof BindException ) {
            responseData = handleBindException( ( BindException )ex );
        } else if( ex instanceof BizException) {
            responseData = handlBizException( ( BizException )ex );
        }  else if (ex instanceof SysException) {
            responseData = handlSysException((SysException) ex);
        }else if( ex instanceof BadSqlGrammarException){
            responseData = handlDubboRpcException(ex);
        }else if(DUBBO_RPC_EXCEPTION.equals(ex.getClass().getName())){
            responseData = handlDubboRpcException(ex);
        }else{
            responseData = handleExceptionInternal( ex );
        }
        // 以JSON格式输出
        response.setContentType( MediaType.APPLICATION_JSON_VALUE );
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.write( JSONObject.toJSONString( responseData ) );
            out.flush();
        } catch( IOException e ) {
            // TODO 出现致命错误
            // log.error( "ExceptionHandlerController write message error", e );
        }
        return null;
    }

}