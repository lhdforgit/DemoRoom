/*
 * Copyright 10/10/2018 Hahalolo. All rights reserved.
 *
 * https://help.hahalolo.com/commercial_terms/
 */

package com.example.demoroomapp.data.util

import com.example.demoroomapp.data.util.StatusNetwork.LOADING
import com.example.demoroomapp.data.util.StatusNetwork.SUCCESS

class Resource<T> private constructor(val statusNetwork: Int, val data: T?, val message: String?) {

    val isUnauthorized: Boolean
        get() = statusNetwork == 401

    companion object {

        fun <T> success(data: T?,  msg: String): Resource<T> {
            return Resource(SUCCESS, data, msg)
        }

        fun <T> error(error: Int, msg: String, data: T?): Resource<T> {
            return Resource(error, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }

    override fun toString(): String {
        return "Resource(statusNetwork=$statusNetwork, data=$data, message=$message)"
    }
}
