package com.example.web.exception;

import com.example.web.Response;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuanweipeng
 * @date 2018-01-18
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理 todo 测试
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    Response<String> jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        Response<String> response = new Response<>();
        response.setCode(500);
        response.setMessage(e.getMessage());
        response.setData(request.getRequestURL().toString());
        return response;
    }

    @ModelAttribute
    public void addAtrributes(Model model) {
        model.addAttribute("msg", "额外信息");

    }
}
