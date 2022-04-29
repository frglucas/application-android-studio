package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.application.adapter.CommentAdapter;
import com.example.application.adapter.PostAdapter;
import com.example.application.model.Comment;
import com.example.application.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TerceiraActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/comments";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONArray response) {
        List<Comment> list = new ArrayList<>();

        for(int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                list.add(new Comment(response.getJSONObject(i).getInt("postId"),
                        response.getJSONObject(i).getInt("id"),
                        response.getJSONObject(i).getString("name"),
                        response.getJSONObject(i).getString("email"),
                        response.getJSONObject(i).getString("body")));
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }

        CommentAdapter cAdapter = new CommentAdapter(list);

        RecyclerView rv = findViewById(R.id.rvComments);
        rv.setAdapter(cAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rv.setLayoutManager(llm);
    }
}