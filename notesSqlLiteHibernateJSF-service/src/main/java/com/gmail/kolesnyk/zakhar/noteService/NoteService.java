package com.gmail.kolesnyk.zakhar.noteService;

import com.gmail.kolesnyk.zakhar.notes.Note;

import java.util.List;

/**
 * The {@code NoteService} contains service methods with entity class {@link Note}
 *
 * @author Kolesnyk Zakhar
 * @since JDK1.8
 */
public interface NoteService {

    /**
     * size of sublist
     */
    int SIZE_SUBLIST = 2;

    /**
     * method allow to get list of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#ASSIGNED}
     *
     * @return {@link List<Note>}
     */
    List<Note> assignedNotes();

    /**
     * method allow to get list of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#PERFORMING}
     *
     * @return {@link List<Note>}
     */
    List<Note> performingNotes();

    /**
     * method allow to get list of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#DONE}
     *
     * @return {@link List<Note>}
     */
    List<Note> doneNotes();

    /**
     * method allow to get sublist of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#ASSIGNED}
     * with size by {@link #SIZE_SUBLIST}
     *
     * @return {@link List<Note>}
     */
    List<Note> assignedNotesSublist();

    /**
     * method allow to get sublist of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#PERFORMING}
     * with size by {@link #SIZE_SUBLIST}
     *
     * @return {@link List<Note>}
     */
    List<Note> performingNotesSublist();

    /**
     * method allow to get sublist of all notes what have state {@link com.gmail.kolesnyk.zakhar.notes.STATE#DONE}
     * with size by {@link #SIZE_SUBLIST}
     *
     * @return {@link List<Note>}
     */
    List<Note> doneNotesSublist();

    /**
     * method allow to update note in Database
     *
     * @param note entity what need to update in Database
     */
    void update(Note note);

    /**
     * method allow to save note in Database
     *
     * @param note entity what need to save in Database
     */
    void save(Note note);
}
