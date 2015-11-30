package com.paris8.univ.androidproject.game.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.paris8.univ.androidproject.R;
import com.paris8.univ.androidproject.game.GameActivity;

/**
 * Created by jpagny on 24/11/15.
 */
public class LevelChooser extends Activity{

    private Button level1Button;
    private Button level2Button;
    private Button level3Button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_chooser);


        level1Button = (Button) findViewById(R.id.level1Button);
        level2Button = (Button) findViewById(R.id.level2Button);
        level3Button = (Button) findViewById(R.id.level3Button);

        level1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelChooser.this, GameActivity.class);
                GameActivity.mSelectedLevel = 0;

                LevelChooser.this.startActivity(intent);
            }
        });

        level2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelChooser.this, GameActivity.class);
                GameActivity.mSelectedLevel = 1;
                LevelChooser.this.startActivity(intent);
            }
        });

        level3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelChooser.this, GameActivity.class);
                GameActivity.mSelectedLevel = 2;

                LevelChooser.this.startActivity(intent);
            }
        });


    }




}