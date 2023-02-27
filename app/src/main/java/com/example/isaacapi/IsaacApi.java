package com.example.isaacapi;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class IsaacApi {

    public ArrayList<Personajes> getPersonajes() {

        String url = "http://localhost:8081/personajeses";



        {
            try {
                String resultados;
                resultados = HttpUtilitis.get(url);
                JSONObject jsonResult = new JSONObject(resultados);

                JSONArray results = jsonResult.getJSONArray("resultados");

                ArrayList<Personajes> personajes = new ArrayList<>();
                for (int i = 0; i < resultados.length(); i++) {
                    JSONObject IsaacJson = results.getJSONObject(i);

                    Personajes persisaac = new Personajes();


                    persisaac.setName(IsaacJson.getString("nom"));
                    //persisaac.getDetailsUrl(IsaacJson.getString("url"));
                    //String sprites = IsaacJson.getString("sprites_url");
                    //persisaac.setImage(sprites);

                    personajes.add(persisaac);
                }

                return personajes;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}

