package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Model> list;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout errorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recycle);
        list = new ArrayList<>();
        errorLayout = findViewById(R.id.errorLayout);
        adapter = new Adapter(this, list);

        // Formatting adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Setting the progress dialog
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait as we load your data...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        StringRequest request = new StringRequest("http://192.168.52.181/jalikoa/index.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int loop = 0; loop < array.length(); loop++) {
                                JSONObject object = array.getJSONObject(loop);
                                list.add(new Model(
                                        object.getString("regno"),
                                        object.getString("fullname"),
                                        object.getString("gender"),
                                        object.getString("programe"),
                                        object.getString("college"),
                                        object.getString("date")
                                ));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            showAlert("Error Occurred", "Message: " + e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dialog.dismiss();
                        displayError("Please try again later. Error: " + error.toString());
                    }
                });

        Volley.newRequestQueue(this).add(request);
    }

    private void displayError(String putError) {
        Snackbar.make(findViewById(android.R.id.content), putError, Snackbar.LENGTH_LONG).show();
    }

    private void showAlert(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity2.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
