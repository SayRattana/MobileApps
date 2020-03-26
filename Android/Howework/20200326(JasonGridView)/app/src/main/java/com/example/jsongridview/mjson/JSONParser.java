package com.example.jsongridview.mjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser extends AsyncTask<Void,Void,Boolean> {
    Context context;
    String jsonData;
    GridView gv;
    ProgressDialog progressDialog;

    ArrayList<String> users = new ArrayList<>();

    public JSONParser(Context context, String jsonData, GridView gv) {
        this.context = context;
        this.jsonData = jsonData;
        this.gv = gv;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Parse GridView");
        progressDialog.setMessage("Parsing...!\nPlease wait");
        progressDialog.show();
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }
    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        progressDialog.dismiss();
        if(isParsed){
            //BIND
            ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>
                    (context,android.R.layout.simple_list_item_1,users);
            gv.setAdapter(arrayAdapter);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?>  adapterView, View view, int i, long id) {
                    Toast.makeText(context,users.get(i),Toast.LENGTH_SHORT).show();
                }
            });


        }else {

        }
    }

    private Boolean parse(){
        try {
            JSONArray jsonArray =new JSONArray(jsonData);
            JSONObject jsonObject;
            users.clear();
            for (int i=0; i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);

                  String id =jsonObject.getString("id");
//                String username =jsonObject.getString("username");
//                String email =jsonObject.getString("email");
//                users.add(username);
//                users.add(email);
                  users.add(id);

            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
            return false;
        }
    }
}
