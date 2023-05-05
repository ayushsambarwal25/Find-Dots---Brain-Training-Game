package com.tankarsolutions.finddotsbraintraininggame.utils

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.ceil
import kotlin.math.roundToInt

class SpanningGridLayoutManager(
    context: Context,
    spanCount: Int,
    orientation: Int,
    reverseLayout: Boolean
) : GridLayoutManager(
    context,
    spanCount,
    orientation,
    reverseLayout
) {

    private val horizontalSpace: Int
        get() = width - paddingRight - paddingLeft

    private val verticalSpace: Int
        get() = height - paddingBottom - paddingTop

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateDefaultLayoutParams())
    }

    override fun generateLayoutParams(c: Context, attrs: AttributeSet): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(c, attrs))
    }

    override fun generateLayoutParams(lp: ViewGroup.LayoutParams): RecyclerView.LayoutParams {
        return spanLayoutSize(super.generateLayoutParams(lp))
    }

    private fun spanLayoutSize(layoutParams: RecyclerView.LayoutParams): RecyclerView.LayoutParams {
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            layoutParams.width =
                (horizontalSpace / ceil((itemCount / spanCount).toDouble())).roundToInt()
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            layoutParams.height =
                (verticalSpace / ceil((itemCount / spanCount).toDouble())).roundToInt()
        }
        return layoutParams
    }

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return false
    }
}
