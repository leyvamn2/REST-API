package mx.udg.cucea.rest_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class post_data extends AppCompatActivity {
    EditText txtUser, txtTitle,txtBody;
    Button btnEnviar,btnlimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);
        txtUser =findViewById(R.id.txtUser);
        txtBody = findViewById(R.id.txtBody);
        txtTitle = findViewById(R.id.txtTitle);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnlimpiar= findViewById(R.id.btnlimpiar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarWs(txtTitle.getText().toString(),txtBody.getText().toString(),txtUser.getText().toString());

            }
        });
        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUser.setText("");
                txtBody.setText("");
                txtTitle.setText("");
            }
        });
    }
    private void guardarWs(final String title, final String body, final String userId){
        String url ="https://jsonplaceholder.typicode.com/posts";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(post_data.this,"Resultado ="+ response, Toast.LENGTH_LONG).show();
                }
                catch(JSONException e){}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        })
        { protected Map<String,String> getParams(){
            Map<String, String> params = new HashMap<>();
            params.put ("title", title);
            params.put ("body", body);
            params.put ("userId", userId);
            return params;

        }

        };

        Volley.newRequestQueue(this).add(postRequest);
    }
    public void gotoMain(View view){
        startActivity(new Intent(post_data.this,MainActivity.class));
    }
}