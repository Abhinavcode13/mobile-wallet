package org.mifospay.core.network.services

import com.mifospay.core.model.entity.Page
import com.mifospay.core.model.entity.accounts.savings.SavingAccount
import com.mifospay.core.model.entity.accounts.savings.SavingsWithAssociations
import com.mifospay.core.model.entity.accounts.savings.Transactions
import org.mifospay.core.network.ApiEndPoints
import org.mifospay.core.network.GenericResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface SavingsAccountsService {
    @GET(ApiEndPoints.SAVINGS_ACCOUNTS + "/{accountId}")
    fun getSavingsWithAssociations(
        @Path("accountId") accountId: Long,
        @Query("associations") associationType: String
    ): Observable<SavingsWithAssociations>

    @GET(ApiEndPoints.SAVINGS_ACCOUNTS)
    fun getSavingsAccounts(
        @Query("limit") limit: Int
    ): Observable<Page<SavingsWithAssociations>>

    @POST(ApiEndPoints.SAVINGS_ACCOUNTS)
    fun createSavingsAccount(@Body savingAccount: SavingAccount): Observable<GenericResponse>

    @POST(ApiEndPoints.SAVINGS_ACCOUNTS + "/{accountId}")
    fun blockUnblockAccount(
        @Path("accountId") accountId: Long,
        @Query("command") command: String?
    ): Observable<GenericResponse>

    @GET(
        ApiEndPoints.SAVINGS_ACCOUNTS + "/{accountId}/" + ApiEndPoints.TRANSACTIONS
                + "/{transactionId}"
    )
    fun getSavingAccountTransaction(
        @Path("accountId") accountId: Long,
        @Path("transactionId") transactionId: Long
    ): Observable<Transactions>

    @POST(
        ApiEndPoints.SAVINGS_ACCOUNTS + "/{accountId}/" + ApiEndPoints.TRANSACTIONS
                + "?command=deposit"
    )
    fun payViaMobile(@Path("accountId") accountId: Long): Observable<Transactions>
}
