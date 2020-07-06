/*
 * Copyright 10/10/2018 Hahalolo. All rights reserved.
 *
 * https://help.hahalolo.com/commercial_terms/
 */

package com.example.demoroomapp.data.util;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({StatusNetwork.SUCCESS, StatusNetwork.ERROR, StatusNetwork.LOADING})
@Retention(RetentionPolicy.SOURCE)
public @interface StatusNetwork {
    int SUCCESS = 0;
    int ERROR = 1;
    int LOADING = 2;
}
