package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button btn_reg2 , btn_login;
    EditText email2,pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MyDataBase db = new MyDataBase(this);


        btn_login = findViewById(R.id.bt_login2);
        btn_reg2 = findViewById(R.id.bt_register2);
        email2 = findViewById(R.id.tf_email2);
        pass2 = findViewById(R.id.tf_password2);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailget = email2.getText().toString();
                String passget = pass2.getText().toString();

                ArrayList<User> users = db.LogInUser(emailget);

                for (User u : users){

                    Log.e("login",u.getEmail()+" "+u.getName()+" "+u.getPassword());

                    String emailset = u.getEmail();

                    String passset = u.getPassword();

                    if (!emailget.equals(emailset) && !passget.equals(passset) ){
                        Toast.makeText(LoginActivity.this, "كلمة المرور خاطئة ", Toast.LENGTH_SHORT).show();
                        showDeleteConfirmationDialog();
                    }else {
                        Toast.makeText(LoginActivity.this,"كلمة المرور صحيحة", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });


        btn_reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });





    }

    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("الايميل او كلمج المرور خاطئة");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}