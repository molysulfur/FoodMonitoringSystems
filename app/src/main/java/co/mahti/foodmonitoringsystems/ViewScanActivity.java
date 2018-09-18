package co.mahti.foodmonitoringsystems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewScanActivity extends AppCompatActivity {

    private ImageView apiImage;
    private TextView product;;
    private Upcbarcode upcbarcode;
    private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scan);
        String text = getIntent().getExtras().getString("upcCode");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.digit-eyes.com/gtin/v2_0/?")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API service = retrofit.create(API.class);
        Call<Upcbarcode> call = service.getUpcCode("text");
        call.enqueue(new Callback<Upcbarcode>() {
            @Override
            public void onResponse(Call<Upcbarcode> call, Response<Upcbarcode> response) {
                Log.d("success","onResponse");
                Upcbarcode upcbarcode = response.body();
                Log.d("success",upcbarcode.getDescription());
                data = upcbarcode.getDescription();
                product = (TextView) findViewById(R.id.textView);
                product.setText(data);
            }

            @Override
            public void onFailure(Call<Upcbarcode> call, Throwable t) {

            }
        });

    }
}
