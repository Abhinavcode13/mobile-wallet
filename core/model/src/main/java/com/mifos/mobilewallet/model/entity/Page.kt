package com.mifos.mobilewallet.model.entity

data class Page<T>(
    var totalFilteredRecords: Int = 0,
    var pageItems: MutableList<T> = ArrayList()
)
