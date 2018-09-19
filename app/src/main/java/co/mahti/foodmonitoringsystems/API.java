package co.mahti.foodmonitoringsystems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("upcCode={text}&field_names=all&language=en&app_key=/y7bYcVpFI7B&signature=aor+VLZhqT2G7HYPY2V08cn22Po=")
    Call<Upcbarcode> getUpcCode(@Path("text") String text);
}
