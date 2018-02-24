package com.prathamkesarkar.constraintlayoutexample.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.prathamkesarkar.constraintlayoutexample.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Created by patty on 22/10/17.
 */

public class ConstraintExampleAdapter extends RecyclerView.Adapter<ConstraintExampleAdapter.ConstraintViewHolder> {

    LayoutInflater inflater;

    //We maintained the list boolean to maintain the state of the individual item.
    ArrayList<Boolean> expandedViewList;
    public ConstraintExampleAdapter(Context context,ArrayList<Boolean> expandedViewList) {
        inflater = LayoutInflater.from(context);
        this.expandedViewList= expandedViewList;
    }

    @Override
    public ConstraintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_constraint_layout, parent, false);
        return new ConstraintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ConstraintViewHolder holder, final int position) {


        //Check the existing state of the item.
        if (expandedViewList.get(position)) {
            holder.expandedConstraintSet.applyTo(holder.constraintLayout);
        } else {
            holder.shrinkedConstraintSet.applyTo(holder.constraintLayout);
        }


        //flip the state of the item.
        holder.expandView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExpanded = expandedViewList.get(position);
                if (!isExpanded) {

                    //Used for smooth transition.
                    holder.expandedConstraintSet.applyTo(holder.constraintLayout);

                    TransitionManager.beginDelayedTransition(holder.constraintLayout);

                    expandedViewList.set(position,true);
                    holder.expandView.setImageResource(R.drawable.up_black);

                } else {
                    holder.shrinkedConstraintSet.applyTo(holder.constraintLayout);
                    TransitionManager.beginDelayedTransition(
                            holder.constraintLayout,new TransitionSet()
                                    .addTransition(new AutoTransition())
                                    .setDuration(300)
                                    .setInterpolator(new FastOutSlowInInterpolator()));

                    expandedViewList.set(position,false);
                    holder.expandView.setImageResource(R.drawable.down_black);

                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return 10;
    }

    public class ConstraintViewHolder extends RecyclerView.ViewHolder {

        ImageButton expandView;

        ConstraintLayout constraintLayout;

        private ConstraintSet shrinkedConstraintSet = new ConstraintSet();
        private ConstraintSet expandedConstraintSet = new ConstraintSet();

        public ConstraintViewHolder(View itemView) {
            super(itemView);
            expandView = itemView.findViewById(R.id.expand_view);

            constraintLayout = itemView.findViewById(R.id.main);
            shrinkedConstraintSet.clone(constraintLayout);
            expandedConstraintSet.clone(itemView.getContext(), R.layout.list_item_constraint_layout_detail);
        }

    }
}
