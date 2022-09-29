package com.sachinsaxena.common.extensions

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

object RecyclerViewUtils {

    fun isRecyclerScrollable(recyclerView: RecyclerView): Boolean {
        val lastCompletelyVisiblePosition =
            when (val layoutManager = recyclerView.layoutManager) {
                is LinearLayoutManager -> layoutManager.findLastCompletelyVisibleItemPosition()
                is GridLayoutManager -> layoutManager.findLastCompletelyVisibleItemPosition()
                is StaggeredGridLayoutManager -> {
                    val array = IntArray(2)
                    layoutManager.findLastCompletelyVisibleItemPositions(array)
                    array[1]
                }
                else -> throw IllegalArgumentException("unidentified instance of LayoutManager")
            }
        val adapter = recyclerView.adapter
        return if (adapter == null) false else lastCompletelyVisiblePosition < adapter.itemCount - 1
    }
}


