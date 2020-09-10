package com.wpc.config.editor;

import com.sun.istack.internal.Nullable;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class CustomDateEditor extends PropertyEditorSupport {
    private DateFormat dateFormat;

    public CustomDateEditor(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void setAsText(@Nullable String text) {
        try {
            setValue(this.dateFormat.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? this.dateFormat.format(value) : "");
    }
}
