package com.example.podtastronaut;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class APISearchManager {
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

    public List<Podcast> searchPodcasts(String searchTerm) {
        APIRequest request = (APIRequest) new PodcastSearchRequest().execute(searchTerm);
        Log.d("APISearchRequest", "Request process began");
        return results;
    }
}
