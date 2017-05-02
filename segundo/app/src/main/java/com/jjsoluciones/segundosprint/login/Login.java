package com.jjsoluciones.segundosprint.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjsoluciones.segundosprint.MainActivity;
import com.jjsoluciones.segundosprint.R;

public class Login extends AppCompatActivity {
    private EditText edUserName;
    private EditText edPassword;
    private Button btLogin;
    private Button btSingUp;

    private DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = (EditText)findViewById(R.id.ed_username_login);
        edPassword = (EditText)findViewById(R.id.ed_password_login);

        btLogin = (Button)findViewById(R.id.bt_login);
        btSingUp = (Button)findViewById(R.id.bt_sing_up_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString();
                String pass = edPassword.getText().toString();

                String password = helper.searchUser(username);

                if (pass.equals(password)){
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Login.this,"Contraseña o Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,SingUp.class);
                startActivity(i);
            }
        });
    }
}
