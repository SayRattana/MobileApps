package com.example.jsonlistview.mjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;

public class JSONDownloader extends AsyncTask<Void,Void,String> {
    Context context;
    String jsonURL;
    ListView lv;
    ProgressDialog progressDialog;

    public JSONDownloader(Context context, String jsonURL, ListView lv) {
        this.context = context;
        this.jsonURL = jsonURL;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download ListView");
        progressDialog.setMessage("Downloading...!\nPlease wait");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        progressDialog.dismiss();

        if(jsonData.startsWith("Error")){
            String error = jsonData;
            Toast.makeText(context,error,Toast.LENGTH_SHORT).show();
        }else {
            //PARSER
            new JSONParser(context,jsonData,lv).execute();
        }
    }

    private String download(){
        Object connection = Connector.connector(jsonURL);
        if(connection.toString().startsWith("Error")){
        return connection.toString();
        }

        try{
            // ESTABLISH CONNECTION
            HttpsURLConnection con = (HttpsURLConnection) connection;
            if(con.getResponseCode()==con.HTTP_OK){

                //GET INPUT FROM STREAM
                InputStream inputStream =new BufferedInputStream(con.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                StringBuffer jsonData = new StringBuffer();

                //READ
                while ((line = bufferedReader.readLine())!=null){
                    jsonData.append(line+"\n");
                }
                //Close RESOURCE
                bufferedReader.close();
                inputStream.close();;

                //RETURN JSON
                return jsonData.toString();
            }else {
                return "Error"+con.getResponseCode();
            }
        }catch (IOException e){
            e.printStackTrace();
            return "Error"+e.getMessage();
        }
    }

}
