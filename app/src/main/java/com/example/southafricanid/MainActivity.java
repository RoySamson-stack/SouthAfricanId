package com.example.southafricanid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etID;
    Button btn_submit;
    TextView tv_results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID = findViewById(R.id.etID);
        btn_submit = findViewById(R.id.btn_submit);
        tv_results  = findViewById(R.id.tv_results);
        tv_results.setVisibility(View.GONE);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0, 6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;
                if (gender < 5)
                    sGender = "Female";
                else
                    sGender = "Male";
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if (nationality == 0)
                    sNationality = " SA citizen";
                else
                    sNationality = "Permanent resident";
                tv_results.setText("Date of birth " + dob + "\n"   + "Gender" + sGender + "\n "+ "Nationality" + sNationality);
                tv_results.setVisibility(View.VISIBLE);

            }
        });
    }
}