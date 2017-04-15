package com.gmail.kolesnyk.zakhar.notes;

import com.gmail.kolesnyk.zakhar.BaseDao;

import java.util.List;

/**
 * The {@code NoteDao} class DAO for entity {@link Note}
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.AbstractDao
 * @see com.gmail.kolesnyk.zakhar.notes.NoteDaoImpl
 * @since JDK1.8
 */
public interface NoteDao extends BaseDao<Note, Integer> {

    /**
     * method allow to get {@link List<Note>} by state
     *
     * @param state enum of states {@link Note}
     * @return {@link List<Note>}
     */
    List<Note> byState(STATE state);

    /**
     * method allow to get {@link List<Note>} by state with specified amount and offset
     *
     * @param state      enum of states {@link Note}
     * @param amount     amount of {@link Note}
     * @param indexStart begin index from full selection of {@link List<Note>}
     * @return {@link List<Note>}
     */
    List<Note> byStateSublist(STATE state, int amount, int indexStart);
}
