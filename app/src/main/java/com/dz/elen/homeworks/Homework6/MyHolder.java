package com.dz.elen.homeworks.Homework6;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dz.elen.homeworks.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameTxt;
    TextView mailTxt;
    ImageView imageView;

    CardView cardView;

    ItemClickListener itemClickListener;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.name);
        mailTxt = (TextView) itemView.findViewById(R.id.email);
        imageView = (ImageView) itemView.findViewById(R.id.image);

        cardView = (CardView) itemView.findViewById(R.id.card);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(getLayoutPosition());
    }
}
