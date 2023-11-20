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

public class delete_data extends AppCompatActivity {
    EditText id;
    Button btnEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        id=findViewById(R.id.txtid);
        btnEliminar=findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString()!=""){
                    eliminarWs(id.getText().toString());
                }
                id.setText("");
            }
        });

    }
    public void gotoMain(View view){
        startActivity(new Intent(delete_data.this,MainActivity.class));
    }
    private void eliminarWs(String id){
        String url ="https://jsonplaceholder.typicode.com/posts/"+id;
        StringRequest postRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                   /* txtUser.setText(jsonObject.getString( "userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txtBody.setText(jsonObject.getString("body"));*/
                    Toast.makeText(delete_data.this,"Elemento Eliminado", Toast.LENGTH_LONG).show();


                }
                catch(JSONException e){}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });

        Volley.newRequestQueue(this).add(postRequest);

    }
}