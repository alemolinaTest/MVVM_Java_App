package com.baseapp.molina.ale.baseapp.rx;

import io.reactivex.Scheduler;

/**
 * Created by Amolina on 02/02/17.
 */

public interface SchedulerProvider {

    Scheduler ui();//observeOn

    Scheduler computation();

    Scheduler io();//subscribeOn

}
