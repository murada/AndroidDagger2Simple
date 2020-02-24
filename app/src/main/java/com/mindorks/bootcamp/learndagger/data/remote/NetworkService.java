package com.mindorks.bootcamp.learndagger.data.remote;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ApiKey;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Dummy class to simulate the actual NetworkService using Retrofit or OkHttp etc
 */
@Singleton
public class NetworkService {

    private Context context;
    private String apiKey;


    @Inject
    public NetworkService(Context context,@ApiKey String apiKey) {
        // do the initialisation here
        this.context = context;
        this.apiKey = apiKey;
    }

    public String getDummyData() {
        return "NETWORK_DUMMY_DATA";
    }
}
