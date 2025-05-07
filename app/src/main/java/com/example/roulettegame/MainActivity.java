package com.example.roulettegame;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int startDegree = 0;
    int endDegree = 0;
    ImageView ivRoulette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivRoulette = findViewById(R.id.roulette);
    }

    public void rotate(View view) {
        startDegree = endDegree % 360;
        Random rand = new Random();

        int degree = rand.nextInt(360);
        endDegree = startDegree + degree + 360 * 3;
        ObjectAnimator objectR = ObjectAnimator.ofFloat(ivRoulette, "rotation", startDegree, endDegree);
        objectR.setDuration(3000);
        objectR.setInterpolator(new AccelerateInterpolator());
        
        objectR.start();
    }

    public void animationTest(View view) {

    }
}