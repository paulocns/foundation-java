package com.psato.foundation.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by psato on 29/10/16.
 */

public class Show implements Serializable{

    @SerializedName("title")
    private String mTitle;
    @SerializedName("year")
    private Integer mYear;
    @SerializedName("ids")
    private ShowIds mIds;
    @SerializedName("overview")
    private String mOverview;


    public String getTitle() {
        return mTitle;
    }

    public Integer getYear() {
        return mYear;
    }

    public ShowIds getIds() {
        return mIds;
    }

    public String getOverview() {
        return mOverview;
    }
}
