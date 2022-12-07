package com.example.isaacapi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import com.example.isaacapi.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ArrayList<Personajes> items;
    private ArrayAdapter<Personajes> adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter = new IsaacAdapter(
                getContext(),
                R.id.isaactxt,
                items
        );
        binding.listview1.setAdapter(adapter);


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);


            }

        });
        refresh();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    void refresh() {

        Toast.makeText(getContext(), "Refrescando...", Toast.LENGTH_LONG).show();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            IsaacApi api = new IsaacApi();
            ArrayList<Personajes> result = api.getPersonajes();

            handler.post(() -> {
                adapter.clear();

                    adapter.addAll(items);

            });
        });
    }
}