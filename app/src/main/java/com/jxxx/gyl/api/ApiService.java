package com.jxxx.gyl.api;


import com.jxxx.gyl.app.ConstValues;
import com.jxxx.gyl.base.CommodityCategory;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET(ConstValues.BASE_URL + "api/v1/circle/task/query")
    Observable<Result> getTaskCircleQuery();

    @GET(ConstValues.BASE_URL + "category/listAll")
    Observable<Result<List<CommodityCategory.ListBean>>> getCategoryListAll();

}
