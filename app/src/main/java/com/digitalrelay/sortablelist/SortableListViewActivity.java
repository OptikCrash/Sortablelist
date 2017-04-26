package com.digitalrelay.sortablelist;

import android.app.ListActivity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.method.Touch;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.digitalrelay.sortablelist.Listeners.TouchInterceptor;

import java.util.Arrays;

public class SortableListViewActivity extends ListActivity {
//    public RecyclerView recyclerView;
    private TouchInterceptor list;
    private TouchInterceptor.DropListener dropListener = new TouchInterceptor.DropListener() {
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

            Object target = myArray[from];

            for (int i = loop_start; i != loop_end; i = i+direction) {
                myArray[i] = myArray[i + direction];
            }

            myArray[to] = target;
            System.out.println("Changed array is: " + Arrays.toString(myArray));
            ((BaseAdapter) list.getAdapter()).notifyDataSetChanged();
        }
    };

    private Object[] myArray = { "Item 0", "Item 1", "Item 2", "Item 3", "Item 4" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setUtilities();
        setAdapters();
        setListeners();

    }

    @Override
    protected void onListItemClick(ListView lv, View v, int position, long id) {
        String selection = myArray[position].toString();
        Snackbar.make(lv, selection, Snackbar.LENGTH_SHORT).show();
    }

    private void setViews() {
        list = (TouchInterceptor) getListView();
    }

    private void setUtilities() {

    }

    private void setAdapters() {
        ArrayAdapter adp = new ArrayAdapter(this, R.layout.listrow, myArray);
        setListAdapter(adp);
        list.setDropListener(dropListener);
    }

    private void setListeners() {
        registerForContextMenu(list);
    }

}
