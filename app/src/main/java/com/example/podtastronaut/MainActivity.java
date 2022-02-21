package com.example.podtastronaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mainView = findViewById(R.id.mainFrame);
        ConstraintLayout overlay = findViewById(R.id.overlay);
        ConstraintLayout menuView = findViewById(R.id.menuView);
        mainView.getViewTreeObserver().addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mainView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    overlay.setMaxHeight(menuView.getHeight());
                }
            }
        );
    }
}