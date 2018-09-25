package co.mahti.foodmonitoringsystems;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

import static java.lang.Integer.*;
import static java.net.URLEncoder.*;
import static java.net.URLEncoder.encode;

public class ViewScanActivity extends AppCompatActivity {

    private ImageView apiImage;
    private TextView product;
    private Upcbarcode upcbarcode;
    private String data,url,image,barcode,urlRetrofit,signature;
    private String result;

    private TextView inputProductName;
    private ImageView inputImage;
    private EditText inputQuantity,inputExpiryDate;
    private Button btnSave;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scan);
        final String text = getIntent().getExtras().getString("upcCode");
        String signature = "wc02Cxnz7drbraq+J6iVvb2N5gQ=";
        String barcode = "8850124003850";
        String key = "Xq93R9v8m8Ih3Ow2";
        //Log.d("test signature",signature);
        String urlRetrofit = "gtin/v2_0/?upcCode="+barcode+"&app_key=/y7bYcVpFI7B&signature="+signature+"&language=en&field_names=all";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.digit-eyes.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API service = retrofit.create(API.class) ;
        Call<Upcbarcode> call = service.getUpcCode(url);

        call.enqueue(new Callback<Upcbarcode>() {
            @Override
            public void onResponse(Call<Upcbarcode> call, Response<Upcbarcode> response) {
                Log.d("URL",call.request().url().toString());
                if (response.isSuccessful()) {
                    Log.d("success","onResponse");
                    Upcbarcode upcbarcode = response.body();
                    Toast.makeText(ViewScanActivity.this,"server returned"+response.body().getDescription(),Toast.LENGTH_SHORT).show();
                    Toast.makeText(ViewScanActivity.this,"server returned",Toast.LENGTH_SHORT).show();
                    Log.e("test api",upcbarcode.getDescription());
                    data = response.body().getDescription();
                    inputProductName = (TextView) findViewById(R.id.Scanned_ProductName);
                    inputProductName.setText(data);
                    url = upcbarcode.getImage();
                   // inputImage = (ImageView) findViewById(R.id.imageView);
                   // inputImage.setTextAli();
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

        inputProductName = (TextView) findViewById(R.id.Scanned_ProductName);
        inputQuantity = (EditText) findViewById(R.id.Scanned_Quantity);
        inputExpiryDate = (EditText) findViewById(R.id.Scanned_Expiry);
        btnSave = (Button) findViewById(R.id.btn_scan);
        //data = new Data();
        databaseReference =FirebaseDatabase.getInstance().getReference("ingredient");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addArrayList();
            }
        });
    }
    private void addArrayList(){
        String id = databaseReference.push().getKey();
        String productName = inputProductName.getText().toString().trim();
        //String utlImage = image.getText().toString().trim();
        String quantity = inputQuantity.getText().toString().trim();
        String expiryDate = inputExpiryDate.getText().toString().trim();

        InputDataViewScan inputDataViewScan = new InputDataViewScan(productName,image,quantity,expiryDate);
        databaseReference.child(id).child("productName").setValue(productName.toString());
        databaseReference.child(id).child("image").setValue(image.toString());
        databaseReference.child(id).child("quantity").setValue(quantity.toString());
        databaseReference.child(id).child("expiryDate").setValue(expiryDate.toString());

        ClearText();
    }
    private void ClearText() {

        inputExpiryDate.setText("");
        inputQuantity.setText("");
    }
}
