package com.digitalrelay.sortablelist.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digitalrelay.sortablelist.Listeners.TouchList;
import com.digitalrelay.sortablelist.Models.SortableListItem;
import com.digitalrelay.sortablelist.R;

import java.util.ArrayList;

/**
 * Created by Chris on 4/26/17.
 */

public class SortableAdapter extends RecyclerViewArrayAdapter<SortableListItem, SortableAdapter.SortRow> implements View.OnClickListener {
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(final OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public SortableAdapter.SortRow onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);
        final View view = inflator.inflate(R.layout.listrow, parent, false);

        return new SortRow(view);
    }

    @Override
    public void onBindViewHolder(SortRow holder, SortableListItem item) {
        holder.bindData(item);
    }

    @Override
    public void onClick(final View view) {
        if (this.onItemClickListener != null) {
            final TouchList touchList = (TouchList) view.getParent();
            final int position = touchList.getChildLayoutPosition(view);
            if (position != TouchList.NO_POSITION) {
                final SortableListItem item = this.getItem(position);
                this.onItemClickListener.onItemClicked(item);
            }
        }
    }

    public SortableAdapter(final Context context) {
        super();
        this.items = new ArrayList<SortableListItem>();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static class SortRow extends RecyclerView.ViewHolder {
        TextView title;

        public SortRow(final View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }

        public void bindData(final SortableListItem item) {
            this.title.setText(item.getTitle());
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public interface OnItemClickListener {
        void onItemClicked(SortableListItem item);
    }

}
