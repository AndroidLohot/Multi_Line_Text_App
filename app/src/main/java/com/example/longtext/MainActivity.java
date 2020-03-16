package com.example.longtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText edMassage;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database= FirebaseDatabase.getInstance();
        myRef=database.getReference("masssage");

        edMassage=(EditText) findViewById(R.id.edMassage);
    }

    public void sendF(View view) {

        String massage=edMassage.getText().toString();

        if (TextUtils.isEmpty(massage))
        {
            edMassage.setError("Enter the massage");
            return;
        }
        else
        {
            key=myRef.push().getKey();
            myRef.child(key).setValue(massage);
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);

            Toast.makeText(MainActivity.this,"Massage is send",Toast.LENGTH_LONG).show();
        }
    }
}
