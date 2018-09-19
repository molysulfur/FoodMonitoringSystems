package co.mahti.foodmonitoringsystems;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Integer.*;

public class ViewScanActivity extends AppCompatActivity {

    private ImageView apiImage;
    private TextView product;;
    private Upcbarcode upcbarcode;
    private String data;
    private String result,url1,url2,test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scan);
        final String text = getIntent().getExtras().getString("upcCode");
        String url1 = new String("8850999320007");
        String url2 = new String("&field_name=all&language=en&app_key=/y7bYcVpFI7B&signature=aor+VLZhqT2G7HYPY2VO8cn22Po=");
        result = url1.concat(url2);//.concat(url2);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.digit-eyes.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API service = retrofit.create(API.class) ;

        Call<Upcbarcode> call = service.getUpcCode(text,"all","en","/y7bYcVpFI7B","aor+VLZhqT2G7HYPY2V08cn22Po=");
        //Call<Upcbarcode> call = service.getUpcCode(result);
        Log.d("URL",call.request().url().toString());
        call.enqueue(new Callback<Upcbarcode>() {
            @Override
            public void onResponse(Call<Upcbarcode> call, Response<Upcbarcode> response) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(ViewScanActivity.this);
                builder.setMessage(text);
                AlertDialog alert1 = builder.create();
                alert1.show();*/
                /*if (response.isSuccessful())
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

                }*/

                if (response.isSuccessful()) {
                    Log.d("success","onResponse");
                    Upcbarcode upcbarcode = response.body();
                    Toast.makeText(ViewScanActivity.this,"server returned"+upcbarcode.getDescription(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(ViewScanActivity.this,"server returned",Toast.LENGTH_SHORT).show();
                    Log.e("test api",upcbarcode.getDescription());
                    data = upcbarcode.getDescription();
                    product = (TextView) findViewById(R.id.textView);
                    product.setText(data);
                } else {
                    try {
                        //Toast.makeText(ViewScanActivity.this,"server returned error:"+response.errorBody().string(),Toast.LENGTH_SHORT).show();
                        Log.d("server returned error:",response.errorBody().string());
                    }catch (IOException e){
                        Toast.makeText(ViewScanActivity.this,"server returned error: unknown",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<Upcbarcode> call, Throwable t) {

            }
        });

//        https://www.digit-eyes.com/gtin/v2_0/?upcCode=8850999320007%20&field_names=all&language=en&app_key=/y7bYcVpFI7B&signature=aor+VLZhqT2G7HYPY2VO8cn22Po=
           /* Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.digit-eyes.com/gtin/v2_0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API api = retrofit.create(API.class);
            Call call = api.getUpcCode("8850999320007");
            call.enqueue(new Callback<Upcbarcode>() {
                @Override
                public void onResponse(Call<Upcbarcode> call, Response<Upcbarcode> response) {
                    Log.e("respone",response.body().getDescription().toString());
                }

                @Override
                public void onFailure(Call<Upcbarcode> call, Throwable t) {

                }
            });*/

    }
}
