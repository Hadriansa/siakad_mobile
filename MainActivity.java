package com.example.siakad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        getJSON();
    }
    private void tampildata(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            //jika program benar;
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY); //tabel mahasiswa
            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String nim = jo.getString(konfigurasi.TAG_NIM);
                String nama = jo.getString(konfigurasi.TAG_NAMA);
                String jurusan = jo.getString(konfigurasi.TAG_JURUSAN);
                String tempatlahir = jo.getString(konfigurasi.TAG_TEMPATLAHIR);
                String tanggallahir = jo.getString(konfigurasi.TAG_TANGGALLAHIR);
                String alamat = jo.getString(konfigurasi.TAG_ALAMAT);
                String agama = jo.getString(konfigurasi.TAG_AGAMA);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_NIM,nim);
                employees.put(konfigurasi.TAG_NAMA,nama);
                employees.put(konfigurasi.TAG_JURUSAN,jurusan);
                employees.put(konfigurasi.TAG_TEMPATLAHIR,tempatlahir);
                employees.put(konfigurasi.TAG_TANGGALLAHIR,tanggallahir);
                employees.put(konfigurasi.TAG_ALAMAT,alamat);
                employees.put(konfigurasi.TAG_AGAMA,agama);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            //program salah
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }

        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, list, R.layout.activity_list_item,
                new String[]{konfigurasi.TAG_NIM,
                        konfigurasi.TAG_NAMA,
                        konfigurasi.TAG_JURUSAN,
                        konfigurasi.TAG_TEMPATLAHIR,
                        konfigurasi.TAG_TANGGALLAHIR,
                        konfigurasi.TAG_AGAMA},
                new int[]{R.id.idnim,
                        R.id.idnama,
                        R.id.idjurusan,
                        R.id.idtmplahir,
                        R.id.idtgllahir,
                        R.id.idalamat,
                        R.id.idagama
                });
        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,
                        "Mengambil Data","Mohon Tunggu...",false,false);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                tampildata();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}