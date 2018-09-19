package co.mahti.foodmonitoringsystems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

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
                if (response.isSuccessful())
                {   Log.d("success","onResponse");
                    Upcbarcode upcbarcode = response.body();
                    Toast.makeText(ViewScanActivity.this,"server returned"+upcbarcode.getDescription(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(ViewScanActivity.this,"server returned",Toast.LENGTH_SHORT).show();
                    Log.e("test api",upcbarcode.getDescription());
                    data = upcbarcode.getDescription();
                    product = (TextView) findViewById(R.id.textView);
                    product.setText(data);
                }
                else{
                    try {
                        //Toast.makeText(ViewScanActivity.this,"server returned error:"+response.errorBody().string(),Toast.LENGTH_SHORT).show();
                        Log.d("server returned error:",response.errorBody().string());
                    }catch (IOException e){
                        Toast.makeText(ViewScanActivity.this,"server returned error: unknown",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    //Upcbarcode upcbarcode = ErrorUtils.parse

                }

            }

            @Override
            public void onFailure(Call<Upcbarcode> call, Throwable t) {

            }
        });

    }
}
