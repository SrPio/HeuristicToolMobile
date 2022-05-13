package com.example.heuristictoolmobile_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class CrearEvaluacion extends AppCompatActivity implements View.OnClickListener {

    // DropDown menú de Tipo implementación
    TextInputLayout til_implementacion;
    AutoCompleteTextView act_implementacion;

    ArrayList<String> arrayList_implementacion;
    ArrayAdapter<String> arrayAdapter_implementacion;

    // DropDown menú de Tipo Aplicación
    TextInputLayout til_aplicacion;
    AutoCompleteTextView act_aplicacion;

    ArrayList<String> arrayList_aplicacion;
    ArrayAdapter<String> arrayAdapter_aplicacion;

    // --

    Button btn_datePicker;
    EditText editTextDate;
    private int dia,mes,año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_evaluacion);

        // DropDown menú de Tipo implementación

        til_implementacion = (TextInputLayout)findViewById(R.id.textInputLayoutImplementacion);
        act_implementacion = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView_TipoImplementacion);

        arrayList_implementacion = new ArrayList<>();
        arrayList_implementacion.add("Escritorio");
        arrayList_implementacion.add("Web");
        arrayList_implementacion.add("Móvil");

        arrayAdapter_implementacion = new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,arrayList_implementacion);
        act_implementacion.setAdapter(arrayAdapter_implementacion);

        act_implementacion.setThreshold(1);

        // --

        // DropDown menú de Tipo Aplicación
        til_aplicacion = (TextInputLayout)findViewById(R.id.textInputLayoutAplicacion);
        act_aplicacion = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView_TipoAplicacion);

        arrayList_aplicacion = new ArrayList<>();
        arrayList_aplicacion.add("OVA");
        arrayList_aplicacion.add("Páginas académicas");
        arrayList_aplicacion.add("Páginas Gubernamentales");
        arrayList_aplicacion.add("Juegos Serios");
        arrayList_aplicacion.add("Otro tipo de aplicación");

        arrayAdapter_aplicacion = new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,arrayList_aplicacion);
        act_aplicacion.setAdapter(arrayAdapter_aplicacion);

        act_aplicacion.setThreshold(1);

        // --

        btn_datePicker = (Button) findViewById(R.id.btn_datePicker);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        btn_datePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btn_datePicker) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    editTextDate.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,año, mes, dia);
            datePickerDialog.show();
        }
    }
}