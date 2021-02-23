package com.example.allclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    EditText et1,et2,et3;
    ImageView im;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.button);
        et1 = findViewById(R.id.editTextTextPersonName);
        et2 = findViewById(R.id.editTextTextPersonName2);
        et3 = findViewById(R.id.editTextTextPersonName3);
        im = findViewById(R.id.imageView);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num1 = Integer.parseInt(et1.getText().toString());
                int num2 = Integer.parseInt(et2.getText().toString());
                int num3 = Integer.parseInt(et3.getText().toString());

                int sum = num1+num2+num3;
                Log.e("sa",sum+"");
                double res = sum/3;
                Log.e("eyas",res+"");
                tv2.setText(res+" %");

                if (res>=90.0 && res<=100.0){
                    Log.e("ee","ممتاز");
                    tv1.setText("ممتاز");
                }else if (res>=80.0 && res<=89.9){
                    Log.e("ee","جيد جدا");
                    tv1.setText("جيد جدا");
                }else if (res>=70.0 && res<=79.9){
                    Log.e("ee","جيد ");
                    tv1.setText("جيد");
                }else if (res>=60.0 && res<=69.9){
                    Log.e("ee","ضعيف");
                    tv1.setText("ضعيف");
                }else if (res>=00.0 && res<=59.9){
                    Log.e("ee","راسب");
                    tv1.setText("راسب");
                }
            }
        });





    }
}

class GetMsgs extends AsyncTask<String, String, String> {

    boolean flag = false;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        flag = true;
    }

    @Override
    protected String doInBackground(String... arg0) {
        while(flag)
        {
            publishProgress("start");

            //Your Code what you are doing in the Do inBackground

            try
            {
                Thread.sleep(3000);//Your Interval after which you want to refresh the screen
            }
            catch (InterruptedException e)
            {
            }
            publishProgress("stop");

        }
        return null;
    }
    @Override
    protected void onProgressUpdate(String... values)
    {
        super.onProgressUpdate(values);
        if(values[0].equalsIgnoreCase("start"))
        {
            //Create Your Dialog in it
            //Do here what you are doing in the onPreExecute
        }
        else if(values[0].equalsIgnoreCase("stop"))
        {
            //Code you are doing in the onPostExecute
        }

    }
    @Override
    protected void onCancelled() {
        // TODO Auto-generated method stub
        super.onCancelled();
        flag = false;
    }
}