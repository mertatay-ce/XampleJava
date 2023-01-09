package com.mert.xamplejava.network;



import com.mert.xamplejava.model.interfaces.DefinitionService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String DEFINITION_SERVICE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/";
    private static Retrofit retrofit;



    public static DefinitionService getDefinitionService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(DEFINITION_SERVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit.create(DefinitionService.class);
    }
}
