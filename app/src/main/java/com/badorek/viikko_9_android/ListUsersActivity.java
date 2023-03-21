package com.badorek.viikko_9_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ListUsersActivity extends AppCompatActivity {

    private UserStorage userStorage;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        userStorage = UserStorage.getInstance();

        recyclerView = findViewById(R.id.rvUserList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), userStorage.getUsers()));

    }

    public void removeUser(View view) {
        EditText userId = findViewById(R.id.editTextRemoveUser);
        String number = userId.getText().toString();
        int id = Integer.parseInt(number);
        userStorage.removeUser(id);
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }
    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}