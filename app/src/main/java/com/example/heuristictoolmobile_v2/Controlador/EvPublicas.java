package com.example.heuristictoolmobile_v2.Controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.heuristictoolmobile_v2.R;
import com.example.heuristictoolmobile_v2.adapter;
import com.example.heuristictoolmobile_v2.lista_evPublicas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EvPublicas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvPublicas extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<lista_evPublicas> evPublicas;
    RecyclerView recyclerView;

    private RequestQueue queue;

    public EvPublicas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EvPublicas.
     */
    // TODO: Rename and change types and number of parameters
    public static EvPublicas newInstance(String param1, String param2) {
        EvPublicas fragment = new EvPublicas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        queue = Volley.newRequestQueue(getContext());

        obtenerDatosVolley();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ev_publicas, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.cardViewer);

        // Inflate the layout for this fragment
        return rootView;
    }

    private void obtenerDatosVolley(){
        evPublicas = new ArrayList<>();
        String url = "https://run.mocky.io/v3/ef9428c5-8a4a-4129-a030-06cbb6709530";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray myJsonArray = response.getJSONArray("evPublicas");
                    //JSONArray myJsonArray = new JSONArray();

                    for (int i=0; i<myJsonArray.length();i++){
                        JSONObject myJsonObjetc = myJsonArray.getJSONObject(i);
                        String id = myJsonObjetc.getString("id");
                        String empresa = myJsonObjetc.getString("empresa");
                        String tipoImplementacion = myJsonObjetc.getString("tipoImplementacion");
                        String tipoAplicacion = myJsonObjetc.getString("tipoAplicacion");
                        String tipoEvaluacion = myJsonObjetc.getString("tipoEvaluacion");
                        String proposito = myJsonObjetc.getString("proposito");
                        String usuarioCreador = myJsonObjetc.getString("usuarioCreador");
                        String año = myJsonObjetc.getString("año");

                        evPublicas.add(new lista_evPublicas(id, empresa, tipoImplementacion, tipoAplicacion, tipoEvaluacion, proposito, usuarioCreador, año));

                    }

                    adapter adapter = new adapter(evPublicas, getContext());
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}