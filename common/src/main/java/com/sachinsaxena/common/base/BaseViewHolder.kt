package com.sachinsaxena.common.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sachinsaxena.common.base.action.ActionPerformer

/**
Created by Sachin Saxena on 29/09/22.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var actionPerformer: ActionPerformer? = null

    abstract fun bind(data: T)

    open fun performAction(action: Any) {
        this.actionPerformer?.performAction(action)
    }
}
