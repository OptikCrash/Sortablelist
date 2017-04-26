package com.digitalrelay.sortablelist.Adapters;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 4/13/17.
 */

public abstract class RecyclerViewArrayAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<T> items;

    public void bindData(final List<T> items)
    {
        this.items = items;
        this.notifyDataSetChanged();
    }

    public final T getItem(final int position)
    {
        return this.items.get(position);
    }

    public List<T> getItems()
    {
        return items;
    }

    public void add(T item) {
        if (items == null) {
            items = new ArrayList<T>();
        }
        items.add(item);
        this.notifyItemChanged(getItemCount());
    }

    public void clear() {
        if (getItemCount() > 0) {
            int initialCount = getItemCount();
            for (int i = 0; i < initialCount; i++) {
                items.remove(getItemCount() -1);
                this.notifyItemChanged(i);
            }
        }
    }

    public boolean isEmpty() { return items.isEmpty(); }

    @Override
    public int getItemCount()
    {
        return (this.items != null) ? this.items.size() : 0;
    }

    @Override
    public final void onBindViewHolder(final VH holder, final int position)
    {
        final T item = this.items.get(position);
        this.onBindViewHolder(holder, item);
    }

    public abstract void onBindViewHolder(final VH holder, final T item);
}
