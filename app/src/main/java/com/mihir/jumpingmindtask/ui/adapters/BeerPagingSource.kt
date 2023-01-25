package com.mihir.jumpingmindtask.ui.adapters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mihir.jumpingmindtask.INITIAL_PAGE_INDEX
import com.mihir.jumpingmindtask.model.BeerDataItem
import com.mihir.jumpingmindtask.network.NetworkService

class BeerPagingSource(private val networkService: NetworkService): PagingSource<Int, BeerDataItem>() {

    override fun getRefreshKey(state: PagingState<Int, BeerDataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BeerDataItem> {
        val pageIndex = params.key ?: INITIAL_PAGE_INDEX

        return try {
            val response = networkService.getBeerData(
                page = pageIndex
            )

            val transactions = response.body()!!

            val nextKey =
                if (transactions.isEmpty()) {
                    null
                } else {
                    pageIndex + 1
                }
            LoadResult.Page(
                data = transactions,
                prevKey = if (pageIndex == INITIAL_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }

    }

}