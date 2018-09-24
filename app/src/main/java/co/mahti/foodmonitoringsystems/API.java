package co.mahti.foodmonitoringsystems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface API {
    //@GET("gtin/v2_0/?upcCode=8850999320007&field_names=all&language=en&app_key=/y7bYcVpFI7B&signature=aor+VLZhqT2G7HYPY2VO8cn22Po=")
    //Call<Upcbarcode> getUpcCode(@Query("upcCode") String text);

    @GET
    Call<Upcbarcode> getUpcCode(@Url String url);
    /*Call<Upcbarcode> getUpcCode(@Query("upcCode") String text,
                                @Query("field_names") String all,
                                @Query("language") String en,
                                @Query(value = "app_key",encoded = true) String app_key,
                                @Query(value = "signature",encoded = true) String signature);*/
    
}
