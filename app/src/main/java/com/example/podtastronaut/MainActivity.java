package com.example.podtastronaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout overlay;
    private ConstraintLayout menuView;
    boolean overlayHidden = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overlay = findViewById(R.id.overlay);
        menuView = findViewById(R.id.menuView);

        setOverlayView(R.layout.search);

        View mainView = findViewById(R.id.mainFrame);
        mainView.getViewTreeObserver().addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mainView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    resizeOverlay();
                }
            }
        );
    }

    private void resizeOverlay() {
        overlay.setMaxHeight(menuView.getHeight());
    }

    private void setOverlayView(int viewXMLID) {
        ViewGroup parent = (ViewGroup) overlay.getParent();
        int index = parent.indexOfChild(overlay);
        parent.removeView(overlay);
        getLayoutInflater().inflate(viewXMLID, parent);
        overlay = (ConstraintLayout) parent.getChildAt(index);
        resizeOverlay();
        moveOverlay();
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

    public void onSearchViewButtonClicked(View view) {setOverlayView(R.layout.search);}
    public void onDownloadsViewButtonClicked(View view) {setOverlayView(R.layout.downloads);}
    public void onMyPodcastsViewButtonClicked(View view) {setOverlayView(R.layout.my_podcasts);}
    public void onSettingsViewButtonClicked(View view) {setOverlayView(R.layout.settings);}

    @Override
    public void onBackPressed() {
        moveOverlay();
    }
}