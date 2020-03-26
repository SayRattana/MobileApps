package com.example.jsonlistview.mjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser extends AsyncTask<Void,Void,Boolean> {
    Context context;
    String jsonData;
    ListView lv;
    ProgressDialog progressDialog;

    ArrayList<String> users = new ArrayList<>();

    public JSONParser(Context context, String jsonData, ListView lv) {
        this.context = context;
        this.jsonData = jsonData;
        this.lv = lv;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Parse ListView");
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
            lv.setAdapter(arrayAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                String id  = jsonObject.getString("id");
                String title =jsonObject.getString("title");
                users.add(id);
                users.add(title);
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
            return false;
        }
    }
}
