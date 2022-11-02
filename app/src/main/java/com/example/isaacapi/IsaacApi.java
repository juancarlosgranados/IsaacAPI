package com.example.isaacapi;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class IsaacApi {
    String url = "https://bindingofisaac.docs.apiary.io/#reference/0/stats/retrieve-a-chapter";
    String BASE_URL = "https://bindingofisaac.docs.apiary.io/#";

    Uri.Builder IsaacUri = Uri.parse(BASE_URL).buildUpon().appendPath("pokemon");
    Uri.Builder SiUri = Uri.parse(BASE_URL).buildUpon().appendPath("ability");

        String resultados;

    {
        try {
            resultados = HttpUtilitis.get(url);
            JSONObject jsonResult = new JSONObject(resultados);
            JSONArray resultados = jsonResult.getJSONArray("resultados");

            ArrayList<Personajes> personajes = new ArrayList<>();

            for(int i =0; i< resultados.length();i++){
                JSONObject IsaacJson = resultados.getJSONObject(i);

                Personajes persisaac = new Personajes();
                persisaac.setName(IsaacJson.getString("name"));
                persisaac.getDetailsUrl(IsaacJson.getString("url"));

            String resultdetails = HttpUtilitis.get(Personajes.getDetailsUrl());
           JSONObject jsondetails = new JSONObject(resultdetails);
           JSONObject imagenes = new jsondetails.getJSONObject("sprite_url");

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

}

