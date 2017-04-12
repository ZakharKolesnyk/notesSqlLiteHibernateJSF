package com.gmail.kolesnyk.zakhar.notes;

import com.gmail.kolesnyk.zakhar.BaseDao;

import java.util.List;

public interface NoteDao extends BaseDao<Note, Integer>{
    List<Note> byState(STATE state);
    List<Note> byStateSublist(STATE state, int amount, int  indexStart);
}
