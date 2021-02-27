package com.shahbatech.apiwrapper.model;

import com.google.gson.annotations.SerializedName;
import com.shahbatech.apiwrapper.json.JsonConstants;

public class NewsImage extends BaseModel{

    @SerializedName(value = JsonConstants.IMAGE)
    private String image;

    public String getImage() {
        return checkString(image);
    }
}
