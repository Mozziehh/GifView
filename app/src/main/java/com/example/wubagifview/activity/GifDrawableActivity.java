package com.example.wubagifview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wubagifview.widget.GifAdapter;
import com.example.wubagifview.R;
import com.example.wubagifview.utils.DataUtils;

public class GifDrawableActivity extends AppCompatActivity {
    ListView listView;
    GifAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifdrawable);
        listView = (ListView)findViewById(R.id.gif_list);
        adapter = new GifAdapter(this);
        adapter.setData(DataUtils.getImageData());
        listView.setAdapter(adapter);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context, GifDrawableActivity.class);
        context.startActivity(intent);
    }
}
