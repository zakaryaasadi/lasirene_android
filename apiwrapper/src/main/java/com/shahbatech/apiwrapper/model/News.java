package com.shahbatech.apiwrapper.model;

import com.google.gson.annotations.SerializedName;
import com.shahbatech.apiwrapper.json.JsonConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class News extends BaseModel
{
    @SerializedName(value = JsonConstants.TEXT)
    private String text;

    @SerializedName(value = JsonConstants.DATE)
    private Date date;

    @SerializedName(value = JsonConstants.IMAGES)
    private List<NewsImage> images;


    public String getText() {
        return checkString(text);
    }

    public Date getDate() {
        return date;
    }

    public List<NewsImage> getImages() {
        return checkList(images);
    }
}
