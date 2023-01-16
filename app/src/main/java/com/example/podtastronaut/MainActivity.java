package com.example.podtastronaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout overlay;
    private FragmentContainerView overlayFragmentContainer;
    private ConstraintLayout menuView;
    boolean overlayHidden = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the sliding overlay that covers the main menu
        overlay = findViewById(R.id.overlay);
        // the container for the fragments contained within this overlay
        overlayFragmentContainer = findViewById(R.id.overlayFragmentContainer);
        // the main menu
        menuView = findViewById(R.id.menuView);
        // initializes the view shown on the overlay to be the search view
        setOverlayView(new Search());

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

    private void setOverlayView(Fragment fragment) {
//        ViewGroup parent = (ViewGroup) overlay.getParent();
//        int index = parent.indexOfChild(overlay);
//        parent.removeView(overlay);
//        getLayoutInflater().inflate(viewXMLID, parent);
//        overlay = (ConstraintLayout) parent.getChildAt(index);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.overlay, fragment)
                .commit();


        resizeOverlay();
        moveOverlay();
    }

    /**
     * Moves the overlay to reveal or hide the main menu
     */
    public void moveOverlay() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(
                overlay,
                "translationY",
                (overlayHidden)? 0 : overlay.getHeight()
        );
        animation.setDuration(100);
        animation.start();
        overlayHidden = !overlayHidden;
    }

    public void onMenuButtonClicked(View view) {
        moveOverlay();
    }

    public void onSearchViewButtonClicked(View view) {setOverlayView(new Search());}
    public void onDownloadsViewButtonClicked(View view) {setOverlayView(new Downloads());}
    public void onMyPodcastsViewButtonClicked(View view) {setOverlayView(new MyPodcasts());}
    public void onSettingsViewButtonClicked(View view) {setOverlayView(new Settings());}

    @Override
    public void onBackPressed() {
        moveOverlay();
    }
}