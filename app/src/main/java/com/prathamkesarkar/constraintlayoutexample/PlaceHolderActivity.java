package com.prathamkesarkar.constraintlayoutexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by patty on 07/11/17.
 */

public class PlaceHolderActivity extends AppCompatActivity {

    Unbinder unbinder;


    @BindView(R.id.template_action)
    Placeholder placeholder;

    @BindView(R.id.root)
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);
        unbinder= ButterKnife.bind(this);

    }

    @OnClick(R.id.save)
    public void onSaveClicked(View view){
        changePlaceHolderView(view.getId());
    }


    @OnClick(R.id.edit)
    public void onEditClicked(View view){
        changePlaceHolderView(view.getId());
    }

    @OnClick(R.id.cancel)
    public void onCancelClicked(View view){
        changePlaceHolderView(view.getId());
    }

    @OnClick(R.id.delete)
    public void onDeleteClicked(View view){
        changePlaceHolderView(view.getId());
    }

    public void changePlaceHolderView(int id){
        TransitionManager.beginDelayedTransition(constraintLayout);
        placeholder.setContentId(id);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
