package com.example.agendarecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.security.ProtectionDomain;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ItemArrayAdapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_item) {
            DataModel.getInstance().userArray.add(0,
                    new UserInfo("Joao", "Rua RJ, 567", "3345-9898", "Trabalho"));
            adapter.notifyItemInserted(0);
            View contentView = findViewById(android.R.id.content);
            Snackbar.make(contentView, "Contact added", Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DataModel.getInstance().userArray.remove(0);
                            adapter.notifyItemRangeRemoved(0, 1);
                        }
                    })
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void addButtonClicked(View view){
//        DataModel.getInstance().userArray.add(
//                new UserInfo("item", "", "", "")
//        );
//         adapter.notifyItemInserted(DataModel.getInstance().userArray.size()-1);
        Intent intent = new Intent(this, AddContactInfo.class);
        startActivity(intent);
    }
}