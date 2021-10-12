package com.example.checkcompounds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ShowDBAdapter extends RecyclerView.Adapter<ShowDBAdapter.ViewHolder>{
    public final LayoutInflater inflater;
    private List<GoodOZON> goodOzonList;
    private List<GoodAVITO> goodAVITOList;
    private int selectedSpinnerID;

    ShowDBAdapter(Context context, int selectedSpinnerID){
        this.selectedSpinnerID = selectedSpinnerID;
        this.goodAVITOList = MainActivity.goodAVITOArrayList;
        this.goodOzonList = MainActivity.goodOZONArrayList;

        /*
        switch (selectedSpinnerID){
   //         case 0: this.goodShopList = MainActivity.goodOZONArrayList; break;
            case 1: this.goodAVITOList = MainActivity.goodAVITOArrayList; break;
            default: this.goodOzonList = MainActivity.goodOZONArrayList;
        }
         */

        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_list_showgood, viewGroup, false);
        return new ShowDBAdapter.ViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (selectedSpinnerID){
            case 0: {
                GoodOZON goodOZON =goodOzonList.get(position);
                holder.titleView.setText(goodOZON.getTitle());
                holder.brandView.setText(goodOZON.getBrand());
                holder.currPriceView.setText(String.valueOf(goodOZON.getPrice()));
                break;
            }

            case 1: {
                GoodAVITO goodAVITO = goodAVITOList.get(position);
                holder.titleView.setText(goodAVITO.getTitle());
                holder.brandView.setText(goodAVITO.getBrand());
                holder.currPriceView.setText(String.valueOf(goodAVITO.getPrice()));
                break;
            }

            default: {
                GoodOZON goodOZON = goodOzonList.get(position);
                holder.titleView.setText(goodOZON.getTitle());
                holder.brandView.setText(goodOZON.getBrand());
                holder.currPriceView.setText(String.valueOf(goodOZON.getPrice()));
            }
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView titleView;
        final TextView brandView;
        final TextView currPriceView;
        ViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.textView_title);
            brandView = (TextView) view.findViewById(R.id.textView_brand);
            currPriceView= (TextView) view.findViewById(R.id.textView_currPrice);
        }

    }

}
