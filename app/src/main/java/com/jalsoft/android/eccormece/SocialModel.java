package com.jalsoft.android.eccormece;

public class SocialModel {
    String postedTime,postedBy;

    public SocialModel(String postedTime, String postedBy) {
        this.postedTime = postedTime;
        this.postedBy = postedBy;
    }

    public String getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(String postedTime) {
        this.postedTime = postedTime;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
