package com.example.apiadd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiadd.common.DataChecker;
import com.example.apiadd.screens.SingUpActivity;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.apiadd.common.DataChecker.Message;
import static com.example.apiadd.common.DataChecker.Proverka;

public class MainActivity extends AppCompatActivity {
    EditText emailET,passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailET = findViewById(R.id.ET_Email);
        passwordET = findViewById(R.id.ET_Password);
    }
    public  void Alert ()
        {
             AlertDialog.Builder builder = new AlertDialog.Builder(this);
//             TextView email = new TextView(this);
//             TextView password = new TextView(this);
//            password.setInputType(InputType.TYPE_CLASS_TEXT);
//            email.setInputType(InputType.TYPE_CLASS_TEXT);
//            builder.setView(email);
//            builder.setView(password);
            builder.setMessage("Логин: "+emailET.getText()+" пароль: "+passwordET.getText());
            builder.show();
        }

    public void AddUser(View view) {
        Intent intent = new Intent(MainActivity.this, SingUpActivity.class);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this
                ,getResources().getString(R.id.ET_Password).,)
        startActivities();
    }

    public void SignUp(View view) throws JSONException {
        if(Proverka(emailET.getText().toString())) {
            RequestQueue queue = Volley.newRequestQueue(this);
            JSONObject user = new JSONObject();
            user.put("email", emailET.getText());
            user.put("password", passwordET.getText());

            String url = "https://reqres.in/api/users";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, user, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Alert();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            queue.add(request);
        }
        else Message("Неверный логин",MainActivity.this);
    }
}