package ps.edu.s101.testgetandpost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    RecyclerView rv;
    postAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 0);
        }


        rv = findViewById(R.id.RecView);
        final ArrayList<posts> STDE = new ArrayList<>();
        adapter = new postAdapter(STDE, this);





        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);



        StringRequest request = new StringRequest(Request.Method.POST, "http://hmstudio.club/sohaTest/e1/getCats.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray cast = new JSONArray(response);
                    Gson gson = new Gson();
                    res[] list = gson.fromJson(cast.toString(),res[].class);

                    for (int i=0; i<list.length; i++) {
                        res r = list[i];
                        STDE.add(new posts(r.cat_id,r.name,r.image));
                        adapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("eyas",error.getMessage());
            }
        });

        Volley.newRequestQueue(Main3Activity.this).add(request);






    }


}

/*
    <uses-permission android:name="android.permission.INTERNET" />
    implementation 'com.android.volley:volley:1.1.1'
    implementation 'com.google.code.gson:gson:2.8.6'
 */


//////////////////////////////////////

public class postAdapter extends RecyclerView.Adapter<postAdapter.PostViewHolder> {

    ArrayList<posts> stde;
    Context context;

    public postAdapter(ArrayList<posts> stde, Context context) {
        this.stde = stde;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custm_post , parent , false);
        PostViewHolder holder = new PostViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        posts p = stde.get(position);
        holder.tv_id.setText(p.getId());
        holder.tv_titel.setText(p.getTitel());
        holder.tv_bode.setText(p.getData());


    }

    @Override
    public int getItemCount() {
        return stde.size();
    }




    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id , tv_titel , tv_bode;
        Button Add_btn;

        public PostViewHolder(@NonNull final View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.t1);
            tv_titel = itemView.findViewById(R.id.t2);
            tv_bode = itemView.findViewById(R.id.t3);
            Add_btn = itemView.findViewById(R.id.Add_btn);

            Add_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent s = new Intent(context, Main5Activity.class);
                    s.putExtra("id",tv_id.getText());
                    context.startActivity(s);
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context, "ttt"+tv_id.getText(), Toast.LENGTH_SHORT).show();
                    Intent s = new Intent(context, Main4Activity.class);
                    s.putExtra("id",tv_id.getText());
                    context.startActivity(s);
                }
            });




        }
    }
}

