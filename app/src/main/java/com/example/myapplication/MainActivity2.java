package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextcelsus,editTextFer;
    Button converbuttom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTextcelsus=findViewById(R.id.editTextCels);
        editTextFer=findViewById(R.id.editTextFere);
        converbuttom=findViewById(R.id.buttonConvertir);

        converbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempC=editTextcelsus.getText().toString();
                String tempF=editTextFer.getText().toString();
                if ((tempC.isEmpty())&&(tempF.isEmpty())){
                    Toast.makeText(MainActivity2.this, "veuillez remplir l'un des champs", Toast.LENGTH_LONG).show();
                    editTextcelsus.setText("");
                    editTextFer.setText("");
                }
                else if (!(tempC.isEmpty())&& !(tempF.isEmpty())){
                    Toast.makeText(MainActivity2.this, "il faut entrer une Seul valeur", Toast.LENGTH_LONG).show();
                    editTextcelsus.setText("");
                    editTextFer.setText("");
                }
                else if (!(tempC.isEmpty())) {
                    float val1= Float.parseFloat(editTextcelsus.getText().toString());

                    float converttofer= (float) (val1*1.8+32);
                    editTextFer.setText(converttofer+"");
                } else {
                    float val2= Float.parseFloat(editTextFer.getText().toString());
                    float converttocelsus = (float) ((val2 - 32)/1.8);
                    editTextcelsus.setText(converttocelsus+"");
                }
            }
        });
    }
}
