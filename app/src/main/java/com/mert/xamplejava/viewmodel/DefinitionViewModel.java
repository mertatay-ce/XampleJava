package com.mert.xamplejava.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mert.xamplejava.model.data.DefinitionModel;
import com.mert.xamplejava.model.data.body.WordBody;
import com.mert.xamplejava.model.data.response.DefinitionResponse;
import com.mert.xamplejava.model.repo.DefinitionRepository;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class DefinitionViewModel extends AndroidViewModel {
    private final DefinitionRepository mDefinitionRepository;
    private final MutableLiveData<List<DefinitionResponse>> mmDefinitionModel;
    private ArrayList<DefinitionResponse> definitionResponsesArrayList;

    public DefinitionViewModel(@NonNull Application application) {
        super(application);
        mDefinitionRepository = new DefinitionRepository();
        mmDefinitionModel= new MutableLiveData<>();
    }

    public LiveData<List<DefinitionResponse>> getAllDefinitions() {
        return mmDefinitionModel;
    }

    public void init(String word){
        definitionResponsesArrayList = new ArrayList<>();
        mDefinitionRepository.getDefinition(new WordBody(word), new DefinitionRepository.IDefResponse() {
            @Override
            public void onResponse(DefinitionResponse defResponse) {
                definitionResponsesArrayList.add(defResponse);
                mmDefinitionModel.postValue(definitionResponsesArrayList);
                Log.i("response" , defResponse.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Error",t.getLocalizedMessage()+"");
            }
        });
        mmDefinitionModel.setValue(definitionResponsesArrayList);
    }

    public MutableLiveData<List<DefinitionResponse>> getMmDefinitionModel() {
        return mmDefinitionModel;
    }
}
