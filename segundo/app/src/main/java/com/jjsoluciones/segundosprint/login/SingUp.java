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

public class SingUp extends AppCompatActivity{
    private EditText edName;
    private EditText edUserName;
    private EditText edPass;
    private EditText edPass1;

    private Button btSignUp;
    private Button btCancel;


    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        edName = (EditText)findViewById(R.id.ed_name);
        edUserName =(EditText)findViewById(R.id.ed_username);
        edPass = (EditText)findViewById(R.id.ed_password);
        edPass1 = (EditText)findViewById(R.id.ed_password_repeat);

        btSignUp = (Button)findViewById(R.id.bt_sign_up);
        btCancel = (Button)findViewById(R.id.bt_cancelar);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSingUpClick(v);
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUserName.setText("");
                edName.setText("");
                edPass1.setText("");
                edPass.setText("");
            }
        });
    }

    public void onSingUpClick(View v){
        if (v.getId() == R.id.bt_sign_up) {
            String name = edName.getText().toString();
            String userName = edUserName.getText().toString();
            String pass = edPass.getText().toString();
            String pass1 = edPass1.getText().toString();

            if(name.isEmpty() || userName.isEmpty() || pass.isEmpty() || pass1.isEmpty() && pass == pass1){
                Toast vacio = Toast.makeText(SingUp.this,"No puede haber campos vacios, " +
                        "las contraseñas tienen que ser iguales ",Toast.LENGTH_SHORT);
                vacio.show();
            }else {
                User user = new User();
                user.setNameUser(userName);
                user.setUser(name);
                user.setPassword(pass);

                helper.inserUser(user);

                Intent i = new Intent(this, Login.class);
                startActivity(i);

                edUserName.setText("");
                edName.setText("");
                edPass1.setText("");
                edPass.setText("");
            }

        }
    }
}
