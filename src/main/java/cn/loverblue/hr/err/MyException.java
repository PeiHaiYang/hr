package cn.loverblue.hr.err;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author PHY
 * @date 2020-09-29$-11:35
 */

@ControllerAdvice
public class MyException {
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public String runtimeException(RuntimeException e){
        e.printStackTrace();
        return "运行时报错异常";
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String writeException(Exception e){
        e.printStackTrace();
        return "报错异常";

    }
}
