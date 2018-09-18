package co.mahti.foodmonitoringsystems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("upcCode={text}&app_key=/y0OJ79OoSfu&signature=x/OOEO03MwXksUpxyndydphcH5s=&language=en&field_names=all")
    Call<Upcbarcode> getUpcCode(@Path("text") String text);
}
