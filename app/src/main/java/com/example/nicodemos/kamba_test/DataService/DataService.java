package com.example.nicodemos.kamba_test.DataService;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nicodemos.kamba_test.Acitivitys.UserKambaTest;
import com.example.nicodemos.kamba_test.Constants.Constants;
import com.example.nicodemos.kamba_test.DadosAPIModelo.KambaModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicodemos on 28/09/2018.
 */

public class DataService {

    private  static  DataService instance=new DataService();

    public static DataService getInstance() {
        return instance;
    }

    public DataService() {
    }

    // request all UserKambas from API


    public List<KambaModel> DownloadKambaAPI(final Context context, final UserKambaTest.KambaAPIDownloaded kambaAPIDownloaded){

        final  String url = Constants.KAMBA_API;  // this is the kamba API String it is in Class Constants that hold all the String
        final String accesstoken=Constants.ACESS_TOKEN_DEV; // this the acess_token_dev that kamba send for everyDev
        final List<KambaModel> list = new ArrayList<KambaModel>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() { // we are creating a Json Request http and for that we using Volley
            @Override
            public void onResponse(JSONArray response) {
                System.out.println(response.length());

                for (int i = 0; i < response.length(); i++) { // we loop in Kam
                    try {
                        JSONObject userKambaObject = response.getJSONObject(i);

                        String id_user=userKambaObject.optString("id");
                        String intent= userKambaObject.optString("intent");
                        int amount=userKambaObject.optInt("amount");
                        int subtotal= userKambaObject.optInt("subtotal");
                        int fee= userKambaObject.optInt("fee");

                        JSONObject from_user= userKambaObject.getJSONObject("from");
                        String id_from= from_user.getString("id");
                        String firstname= from_user.getString("firstname");
                        String lastname= from_user.getString("lastname");
                        String phone_number= from_user.getString("phone_number");
                        String email_from= from_user.getString("email");
                        JSONObject to_user= userKambaObject.getJSONObject("to");
                        String id_to= to_user.getString("id");
                        String first_name_to= to_user.getString("firstname");
                        String lastname_to= to_user.getString("lastname");
                        String phone_to= to_user.getString("phone_number");
                        String email_to= to_user.getString("email");
                        String description= userKambaObject.getString("description");


                        // model
                        KambaModel usuarioContaKambasTest= new KambaModel(id_user,intent,amount,subtotal,fee,id_from,firstname,lastname,phone_number,
                                email_from, id_to,first_name_to,lastname_to,phone_to,email_to,description);

                        list.add(usuarioContaKambasTest);



                    } catch (JSONException e) {
                        e.printStackTrace();

                    }


                }



                System.out.println(response);
                Log.v("Log", Constants.LOG_SHOW_THE_RESPONSE_API+response);
                kambaAPIDownloaded.sucess(true);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());


            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                // Basic Authentication
                //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);

                headers.put("Authorization", "Bearer " + accesstoken);
                headers.put("Content-Type" ,"application/json");

                return headers;
            }


        };




        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonArrayRequest);

      return list;
    }


}
