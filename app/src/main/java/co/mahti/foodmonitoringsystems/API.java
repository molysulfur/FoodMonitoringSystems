package co.mahti.foodmonitoringsystems;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    //@GET("gtin/v2_0/?field_names=all&language=en&app_key=/y7bYcVpFI7B&signature=aor+VLZhqT2G7HYPY2V08cn22Po=")
    //Call<Upcbarcode> getUpcCode(@Query("upcCode") String text);
    //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @GET("gtin/v2_0/?")
    //Call<Upcbarcode> getUpcCode(@Query("upcCode") String text);
    Call<Upcbarcode> getUpcCode(@Query("upcCode") String text,
                                @Query("field_names") String all,
                                @Query("language") String en,
                                @Query("app_key") String app_key,
                                @Query(value = "signature",encoded = true) String signature);

}
