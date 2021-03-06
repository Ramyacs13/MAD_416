package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button bt;
    Spinner s;

    String [] dept_array={"CSE","ECE","IS","TCE"};
    String name,usn,dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editView);
        e2=(EditText)findViewById(R.id.editView2);

        bt=(Button)findViewById(R.id.button);

        s=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter adapter =new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v)
            {
                name=e1.getText().toString();
                usn=e2.getText().toString();
                dept=s.getSelectedItem().toString();

                Intent i=new Intent(MainActivity.this,Main2Activity.class);

                i.putExtra("name_key",name);
                i.putExtra("usn_key",usn);
                i.putExtra("dept_key",dept);

                startActivity(i);

            }
        });
    }
}

