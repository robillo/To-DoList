package com.appbusters.robinkamboj.to_dolist;

/**
 * Created by robinkamboj on 03/12/16.
 */

public class Comment {

    private  long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Will be used by the RecyclerViewAdapter in the RecyclerView

    @Override
    public String toString() {
        return comment;
    }
}
