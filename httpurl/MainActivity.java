package com.example.httpurl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn1,btn2,btn3,btn4;
    public static final String URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhL-jHCVQMW9KyY-70hFgaRtQ5B1KAPxu-5ZPhFKZiCmL8y-8q";
    public static final String URL2 = "https://images.pexels.com/photos/1054289/pexels-photo-1054289.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
    public static final String URL3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3QAaeLe6BeXqfZkQpu3aMLOY91e-Y43MyCWA8Vh7JCqZo--vtxw";
    public static final String URL4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfp-VHPX16y4EVph_I5b5rK-VFPzIrAALwylo-OSYjOzYVPzMRwA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        // Create an object for subclass of AsyncTask
//        GetXMLTask task = new GetXMLTask();
//        // Execute the task
//        task.execute(new String[] { URL });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXMLTask task = new GetXMLTask();
                // Execute the task
                task.execute(new String[] { URL });
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXMLTask task = new GetXMLTask();
                // Execute the task
                task.execute(new String[] { URL2 });
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXMLTask task = new GetXMLTask();
                // Execute the task
                task.execute(new String[] { URL3 });
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetXMLTask task = new GetXMLTask();
                // Execute the task
                task.execute(new String[] { URL4 });
            }
        });

        //new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute("http://scoopak.com/wp-content/uploads/2013/06/free-hd-natural-wallpapers-download-for-pc.jpg");

    }

    private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap map = null;
            for (String url : urls) {
                map = downloadImage(url);
            }
            return map;
        }

        // Sets the Bitmap returned by doInBackground
        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

        // Creates Bitmap from InputStream and returns it
        private Bitmap downloadImage(String url) {
            Bitmap bitmap = null;
            InputStream stream = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;

            try {
                stream = getHttpConnection(url);
                bitmap = BitmapFactory.
                        decodeStream(stream, null, bmOptions);
                stream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return bitmap;
        }

        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString)
                throws IOException {
            InputStream stream = null;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }
    }



}

// class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
//    ImageView bmImage;
//    public DownloadImageTask(ImageView bmImage) {
//        this.bmImage = bmImage;
//    }
//
//    protected Bitmap doInBackground(String... urls) {
//        String urldisplay = urls[0];
//        Bitmap mIcon11 = null;
//        try {
//            InputStream in = new java.net.URL(urldisplay).openStream();
//            mIcon11 = BitmapFactory.decodeStream(in);
//        } catch (Exception e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//        return mIcon11;
//    }
//
//    protected void onPostExecute(Bitmap result) {
//        bmImage.setImageBitmap(result);
//    }
//}