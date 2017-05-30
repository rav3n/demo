package com.amurnet.coupon.v2.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController

abstract class ButterKnifeController<V : MvpView?, P : MvpPresenter<V>?> : MvpController<V, P> {
    constructor() : super()
    constructor(args: Bundle) : super(args)

    private lateinit var unbinder: Unbinder

    abstract fun inflate(inflater: LayoutInflater, container: ViewGroup) : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view: View = inflate(inflater, container)
        unbinder = ButterKnife.bind(this, view)
        onBindView(view)
        return view
    }

    protected open fun onBindView(view: View) {}

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        unbind()
    }

    private fun unbind() {
        unbinder.unbind()
    }

    fun getString(resId: Int) = activity!!.getString(resId)!!
    fun getDrawable(redId: Int) = activity!!.resources.getDrawable(redId)!!
    fun getColor(redId: Int) = activity!!.resources.getColor(redId)!!
}