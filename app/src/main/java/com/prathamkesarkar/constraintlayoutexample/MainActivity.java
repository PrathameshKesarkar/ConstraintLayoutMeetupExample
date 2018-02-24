package com.prathamkesarkar.constraintlayoutexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by patty on 27/10/17.
 */

public class MainActivity extends AppCompatActivity {

    Unbinder unbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.list_activity_btn)
    public void openRecyclerViewActivity() {
        Intent intent = new Intent(this, ConstraintListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.bias_btn)
    public void openBiasActvity() {
        Intent intent = new Intent(this, BiasActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.desc_btn)
    public void openDescriptionActivity() {
        Intent intent = new Intent(this, DescriptionActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.place_holder_btn)
    public void openPlaceHolderActivity() {
        Intent intent = new Intent(this, PlaceHolderActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.grp_btn)
    public void openGroupActivity(){
        Intent  intent = new Intent(this,GroupActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.barrier_btn)
    public void openBarrierActivity(){
        Intent intent = new Intent(this,BarrierActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }


}
