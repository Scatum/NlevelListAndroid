package com.twocentscode.nlevelexpandablelistview;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adc on 2/9/17.
 */

public interface Api {
    @GET("mobileAPI/index.php?action=videoCategoryList")
    Call<CatalogRespons> getVideoCategory();
}
