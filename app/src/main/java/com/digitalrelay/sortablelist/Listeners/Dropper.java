package com.digitalrelay.sortablelist.Listeners;

import com.digitalrelay.sortablelist.Adapters.SortableAdapter;
import com.digitalrelay.sortablelist.Models.SortableListItem;

import java.util.Arrays;

/**
 * Created by Chris on 4/27/17.
 */

public class Dropper implements TouchList.DropListener {
    private Object[] ARRAY;
    private SortableAdapter ADAPTER;
    @Override
    public void drop(int from, int to) {
        System.out.println("Droplisten from: " + from + " To: " + to);
        //  Assuming that the item is moved up the list
        int direction = -1;
        int loop_start = from;
        int loop_end = to;
        //  For instance where the item is dragged down the list
        if (from < to) {
            direction = 1;
        }

        Object target = ARRAY[from];

        for (int i = loop_start; i != loop_end; i = i + direction) {
            ARRAY[i] = ARRAY[i + direction];
        }

        ARRAY[to] = target;
        System.out.println("Changed array is: " + Arrays.toString(ARRAY));
        ADAPTER.clear();
        for(Object o : ARRAY) {
            ADAPTER.add(new SortableListItem(o.toString()));
        }
    }

    public Dropper(Object[] array, SortableAdapter adapter) {
        this.ARRAY = array;
        this.ADAPTER = adapter;
    }

}
