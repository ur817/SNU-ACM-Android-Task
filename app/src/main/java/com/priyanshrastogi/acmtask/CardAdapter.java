package com.priyanshrastogi.acmtask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {

    private List<Card> cardList;
    Context context;

    public CardAdapter(Context context, List<Card> cardList) {
        this.cardList = cardList;
        this.context = context;
    }

    @Override
    public CardAdapter.CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View mView = layoutInflater.inflate(R.layout.card_layout,parent,false);
        return new CardHolder(mView);
    }

    @Override
    public void onBindViewHolder(CardAdapter.CardHolder holder, int position) {
        Card card = cardList.get(position);
        holder.t1.setText(card.getText1());
        holder.t2.setText(card.getText2());
        Picasso.with(context).load(card.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void clear() {
        int size = this.cardList.size();
        this.cardList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addAll(List<Card> cards) {
        this.cardList.addAll(cards);
        notifyItemRangeInserted(0,cards.size());
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView imageView;
        public CardHolder(View itemView) {
            super(itemView);
            t1 = (TextView)itemView.findViewById(R.id.text1);
            t2 = (TextView)itemView.findViewById(R.id.text2);
            imageView = (ImageView) itemView.findViewById((R.id.cardImage));
        }
    }
}
