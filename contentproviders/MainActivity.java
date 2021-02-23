package s120181340.khaled.contentproviders;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnview;
    TextView txtname,txtphno;
    static final int PICK_CONTACT = 1;
    String st;
    final private int REQUEST_MULTIPLE_PERMISSIONS = 124;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnview =  findViewById(R.id.btnload);
        txtname =  findViewById(R.id.txtname);
        txtphno =  findViewById(R.id.txtphno);
        imageView = findViewById(R.id.imageView);


        String[] p = {Manifest.permission.READ_CONTACTS};

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,p,0);
        }





        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);
            }
        });





    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case (PICK_CONTACT):

                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    String[] proj = {ContactsContract.Contacts._ID,
                            ContactsContract.Contacts.HAS_PHONE_NUMBER,
                            ContactsContract.Contacts.DISPLAY_NAME
                    };

                    Cursor c = getContentResolver().query(contactData, proj, null, null, null);


                    if (c.moveToFirst()) {


                        String id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                        String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));


                        try {

                            if (hasPhone.equalsIgnoreCase("1")) {
                                Cursor phones = getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                                phones.moveToFirst();
                                String cNumber = phones.getString(phones.getColumnIndex("data1"));
                                System.out.println("number is:" + cNumber);
                                txtphno.setText("Phone Number is: "+cNumber);
                            }




                            String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                            Uri my_contact_Uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, String.valueOf(id));
                            InputStream photo_stream = ContactsContract.Contacts.openContactPhotoInputStream(getContentResolver(), my_contact_Uri);
                            BufferedInputStream buf = new BufferedInputStream(photo_stream);
                            Bitmap my_btmp = BitmapFactory.decodeStream(buf);


                           txtname.setText("Name is: "+name);
                           imageView.setImageBitmap(my_btmp);


                        }
                        catch (Exception ex){

                            ex.getMessage();

                        }
                    }
                }

                break;
        }
    }
}
