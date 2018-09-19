package co.mahti.foodmonitoringsystems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("upcCode={text}&field_names=all&language=en&app_key=/y7bYcVpFI7B&signature=wc02Cxnz7drbraq+J6iVvb2N5gQ=")
    Call<Upcbarcode> getUpcCode(@Path("text") String text);
}
