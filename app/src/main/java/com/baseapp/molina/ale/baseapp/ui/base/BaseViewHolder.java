package com.baseapp.molina.ale.baseapp.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Amolina on 02/02/17.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);

}
