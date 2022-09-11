package com.example.biomedtech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biomedtech.dexcomAPI.Egv;
import com.example.biomedtech.dexcomAPI.GlucoseLevel;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<GlucoseLevel> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ItemAdapter(List<GlucoseLevel> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_card, null);
        return new ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, hour, color1, color2;

        ViewHolder(View itemView){
            super(itemView);
            number = itemView.findViewById(R.id.number);
            hour = itemView.findViewById(R.id.hour);
            color1 = itemView.findViewById(R.id.color1);
            color2 = itemView.findViewById(R.id.color2);
        }

        void bindData(final GlucoseLevel item){
            number.setText(Long.toString(item.getEgvs().get(0).getValue()));
            hour.setText(Double.toString(item.getEgvs().get(0).getTrendRate()));
            color1.setBackgroundColor(1);
        }
    }
}
