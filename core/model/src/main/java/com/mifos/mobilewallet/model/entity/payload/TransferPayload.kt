package com.mifos.mobilewallet.model.entity.payload

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransferPayload(
    @SerializedName("fromOfficeId")
    var fromOfficeId: Int? = null,

    @SerializedName("fromClientId")
    var fromClientId: Long? = null,

    @SerializedName("fromAccountType")
    var fromAccountType: Int? = null,

    @SerializedName("fromAccountId")
    var fromAccountId: Int? = null,

    @SerializedName("toOfficeId")
    var toOfficeId: Int? = null,

    @SerializedName("toClientId")
    var toClientId: Long? = null,

    @SerializedName("toAccountType")
    var toAccountType: Int? = null,

    @SerializedName("toAccountId")
    var toAccountId: Int? = null,

    @SerializedName("transferDate")
    var transferDate: String? = null,

    @SerializedName("transferAmount")
    var transferAmount: Double? = null,

    @SerializedName("transferDescription")
    var transferDescription: String? = null,
    var dateFormat: String? = "dd MMMM yyyy",
    var locale: String? = "en"
) : Parcelable {
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null)
}
