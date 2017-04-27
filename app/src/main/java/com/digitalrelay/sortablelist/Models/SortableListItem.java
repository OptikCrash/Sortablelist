package com.digitalrelay.sortablelist.Models;

/**
 * Created by Chris on 4/26/17.
 */

public class SortableListItem {
    private String TITLE;

    public String getTitle() {
        return TITLE;
    }

    public void setTitle(String title) {
        this.TITLE = title;
    }

    public SortableListItem() {
        super();
    }

    public SortableListItem(String title) {
        super();
        this.setTitle(title);
    }
}
