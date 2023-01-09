package com.mert.xamplejava.model.repo;

import android.util.Log;

import com.mert.xamplejava.model.data.body.WordBody;
import com.mert.xamplejava.model.data.response.DefinitionResponse;
import com.mert.xamplejava.model.interfaces.DefinitionService;
import com.mert.xamplejava.network.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefinitionRepository {
    private static final String TAG = "DefinitionRepository";

    public DefinitionRepository() {
    }

    public void getDefinition(WordBody wordBody, IDefResponse defResponse) {
        DefinitionService definitionService = RetrofitClient.getDefinitionService();
        Call<DefinitionResponse> initiateDefine = definitionService.getDefinitons(wordBody.getWord());

        initiateDefine.enqueue(new Callback<DefinitionResponse>() {
            @Override
            public void onResponse(Call<DefinitionResponse> call, Response<DefinitionResponse> response) {
                Log.d(TAG,response.code()+"");
                if (response.isSuccessful()){
                    defResponse.onResponse(response.body());
                    Log.d(TAG,response.body()+"");
                } else {
                    try {
                        defResponse.onFailure(new Throwable(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DefinitionResponse> call, Throwable t) {
                defResponse.onFailure(t);
            }
        });

    }

    public interface IDefResponse{
        void onResponse(DefinitionResponse defResponse);
        void onFailure(Throwable t);
    }

}
