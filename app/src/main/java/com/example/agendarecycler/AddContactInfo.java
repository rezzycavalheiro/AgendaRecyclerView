package com.example.agendarecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.util.ArrayList;

public class AddContactInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextNameItem;
    EditText editTextAddressItem;
    EditText editTextPhoneItem;
    private Button saveItem;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_info);

        editTextNameItem = findViewById(R.id.editTextNameItem);
        editTextAddressItem = findViewById(R.id.editTextAddressItem);
        editTextPhoneItem = findViewById(R.id.editTextPhoneItem);
        saveItem = (Button) findViewById(R.id.buttonSaveItem);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void buttonSaveItemOnClick(View view) {
        String itemName = editTextNameItem.getText().toString();
        String itemAddress = editTextAddressItem.getText().toString();
        String itemPhone = editTextPhoneItem.getText().toString();
        String itemPhoneType = spinner.getSelectedItem().toString();

        DataModel.getInstance().userArray.add(new UserInfo(itemName, itemAddress, itemPhone, itemPhoneType));

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}