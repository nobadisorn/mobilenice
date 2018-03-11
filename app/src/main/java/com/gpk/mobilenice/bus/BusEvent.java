package com.gpk.mobilenice.bus;

import com.squareup.otto.Bus;

/**
 * Created by nobtingtong on 11/3/2018 AD.
 */

public class BusEvent {
    private static Bus bus;

    public static Bus newInstant() {
        if (bus == null) bus = new Bus();
        return bus;
    }
}
