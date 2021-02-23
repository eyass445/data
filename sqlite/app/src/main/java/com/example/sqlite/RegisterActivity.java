package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button reg;
    EditText tf_n , tf_p , tf_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MyDataBase db = new MyDataBase(this);



        reg = findViewById(R.id.bt_register);
        tf_n = findViewById(R.id.tf_name);
        tf_e = findViewById(R.id.tf_email);
        tf_p = findViewById(R.id.tf_password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = tf_n.getText().toString();
                String password = tf_p.getText().toString();
                String email = tf_e.getText().toString();

                User u = new User(name,password,email);
                boolean re = db.insertUser(u);

                if (re){
                    Toast.makeText(RegisterActivity.this, "نجاح", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    
                }else {
                    Toast.makeText(RegisterActivity.this, "خطا", Toast.LENGTH_SHORT).show();
                    showDeleteConfirmationDialog();
                }


            }
        });




    }

    private void showDeleteConfirmationDialog(){
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