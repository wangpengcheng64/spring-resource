package com.wpc.config.editor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalControllerAdvice {
    /**
     * 初始化绑定操作【全局形式】
     * @ControllerAdvice(对controller请求进行处理操作(@ReuqestMapping))+@InitBinder(自定义绑定操作)+WebDataBinder(web数据绑定对象)
     */
    @InitBinder
    public void dataBind(WebDataBinder binder){
        //注册自定义转换类型
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat));
    }
}
