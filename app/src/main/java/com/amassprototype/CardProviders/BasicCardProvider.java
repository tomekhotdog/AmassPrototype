package com.amassprototype.CardProviders;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amassprototype.R;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;

/**
 * Created by Tomasz on 11/11/15.
 */
public class BasicCardProvider extends CardProvider<BasicCardProvider> {

    String text = "placeholder text";
    int drawable_id = R.mipmap.ic_launcher;
    int mBackground_color = R.color.white;
    String text_hex;
    Context mContext;

    public int getLayout() {
        return R.layout.basic_card;
    }

    public BasicCardProvider setText(String text) {
        this.text = text;
        notifyDataSetChanged();
        return this;
    }

    public BasicCardProvider setTextColor(String text_hex) {
        this.text_hex = text_hex;
        notifyDataSetChanged();
        return this;
    }

    public BasicCardProvider setImage(int id) {
        this.drawable_id = id;
        notifyDataSetChanged();
        return this;
    }

    public BasicCardProvider setBackgroundColor(int color, Context mContext) {
        this.mContext = mContext;
        mBackground_color = color;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public void render(@NonNull View view, @NonNull Card card) {
        super.render(view, card);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        image.setBackgroundResource(drawable_id);

        LinearLayout layout = (LinearLayout)view.findViewById(R.id.background);
        layout.setBackgroundColor(mContext.getResources().getColor(mBackground_color));

        TextView textView = (TextView)view.findViewById(R.id.my_text);
        textView.setText(text);
        if (text_hex != null) { textView.setTextColor(Color.parseColor(text_hex)); }
    }

}
