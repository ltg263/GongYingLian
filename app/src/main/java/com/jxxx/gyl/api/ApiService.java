package com.jxxx.gyl.api;


import com.jxxx.gyl.app.ConstValues;

import javax.xml.transform.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET(ConstValues.PORT_21 + "api/v1/circle/task/query")
    Observable<Result> getTaskCircleQuery();
}
