package mx.udg.cucea.rest_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtUser, txtTitle,txtBody;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotogetData(View view){
        startActivity(new Intent(MainActivity.this,get_data.class));
    }
    public void gotopostData(View v){
        startActivity(new Intent(MainActivity.this,post_data.class));
    }
    public void gotoputData(View view){
        startActivity(new Intent(MainActivity.this,change_data.class));
    }
    public void gotodeleteDAta(View view){
        startActivity(new Intent(MainActivity.this,delete_data.class));
    }
// GET json
  /*  private void leerWs(){
        String url ="https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUser.setText(jsonObject.getString( "userId"));
                    txtTitle.setText(jsonObject.getString("title"));
                    txtBody.setText(jsonObject.getString("body"));

                }
                catch(JSONException e){}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.getMessage());
            }
        }
        );
        Volley.newRequestQueue(this).add(postRequest);
    }
*/
    /*
    private void guardarWs(final String title, final String body, final String userId){
        String url ="https://jsonplaceholder.typicode.com/posts";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this,"Resultado ="+ response, Toast.LENGTH_LONG).show();


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
*/
/*
    private void actualizaWs(final String title, final String body, final String userId){
        String url ="https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Toast.makeText(MainActivity.this,"Resultado ="+ response, Toast.LENGTH_LONG).show();


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
            params.put("id","1");
            params.put ("title", title);
            params.put ("body", body);
            params.put ("userId", userId);
            return params;

        }

        };

        Volley.newRequestQueue(this).add(postRequest);
    }
*/
/*
    private void eliminarWs(){
        String url ="https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                  Toast.makeText(MainActivity.this,"Elemento Eliminado", Toast.LENGTH_LONG).show();


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
*/
}