package com.tankarsolutions.finddotsbraintraininggame.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tankarsolutions/finddotsbraintraininggame/repo/GameRepository;", "", "dao", "Lcom/tankarsolutions/finddotsbraintraininggame/dao/GameDao;", "(Lcom/tankarsolutions/finddotsbraintraininggame/dao/GameDao;)V", "getAllData", "Landroidx/lifecycle/LiveData;", "", "Lcom/tankarsolutions/finddotsbraintraininggame/entity/GameDB;", "insertData", "", "gameDB", "app_debug"})
public final class GameRepository {
    private final com.tankarsolutions.finddotsbraintraininggame.dao.GameDao dao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.tankarsolutions.finddotsbraintraininggame.entity.GameDB>> getAllData() {
        return null;
    }
    
    public final void insertData(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.entity.GameDB gameDB) {
    }
    
    public GameRepository(@org.jetbrains.annotations.NotNull()
    com.tankarsolutions.finddotsbraintraininggame.dao.GameDao dao) {
        super();
    }
}