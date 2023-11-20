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

public class change_data extends AppCompatActivity {

    EditText txtid, txtUserId, txtTitle, txtBody;
    Button btnConsulta, btnLimpiar, btnRegresar, btnActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_data);
        txtid= findViewById(R.id.txtid);
        txtUserId =findViewById(R.id.txtUserId);
        txtBody = findViewById(R.id.txtBody);
        txtTitle = findViewById(R.id.txtTitle);
        btnConsulta = findViewById(R.id.btnConsulta);
        btnActualizar= findViewById(R.id.btnmodificar);
        btnLimpiar= findViewById(R.id.btnlimpiar);
        btnRegresar= findViewById(R.id.btnregresar);
        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtid.getText().toString()!=""){
                    leerWs(txtid.getText().toString());
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtid.setText("");
                txtUserId.setText("");
                txtBody.setText("");
                txtTitle.setText("");
            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                actualizaWs(txtid.getText().toString(),txtUserId.getText().toString(),txtTitle.getText().toString(),txtBody.getText().toString());
            }
        });
    }

    private void leerWs(String id){

        String url ="https://jsonplaceholder.typicode.com/posts/"+id;
        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUserId.setText(jsonObject.getString("userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txtBody.setText(jsonObject.getString("body"));

                } catch (JSONException exception) {
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        Volley.newRequestQueue(this).add(postRequest);
    }

    private void actualizaWs(final String id, final String userId, final String title, final String body){
        String idModify=txtid.getText().toString();
        String url ="https://jsonplaceholder.typicode.com/posts/"+idModify;
        StringRequest postRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(change_data.this,"Resultado ="+ response, Toast.LENGTH_LONG).show();
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
            params.put("id",id);
            params.put ("userId", userId);
            params.put ("title", title);
            params.put ("body", body);
            return params;

        }

        };

        Volley.newRequestQueue(this).add(postRequest);
    }
    public void gotoMain(View view){
        startActivity(new Intent(change_data.this,MainActivity.class));
    }
}