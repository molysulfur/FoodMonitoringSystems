package co.mahti.foodmonitoringsystems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flag = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
