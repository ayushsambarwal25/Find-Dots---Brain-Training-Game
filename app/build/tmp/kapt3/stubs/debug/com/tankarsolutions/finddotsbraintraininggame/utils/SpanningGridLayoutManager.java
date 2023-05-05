package com.tankarsolutions.finddotsbraintraininggame.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/utils/SpanningGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "horizontalSpace", "getHorizontalSpace", "()I", "verticalSpace", "getVerticalSpace", "canScrollHorizontally", "canScrollVertically", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "generateLayoutParams", "c", "attrs", "Landroid/util/AttributeSet;", "lp", "Landroid/view/ViewGroup$LayoutParams;", "spanLayoutSize", "layoutParams", "app_debug"})
public final class SpanningGridLayoutManager extends androidx.recyclerview.widget.GridLayoutManager {
    
    private final int getHorizontalSpace() {
        return 0;
    }
    
    private final int getVerticalSpace() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(@org.jetbrains.annotations.NotNull()
    android.content.Context c, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup.LayoutParams lp) {
        return null;
    }
    
    private final androidx.recyclerview.widget.RecyclerView.LayoutParams spanLayoutSize(androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams) {
        return null;
    }
    
    @java.lang.Override()
    public boolean canScrollVertically() {
        return false;
    }
    
    @java.lang.Override()
    public boolean canScrollHorizontally() {
        return false;
    }
    
    public SpanningGridLayoutManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(null, null, 0, 0);
    }
}