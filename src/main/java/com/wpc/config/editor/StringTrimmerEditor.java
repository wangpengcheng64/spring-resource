package com.wpc.config.editor;

import java.beans.PropertyEditorSupport;

public class StringTrimmerEditor extends PropertyEditorSupport {

    // 将属性对象用一个字符串表示，以便外部的属性编辑器能以可视化的方式显示。缺省返回null，表示该属性不能以字符串表示
    //@Override
    //public String getAsText() {
    //    Object value = getValue();
    //    return (value != null ? value.toString() : null);
    //}

    // 用一个字符串去更新属性的内部值，这个字符串一般从外部属性编辑器传入
    // 处理请求的入参：test就是你传进来的值（并不是super.getValue()哦~）
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        text = text == null ? null : text.trim();
        setValue(text);
    }
}
