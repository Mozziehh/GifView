package com.example.wubagifview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.wubagifview.widget.FrescoAdapter;
import com.example.wubagifview.R;
import com.example.wubagifview.utils.DataUtils;

public class GifFrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        FrescoAdapter adapter = new FrescoAdapter(this, DataUtils.getFrescoImageData());
        recyclerView.setAdapter(adapter);

    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context, GifFrescoActivity.class);
        context.startActivity(intent);
    }
}
