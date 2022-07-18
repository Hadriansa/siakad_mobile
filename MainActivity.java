package com.example.siakad;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    private RecyclerView lvmahasiswa;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    ArrayList<HashMap<String, String>> list_data;
    String url = "http://172.16.0.96/siakad2/getdata.php";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvmahasiswa = (RecyclerView) findViewById(R.id.lv_mahasiswa);
        //merubah komponen RecyclerView menjadi linier vertical
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvmahasiswa.setLayoutManager(llm);
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        //set variabel list_data dengan nilai null (kosong)
        list_data = new ArrayList<HashMap<String, String>>(); 
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    //ketika program berhasil
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("mahasiswa");
                    //perulangan sebanyak jumlah data dalam varaibel mahasiswa
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("nim", json.getString("nim"));
                        map.put("nama", json.getString("nama"));
                        map.put("jurusan", json.getString("jurusan"));
                        map.put("alamat", json.getString("alamat"));
                        map.put("tmplahir", json.getString("tmplahir"));
                        map.put("tgllahir", json.getString("tgllahir"));
                        map.put("agama", json.getString("agama"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(MainActivity.this, list_data);
                        lvmahasiswa.setAdapter(adapter);
                    }
                } catch (JSONException e) {

                    //ketika ada error
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);


    }
}