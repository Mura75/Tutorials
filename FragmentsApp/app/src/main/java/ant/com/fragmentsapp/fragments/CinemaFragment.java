package ant.com.fragmentsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ant.com.fragmentsapp.R;
import ant.com.fragmentsapp.adapters.CinemaAdapter;
import ant.com.fragmentsapp.models.Cinema;


public class CinemaFragment extends Fragment {

    RecyclerView rvCinema;

    CinemaAdapter cinemaAdapter;

    List<Cinema> cinemaList;

    public CinemaFragment() {
        cinemaList = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cinema, container, false);

        rvCinema = (RecyclerView) view.findViewById(R.id.rvCinema);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvCinema.setLayoutManager(layoutManager);

        cinemaAdapter = new CinemaAdapter(cinemaList);
        rvCinema.setAdapter(cinemaAdapter);

        getCinemaList();

        return view;
    }

    private void getCinemaList() {

        Ion.with(getActivity())
                .load("GET", "https://data.egov.kz/api/v2/cinema?source=")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {

                        if (e != null) {
                            Log.d("Cinema_result", e.toString());
                        }

                        if (result != null) {

//                            Gson gson = new Gson();
//                            Type listType = new TypeToken<List<Cinema>>(){}.getType();
//                            List<Cinema> cinemas = (List<Cinema>)gson.fromJson(result, listType);
//                            cinemaList.addAll(cinemas);
//                            Log.d("Cinema_list", cinemaList.toString());
//                            cinemaAdapter.notifyDataSetChanged();

                            try {
                                JSONArray array = new JSONArray(result.toString());

                                Log.d("My_array", array.toString());

                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject object = array.getJSONObject(i);

                                    Log.d("My_obj", object.toString());

                                    Cinema cinema = new Cinema();

                                    cinema.setFullName(object.getString("FullName"));
                                    cinema.setMall(object.getString("Mall"));
                                    cinema.setBuilding(object.getString("Building"));

                                    Log.d("My_cinema", cinema.toString());

                                    cinemaList.add(cinema);

                                    Log.d("My_list", cinemaList.toString());
                                }

                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }

                            Log.d("My_list", cinemaList.toString());

                            cinemaAdapter.notifyDataSetChanged();

                            Log.d("Cinema_result", result.toString());
                        }
                    }
                });

    }

}
