package com.psato.foundation.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by psato on 29/10/16.
 */

public class ShowIds implements Serializable {
    @SerializedName("trakt")
    private String mTrakt;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("tvdb")
    private String mTvdb;
    @SerializedName("imdb")
    private String mImdb;
    @SerializedName("tmdb")
    private String mTmdb;
    @SerializedName("tvrage")
    private String mTvrage;

    public String getTrakt() {
        return mTrakt;
    }
}
