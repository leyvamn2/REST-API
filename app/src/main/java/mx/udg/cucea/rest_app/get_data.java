package mx.udg.cucea.rest_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class get_data extends AppCompatActivity {

    EditText txtid, txtUserId, txtTitle, txtBody;
    Button btnConsulta, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        txtid= findViewById(R.id.txtid);
        txtUserId =findViewById(R.id.txtUserId);
        txtBody = findViewById(R.id.txtBody);
        txtTitle = findViewById(R.id.txtTitle);
        btnConsulta = findViewById(R.id.btnConsulta);
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
    }
    public void gotoMain(View view){
        startActivity(new Intent(get_data.this,MainActivity.class));
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
}