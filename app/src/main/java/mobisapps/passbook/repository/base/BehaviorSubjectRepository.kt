package com.butlerhero.app.kotlin.repository

import rx.Observable
import rx.subjects.BehaviorSubject

open class BehaviorSubjectRepository<T>(defaultValue: T) : BaseRepository<T> {

    private val subject = BehaviorSubject.create(defaultValue)

    override fun toObservable(): Observable<T> {
        return subject
    }

    fun value(): T {
        return subject.value
    }

    fun updateValue(value: T) {
        subject.onNext(value)
    }

    fun emmit() {
        updateValue(value())
    }
}
