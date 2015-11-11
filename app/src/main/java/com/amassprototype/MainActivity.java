package com.amassprototype;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.amassprototype.CardProviders.BasicCardProvider;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.view.MaterialListView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String white = "#FFFFFF";

    private MaterialListView mCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mCards = (MaterialListView) findViewById(R.id.material_listview);
        setUpCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpCards() {
        Set<Card> cards = new HashSet<Card>();

        cards.add(new Card.Builder(this)
                .withProvider(new BasicCardProvider())
                .setText("Your current portfolio")
                .setTextColor(white)
                .setImage(R.mipmap.graph)
                .endConfig()
                .build());

        cards.add(new Card.Builder(this)
                .withProvider(new BasicCardProvider())
                .setText("Start saving up!")
                .setImage(R.mipmap.concert)
                .setTextColor(white)
                .endConfig()
                .build());

        cards.add(new Card.Builder(this)
                .withProvider(new BasicCardProvider())
                .setText("Set up automatic investing")
                .setImage(R.mipmap.money_piles)
                .endConfig()
                .build());

        cards.add(new Card.Builder(this)
                .withProvider(new BasicCardProvider())
                .setText("Start saving with a friend")
                .setImage(R.mipmap.friends)
                .setTextColor(white)
                .endConfig()
                .build());


        int days = (int) (Math.random() * 100);
        cards.add(new Card.Builder(this)
                .withProvider(new BasicCardProvider())
                .setText(String.valueOf(days) + " Day Investing Streak!")
                .setImage(R.mipmap.board_meeting)
                .endConfig()
                .build());

        // All the cards are dismisable
        for (Card c : cards) { c.setDismissible(true); }

        mCards.getAdapter().addAll(cards);
    }
}
