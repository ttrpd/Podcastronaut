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

        // the sliding overlay that covers the main menu
        overlay = findViewById(R.id.overlay);
        // the main menu
        menuView = findViewById(R.id.menuView);
        // initializes the view shown on the overlay to be the search view
        setOverlayView(R.layout.search);

        // adds a listener to the view tree which resizes the overlay, once built
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

    /**
     * Adjusts the Overlay's size to make the menu button, nowplaying button, and title bar visible
     */
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

    /**
     * Moves the overlay to reveal or hide the main menu
     */
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