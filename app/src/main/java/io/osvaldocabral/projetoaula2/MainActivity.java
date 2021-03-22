package io.osvaldocabral.projetoaula2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextTextPersonName);
        pswd = findViewById(R.id.editTextTextPassword);
    }

    public void onLoginClicked(View view) {
        if(isValidLogin(getName(), getPassword())) startActivityTitle(view);
        else Toast.makeText(MainActivity.this, R.string.message_login_incorreto, Toast.LENGTH_SHORT).show();
    }

    public String getName() {
        return name.getText().toString();
    }

    public String getPassword() {
        return pswd.getText().toString();
    }

    public void startActivityTitle(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityTitle.class);
        intent.putExtra("user_name", getName());
        startActivity(intent);
    }

    public boolean isValidLogin(String login, String password) {
        if(login.equals("admin") && password.equals("admin@123")) return true;
        return false;
    }
}