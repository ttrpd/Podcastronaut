package com.example.podtastronaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout overlay;
    boolean overlayHidden = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mainView = findViewById(R.id.mainFrame);
        overlay = findViewById(R.id.overlay);
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

    public void moveOverlay() {
        float translationVal = overlay.getHeight();
        if (overlayHidden) {
            translationVal = 0;
        }
        ObjectAnimator animation = ObjectAnimator.ofFloat(
                overlay,
                "translationY",
                translationVal
        );
        animation.setDuration(100);
        animation.start();
        overlayHidden = !overlayHidden;
    }

    public void onMenuButtonClicked(View view) {
        moveOverlay();
    }
}