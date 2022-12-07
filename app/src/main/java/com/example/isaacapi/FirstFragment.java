package com.example.isaacapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import com.example.isaacapi.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private IsaacAdapter adapter;
    private ArrayList<Personajes> items;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter =new IsaacAdapter(
                getContext(),
                R.layout.lv_isaac_row,
                items
        );
        binding.lvisaac.setAdapter(adapter);

        refresh();
    binding.personajes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_FirstFragment_to_SecondFragment));

    }
    public void refresh() {
        Toast.makeText(getContext(), "Refrescando...", Toast.LENGTH_LONG).show();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tipo= preferences.getString("Tipo", "");
        if(!tipo.equals("")){

        }
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            IsaacApi api = new IsaacApi();
            ArrayList<Personajes>  personajes = api.getPersonajes();

            handler.post(() -> {
                adapter.clear();
                adapter.addAll(personajes);
            });
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.refresh){
            refresh();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    class IsaacAdapter extends ArrayAdapter<Personajes> {
        public IsaacAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

    }
    

}