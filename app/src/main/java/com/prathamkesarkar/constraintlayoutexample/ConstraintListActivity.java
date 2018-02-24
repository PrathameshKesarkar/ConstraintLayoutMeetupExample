package com.prathamkesarkar.constraintlayoutexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prathamkesarkar.constraintlayoutexample.adapter.ConstraintExampleAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by patty on 14/10/17.
 */

public class ConstraintListActivity extends AppCompatActivity {


    Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_constraint_layout);

        ConstraintLayout constraintLayout = findViewById(R.id.main);

        unbinder = ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ConstraintExampleAdapter adapter = new ConstraintExampleAdapter(this, shrinkedViewList());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    public ArrayList<Boolean> shrinkedViewList() {
        ArrayList<Boolean> shrinkedList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shrinkedList.add(false);
        }
        return shrinkedList;
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
