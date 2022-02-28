package com.example.auction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.auction.DAO.UserDAO;
import com.example.auction.database.UserDatabase;
import com.example.auction.model.User;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail;
    EditText edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();

    }

    private void bindingAction() {
        btnLogin.setOnClickListener(view -> Login(view));
    }

    private void Login(View view) {
        String valueEmail = edtEmail.getText().toString();
        String valuePassword = edtPassword.getText().toString();
        User user = new User(valueEmail, valuePassword);
        UserDatabase.getInstance(this).userDAO().insertUser(user);
        System.out.println("checlll");
    }

    private void bindingView() {

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
}