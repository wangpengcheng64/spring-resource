package com.wpc.controller;

import com.wpc.bean.User;
import com.wpc.config.editor.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/editor")
public class EditorController {

    // 只在当前Controller生效，全局设置GlobalControllerAdvice
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //binder.setDisallowedFields("name"); // 不绑定name属性
        binder.registerCustomEditor(String.class, new StringTrimmerEditor());
    }

    @ResponseBody
    @GetMapping("/test")
    public String testInitBinder(String str, Date date) {
        return str + ":" + date;
    }

    @ResponseBody
    @GetMapping("/model")
    public String testInitBinder(@ModelAttribute User user) {
        return user.toString();
    }

}
