package com.mert.xamplejava.model.interfaces;

import com.mert.xamplejava.model.data.response.DefinitionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DefinitionService {
    @GET("{word}")
    Call<DefinitionResponse> getDefinitons(@Path("word") String word);
}
