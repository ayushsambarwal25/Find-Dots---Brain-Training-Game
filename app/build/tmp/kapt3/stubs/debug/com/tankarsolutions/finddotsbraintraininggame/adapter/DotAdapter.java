package com.tankarsolutions.finddotsbraintraininggame.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$MyDotAdapterHolder;", "onDotClick", "Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$OnDotClick;", "(Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$OnDotClick;)V", "value", "Ljava/util/ArrayList;", "", "dotList", "getDotList", "()Ljava/util/ArrayList;", "setDotList", "(Ljava/util/ArrayList;)V", "gameStarts", "", "getGameStarts", "()Z", "setGameStarts", "(Z)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyDotAdapterHolder", "OnDotClick", "app_debug"})
public final class DotAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.MyDotAdapterHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> dotList;
    private boolean gameStarts = false;
    private final com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.OnDotClick onDotClick = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getDotList() {
        return null;
    }
    
    public final void setDotList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> value) {
    }
    
    public final boolean getGameStarts() {
        return false;
    }
    
    public final void setGameStarts(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.MyDotAdapterHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.MyDotAdapterHolder holder, int position) {
    }
    
    public DotAdapter(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.OnDotClick onDotClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$OnDotClick;", "", "onclick", "", "isRight", "", "totalPressAllowed", "", "app_debug"})
    public static abstract interface OnDotClick {
        
        public abstract void onclick(boolean isRight, int totalPressAllowed);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$MyDotAdapterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dotImage", "Landroidx/appcompat/widget/AppCompatImageView;", "getDotImage", "()Landroidx/appcompat/widget/AppCompatImageView;", "app_debug"})
    public static final class MyDotAdapterHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.AppCompatImageView dotImage = null;
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getDotImage() {
            return null;
        }
        
        public MyDotAdapterHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}