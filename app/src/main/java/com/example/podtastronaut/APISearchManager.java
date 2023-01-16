package com.example.podtastronaut;

import android.content.Context;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class APISearchManager {
    private static final String ITUNES_API_URL = "https://itunes.apple.com/search?media=podcast&term=";
    private Context context;
    private String title;
    private String languageTerm;
    private String authorTerm;
    private String genreIndex;
    private String artistTerm;
    private String keywordsTerm;
    private String descriptionTerm;

    public APISearchManager(Context context) {
        this.context = context;
    }

    public APISearchManager(String title, String artistTerm, Context context) {
        this.title = title;
        this.artistTerm = artistTerm;
        this.context = context;
    }

    public APISearchManager(String title, String languageTerm, String authorTerm, String genreIndex, String artistTerm, String keywordsTerm, String descriptionTerm, Context context) {
        this.title = title;
        this.languageTerm = languageTerm;
        this.authorTerm = authorTerm;
        this.genreIndex = genreIndex;
        this.artistTerm = artistTerm;
        this.keywordsTerm = keywordsTerm;
        this.descriptionTerm = descriptionTerm;
        this.context = context;
    }

    private List<Podcast> results;

    Executor executor = Executors.newSingleThreadExecutor();

    public List<Podcast> search(String searchTerm) {
        CronetEngine.Builder builder = new CronetEngine.Builder(this.context);
        CronetEngine cronetEngine = builder.build();

        UrlRequest.Builder requestBuilder = cronetEngine.newUrlRequestBuilder(
                ITUNES_API_URL+searchTerm,
                new APIRequestCallback(),
                executor
        );
        UrlRequest request = requestBuilder.build();
        request.start();
        return results;
    }
}
