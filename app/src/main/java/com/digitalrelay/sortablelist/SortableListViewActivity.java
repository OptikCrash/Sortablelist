package com.digitalrelay.sortablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.digitalrelay.sortablelist.Adapters.SortableAdapter;
import com.digitalrelay.sortablelist.Listeners.Dropper;
import com.digitalrelay.sortablelist.Listeners.TouchList;
import com.digitalrelay.sortablelist.Models.SortableListItem;

public class SortableListViewActivity extends AppCompatActivity {
    private Object[] myArray;
    private TouchList list;
    private SortableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        setUtilities();
        setAdapters();
        setListeners();

    }
//
//    @Override
//    protected void onListItemClick(ListView lv, View v, int position, long id) {
//        String selection = myArray[position].toString();
//        Snackbar.make(lv, selection, Snackbar.LENGTH_SHORT).show();
//    }

    private void setViews() {
        list = (TouchList) findViewById(R.id.touchlist);
        myArray = new Object[]{"Item 0", "Item 1", "Item 2", "Item 3", "Item 4"};
    }

    private void setUtilities() {

    }

    private void setAdapters() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        adapter = new SortableAdapter(SortableListViewActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setSmoothScrollbarEnabled(false);
        list.setAdapter(adapter);
        list.setLayoutManager(llm);
    }

    private void setListeners() {
        TouchList.DropListener dropListener = new Dropper(myArray, adapter);
        list.setDropListener(dropListener);
//        registerForContextMenu(list);
        for (Object o : myArray) {
            SortableListItem item = new SortableListItem(o.toString());
            SortableAdapter adapter = (SortableAdapter) list.getAdapter();
            adapter.add(item);
        }
    }
}
