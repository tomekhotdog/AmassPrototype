package com.amassprototype.CardProviders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amassprototype.R;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;

import java.util.ArrayList;

/**
 * Created by Tomasz on 11/11/15.
 */
public class BirthdayCardProvider extends CardProvider<BirthdayCardProvider> {

    private String text = "Birthdays coming up!";
    private int drawable = R.mipmap.ic_launcher;
    ArrayList<String> names = new ArrayList<>();
    private Context mContext;
    private int mBackground_color = -1;

    public int getLayout() {
        return R.layout.birthdays_card;
    }

    public BirthdayCardProvider setText(String text) {
        this.text = text;
        notifyDataSetChanged();
        return this;
    }

    public BirthdayCardProvider setImage(int id) {
        this.drawable = id;
        notifyDataSetChanged();
        return this;
    }

    public BirthdayCardProvider setNames(ArrayList<String> names, Context context) {
        this.names = names;
        mContext = context;
        notifyDataSetChanged();
        return this;
    }

    public BirthdayCardProvider setBackgroundColor(int color) {
        mBackground_color = color;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public void render(@NonNull View view, @NonNull Card card) {
        super.render(view, card);

        TextView textView = (TextView)view.findViewById(R.id.text);
        textView.setText(text);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        image.setBackgroundResource(drawable);

        if (names != null) {
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                    mContext, R.layout.birthday_item, names);

            ListView listView = (ListView) view.findViewById(R.id.birthday_listview);
            listView.setAdapter(itemsAdapter);

        }

        if (mBackground_color != -1) {
            CardView cardView = (CardView)view.findViewById(R.id.cardView);
            //cardView.setBackgroundResource(mBackground_color);
        }

    }

}
