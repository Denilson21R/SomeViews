package com.example.someviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //obj
    private EditText nomeEt;
    private EditText sobrenomeEt;
    private EditText emailEt;
    private Spinner estadoCivilSp;
    private LinearLayoutCompat conjugell;
    private EditText nomeConjugeEt;
    private EditText sobrenomeConjugeEt;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;
    private Button clearBt;

    private String nomeCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding
        bindViews();

        estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView viewSelecionada = (TextView) view;
                if(viewSelecionada.getText().equals("Casado")) {
                    conjugell.setVisibility(View.VISIBLE);
                }else {
                    conjugell.setVisibility(View.GONE);
                    nomeConjugeEt.setText("");
                    sobrenomeConjugeEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sobrenomeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nomeCompleto = nomeEt.getText().toString() + " " + charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void bindViews() {
        nomeEt = findViewById(R.id.nomeEt);
        sobrenomeEt = findViewById(R.id.sobrenomeEt);
        emailEt = findViewById(R.id.emailEt);
        estadoCivilSp = findViewById(R.id.estadoCivilSp);
        conjugell = findViewById(R.id.conjugeLl);
        nomeConjugeEt = findViewById(R.id.nomeConjugeEt);
        sobrenomeConjugeEt = findViewById(R.id.sobrenomeConjugeEt);
        sexoRg = findViewById(R.id.sexoRg);
        masculinoRb = findViewById(R.id.masculinoRb);
    }

    public void save(View view){
        Toast.makeText(this, "clicou no salvar", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view){
        Toast.makeText(this, "clicou no limpar", Toast.LENGTH_SHORT).show();
    }
}