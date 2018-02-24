package com.prathamkesarkar.constraintlayoutexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by patty on 07/11/17.
 */

public class GroupActivity extends AppCompatActivity {

    @BindView(R.id.btn_grp)
    Group group;

    private Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        unbinder = ButterKnife.bind(this);

    }

    @OnClick(R.id.delete)
    public void clickedDelete(){
        group.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
