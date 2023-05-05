package com.tankarsolutions.finddotsbraintraininggame.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/viewmodel/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "gameRepository", "Lcom/tankarsolutions/finddotsbraintraininggame/repo/GameRepository;", "(Lcom/tankarsolutions/finddotsbraintraininggame/repo/GameRepository;)V", "getAllData", "Landroidx/lifecycle/LiveData;", "", "Lcom/tankarsolutions/finddotsbraintraininggame/entity/GameDB;", "insertData", "Lkotlinx/coroutines/Job;", "gameDB", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    private final com.tankarsolutions.finddotsbraintraininggame.repo.GameRepository gameRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertData(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.entity.GameDB gameDB) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.tankarsolutions.finddotsbraintraininggame.entity.GameDB>> getAllData() {
        return null;
    }
    
    public GameViewModel(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.repo.GameRepository gameRepository) {
        super();
    }
}