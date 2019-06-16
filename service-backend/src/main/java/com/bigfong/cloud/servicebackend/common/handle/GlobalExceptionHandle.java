package com.bigfong.cloud.servicebackend.common.handle;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.common.utils.HttpUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简单处理全局异常信息
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ResponseMsg exception(Exception e) {
        e.printStackTrace();
        return new ResponseMsg(Code.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public Object handleAuthorizationException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        if (HttpUtil.isAjaxRequest(request)) {
            return new ResponseMsg(Code.PERMISSION_ERROR);
        } else {
            ModelAndView view = new ModelAndView();
            view.setViewName("error/403");
            return view;
        }
    }

    @ExceptionHandler(value = GlobalException.class)
    public ResponseMsg globalExceptionHandle(GlobalException e, HttpServletResponse response) {
        e.printStackTrace();
        return new ResponseMsg(e.getCode(), e.getMsg());
    }
}