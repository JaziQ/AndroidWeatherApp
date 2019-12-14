package com.example.task6t;

import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestGeoposition {
    private final OkHttpClient client = new OkHttpClient();

    protected void getLocaleKey(String position) {

        try {
            GetGeolocale(position);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int GetGeolocale(String position) throws IOException, JSONException, InterruptedException {
        String urlGeoposition = "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search";
        HttpUrl.Builder httpBuilder = Objects.requireNonNull(HttpUrl.parse(urlGeoposition))
                .newBuilder();
        String apiKey = "4jYQhJmfrgSq5CmbrQZkPZccXZzAMRC0";
        httpBuilder.addQueryParameter("apikey", apiKey);
        httpBuilder.addQueryParameter("q", position);

        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .build();


        final Response[] response = new Response[1];
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException ioException) {

                ioException.printStackTrace();
            }

            @Override
            public void onResponse(Call call, @NotNull Response resp) throws IOException {


                response[0] = resp;
            }

        });
        TimeUnit.SECONDS.sleep(1);
        JSONObject jsonObject = new JSONObject(response[0].body().string());
        Weather weather = new Weather();
        weather.setLocale(getLocale(jsonObject));
        response[0].close();
        return weather.getLocale();
    }

        private int getLocale(JSONObject jsonObject) throws JSONException {
            return jsonObject.getJSONArray("Key").getInt(Integer.parseInt("Value"));

        }

}