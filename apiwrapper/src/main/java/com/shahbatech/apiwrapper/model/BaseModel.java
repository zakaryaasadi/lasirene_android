package com.shahbatech.apiwrapper.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.shahbatech.apiwrapper.json.JsonConstants;

import java.util.ArrayList;
import java.util.List;

public class BaseModel<T> {
    @SerializedName(value = JsonConstants.ID)
    private int id;

    public int getId() {
        return id;
    }


    protected String checkString(String str){
        if(!TextUtils.isEmpty(str))
            return str;

        return "";
    }

    protected List<T> checkList(List<T> list){
        if(list != null)
            return list;

        return new ArrayList<>();
    }
}
