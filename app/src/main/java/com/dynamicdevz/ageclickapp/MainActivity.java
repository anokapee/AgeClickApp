package com.dynamicdevz.ageclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button ageBtn;
    private TextView ageTV;
    private ImageView ageIV;
    private TextView nameTV;

    private int death = (int) ((Math.random() * (1000000000 - 4801)) + 4801);
    private int age = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageBtn = findViewById(R.id.addAgeBtn);
        ageTV = findViewById(R.id.ageTV);
        ageIV = findViewById(R.id.ageIV);
        nameTV = findViewById(R.id.nameTV);

        Glide.with(MainActivity.this)
                .load(R.drawable.germination)
                .into(ageIV);
        ageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age++;
                setAgeText();
                setAgeImage();
            }
        });
    }

    private void setAgeText() {
        ageTV.setText("Age: " + age + " weeks old");
    }

    private void setAgeImage(){
        /*Glide.with(MainActivity.this)
                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(R.drawable.duck_hd)
                .into(imageView);

        Glide.with(MainActivity.this)
                .load()*/
        if (age < 0 && age > 4)
        {
            nameTV.setText("Germination");
        }
        else if (age > 3 && age < 24)
        {
            nameTV.setText("Seedling");
            Glide.with(MainActivity.this)
                    .load(R.drawable.seedling)
                    .into(ageIV);
        }
        else if (age > 23 && age < 192)
        {
            nameTV.setText("Sapling");
            Glide.with(MainActivity.this)
                    .load(R.drawable.sapling)
                    .into(ageIV);
        }
        else if (age > 191 && age < 4800)
        {
            nameTV.setText("Mature Tree");
            Glide.with(MainActivity.this)
                    .load(R.drawable.mature)
                    .into(ageIV);
        }
        else if (age > 4799 && age < death)
        {
            nameTV.setText("Ancient Tree");
            Glide.with(MainActivity.this)
                    .load(R.drawable.ancienttree)
                    .into(ageIV);
        }
        else if (age > death)
        {
            nameTV.setText("Dead.");
            Glide.with(MainActivity.this)
                    .load(R.drawable.dead)
                    .into(ageIV);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("AGE_KEY", age);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        age = savedInstanceState.getInt("AGE_KEY");
        setAgeText();
    }

}