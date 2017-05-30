package com.butlerhero.app.kotlin.repository

import rx.Observable

interface BaseRepository<DataType> {
    fun toObservable(): Observable<DataType>
}