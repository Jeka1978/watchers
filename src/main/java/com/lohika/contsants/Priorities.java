package com.lohika.contsants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 20/12/2016.
 */
public interface Priorities {
    String DRAMA = "drama";
    String ACTION = "action";
    String HORROR = "horror";
    String COMEDY = "comedy";

    List<String> GENRES = Arrays.asList(DRAMA, ACTION, HORROR, COMEDY);
}
