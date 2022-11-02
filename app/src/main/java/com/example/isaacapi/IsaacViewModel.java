package com.example.isaacapi;
import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class IsaacViewModel extends AndroidViewModel{

    private final Application app;
    private MutableLiveData<List<Personajes>>personajes;


    public IsaacViewModel (@NonNull Application application){
        super(application);
        this.app = application;

    }

    public IsaacViewModel(@NonNull Application application, Application app) {
        super(application);
        this.app = app;
    }

    public MutableLiveData<List<Personajes>> getPokemones() {
        if(personajes==null){

        }
        return personajes;
    }
    public void refresh() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            IsaacApi api = new IsaacApi();
            ArrayList<Personajes> pokemons = api.getPersonajes();

        });
    }

}
