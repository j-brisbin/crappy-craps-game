package com.example.user.joelscrappycrapsapp;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button rollButton;
    private Button restartButton;
    private TextView gameStatusTextView;
    private TextView winsLossesTextView;
    private TextView rollNumberTextView;
    private ImageView dice1Image;
    private ImageView dice2Image;
    private int dice1ImagePath;
    private int dice2ImagePath;
    private Craps craps;
    private Die die1;
    private Die die2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        die1 = new Die();
        die2 = new Die();
        craps = new Craps();
        gameStatusTextView = (TextView)findViewById(R.id.gameStatus);
        winsLossesTextView = (TextView)findViewById(R.id.winsLosses);
        rollNumberTextView = (TextView)findViewById(R.id.rollNumber);
        rollButton = (Button)findViewById(R.id.rollButton);
        restartButton = (Button)findViewById(R.id.restartButton);
        dice1Image = (ImageView)findViewById(R.id.dice1);
        dice2Image = (ImageView)findViewById(R.id.dice2);
        rollButton.setOnTouchListener(new MyRollListener());
        restartButton.setOnTouchListener(new MyRestartListener());
    }

    private class MyRollListener implements OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            die1.roll();
            die2.roll();
            dice1ImagePath = getResources().getIdentifier("dice" + die1.getFace(),
                    "drawable",getPackageName());
            dice2ImagePath = getResources().getIdentifier("dice" + die2.getFace(),
                    "drawable",getPackageName());
            dice1Image.setImageResource(dice1ImagePath);
            dice2Image.setImageResource(dice2ImagePath);
            gameStatusTextView.setText(craps.gameCheck(die1, die2));
            winsLossesTextView.setText("Wins: " + craps.getWins() + " Losses: " + craps.getLosses());
            return false;
        }
    }

    private class MyRestartListener implements OnTouchListener{
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            dice1Image.setImageResource(R.drawable.dice0);
            dice2Image.setImageResource(R.drawable.dice0);
            gameStatusTextView.setText("");
            winsLossesTextView.setText("Wins: " + craps.getWins() + " Losses: " + craps.getLosses());
            craps.resetGame();
            return false;
        }
    }


}
