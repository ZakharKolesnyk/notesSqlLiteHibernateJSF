package com.gmail.kolesnyk.zakhar.notes;

/**
 * The {@code STATE} enum of states {@link Note}
 *
 * @author Kolesnyk Zakhar
 * @see com.gmail.kolesnyk.zakhar.notes.Note
 * @since JDK1.8
 */
public enum STATE {

    /**
     * waiting state of {@link Note}
     */
    WAITING,

    /**
     * performing state of {@link Note}
     */
    PERFORMING,

    /**
     * done state of {@link Note}
     */
    DONE
}
