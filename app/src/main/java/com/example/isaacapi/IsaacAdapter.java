package com.example.isaacapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.example.isaacapi.databinding.LvIsaacRowBinding;

import java.util.List;

    public class IsaacAdapter extends ArrayAdapter<Personajes> {

        public IsaacAdapter(Context context, int resource, List<Personajes> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int posotion, View convertView, ViewGroup parent){
            Personajes personajes = getItem(posotion);

            LvIsaacRowBinding binding=null;

            if (convertView == null) {
                binding =LvIsaacRowBinding.inflate(LayoutInflater.from(getContext()),parent, false);
                convertView = binding.getRoot();
                convertView.setTag(binding);
            } else {
                binding = (LvIsaacRowBinding) convertView.getTag();
            }
            binding.isaactxt.setText(personajes.getName());

            Glide.with(getContext()).load(personajes.getImage()).into(binding.imageIsaac);

            return binding.getRoot();
        }


    }

