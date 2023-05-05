package com.tankarsolutions.finddotsbraintraininggame.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\"J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000eH\u0002J(\u00108\u001a\u0002092\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000e0 j\b\u0012\u0004\u0012\u00020\u000e`;2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0012\u0010=\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u000209H\u0014J\b\u0010A\u001a\u000209H\u0003J\u0010\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020\u000eH\u0003J\u0018\u0010D\u001a\u0002092\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010&R\u001a\u0010\'\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010&R\u000e\u0010-\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010&\u00a8\u0006F"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/activity/GameActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter;", "callback", "Lcom/google/android/gms/ads/rewarded/RewardedAdCallback;", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "constraintSet$delegate", "Lkotlin/Lazy;", "extra", "", "getExtra", "()I", "setExtra", "(I)V", "gameViewModel", "Lcom/tankarsolutions/finddotsbraintraininggame/viewmodel/GameViewModel;", "getGameViewModel", "()Lcom/tankarsolutions/finddotsbraintraininggame/viewmodel/GameViewModel;", "gameViewModel$delegate", "mInterstitialAd", "Lcom/google/android/gms/ads/InterstitialAd;", "onDotClick", "Lcom/tankarsolutions/finddotsbraintraininggame/adapter/DotAdapter$OnDotClick;", "pressCounter", "getPressCounter", "setPressCounter", "randomNumbers", "Ljava/util/ArrayList;", "rewardId", "", "rewardedAd", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "rightAnswer", "Ljava/lang/Integer;", "rightCounter", "getRightCounter", "setRightCounter", "soundPool", "Landroid/media/SoundPool;", "stopTimerSoundPool", "tEnd", "", "tStart", "timer", "Landroid/os/CountDownTimer;", "wrongAnswer", "createAndLoadRewardedAd", "id", "findResultEnum", "Lcom/tankarsolutions/finddotsbraintraininggame/utils/ResultEnum;", "percentage", "generateRandom", "", "arrayList", "Lkotlin/collections/ArrayList;", "mode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "retry", "showGameInfoDialog", "dots", "showResultDialog", "rightAnswers", "app_debug"})
public final class GameActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.gms.ads.rewarded.RewardedAdCallback callback;
    private java.lang.Integer stopTimerSoundPool;
    private java.lang.Integer rightAnswer;
    private java.lang.Integer wrongAnswer;
    private android.media.SoundPool soundPool;
    private android.os.CountDownTimer timer;
    private final java.util.ArrayList<java.lang.Integer> randomNumbers = null;
    private com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter adapter;
    private long tStart = 0L;
    private long tEnd = 0L;
    private final kotlin.Lazy gameViewModel$delegate = null;
    private com.google.android.gms.ads.InterstitialAd mInterstitialAd;
    private com.google.android.gms.ads.rewarded.RewardedAd rewardedAd;
    private java.lang.String rewardId = "";
    private int pressCounter = 0;
    private int rightCounter = 0;
    private int extra = 0;
    private final com.tankarsolutions.finddotsbraintraininggame.adapter.DotAdapter.OnDotClick onDotClick = null;
    private final kotlin.Lazy constraintSet$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.tankarsolutions.finddotsbraintraininggame.viewmodel.GameViewModel getGameViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final int getPressCounter() {
        return 0;
    }
    
    public final void setPressCounter(int p0) {
    }
    
    public final int getRightCounter() {
        return 0;
    }
    
    public final void setRightCounter(int p0) {
    }
    
    public final int getExtra() {
        return 0;
    }
    
    public final void setExtra(int p0) {
    }
    
    private final void generateRandom(java.util.ArrayList<java.lang.Integer> arrayList, int mode) {
    }
    
    private final androidx.constraintlayout.widget.ConstraintSet getConstraintSet() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showGameInfoDialog(int dots) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void showResultDialog(int dots, int rightAnswers) {
    }
    
    private final com.tankarsolutions.finddotsbraintraininggame.utils.ResultEnum findResultEnum(int percentage) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void retry() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.ads.rewarded.RewardedAd createAndLoadRewardedAd(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public GameActivity() {
        super();
    }
}