package com.example.login.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;

public class MainActivity extends AppCompatActivity {
    private EditText etNum1,etNum2,etNum3;
    private Button btnSum;
    private TextView tvResult;
    private TextView tvBackToPart2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapUIToProperties();
        setupActions();

    /*

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int x, y, z, sum;
//                if((etNum1.getText().toString().equals("")) &&
//                        (etNum2.getText().toString().equals("")) &&
//                                (etNum3.getText().toString().equals(""))) {
//                    x = 0;
//                    y = 0;
//                    z = 0;
//                    Toast.makeText(MainActivity.this, "Fields are not empty, Please enter value:", Toast.LENGTH_LONG).show();
//
//                }else{
//                        x = Integer.parseInt(etNum1.getText().toString());
//                        y = Integer.parseInt(etNum2.getText().toString());
//                        z = Integer.parseInt(etNum3.getText().toString());
//                    }

                if (etNum1.getText().toString().equals("")) {
                    x = 0;
                    Toast.makeText(MainActivity.this, "Please enter value of number1", Toast.LENGTH_LONG).show();
                    etNum1.requestFocus();
                } else {
                    x = Integer.parseInt(etNum1.getText().toString());
                }
                if (etNum2.getText().toString().equals("")) {
                    y = 0;
                    Toast.makeText(MainActivity.this, "Please enter value of number2", Toast.LENGTH_LONG).show();
                    etNum2.requestFocus();
                } else {
                    y = Integer.parseInt(etNum2.getText().toString());
                }
                if (etNum3.getText().toString().equals("")) {
                    z = 0;
                    Toast.makeText(MainActivity.this, "Please enter value of number3", Toast.LENGTH_LONG).show();
                    etNum3.requestFocus();
                } else {
                    z = Integer.parseInt(etNum3.getText().toString());
                }

                sum = x + y + z;
                tvResult.setText(String.valueOf("Sum of: " + x + " + " + y + " + " + z + " = " + sum));
            }
        });

*/
    }




    public void mapUIToProperties(){
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        btnSum = findViewById(R.id.btnSum);
        tvResult = findViewById(R.id.tvResult);
        tvBackToPart2 = findViewById(R.id.tvBackToPart2);

    }

    public void  setupActions(){
    /**
        btnSum.setOnClickListener((View v)->{
            int x, y, z, sum;

            if (etNum1.getText().toString().equals("")) {
                x = 0;
                Toast.makeText(MainActivity.this, "Please enter value of number1", Toast.LENGTH_LONG).show();
                etNum1.requestFocus();
            } else {
                x = Integer.parseInt(etNum1.getText().toString());
            }
            if (etNum2.getText().toString().equals("")) {
                y = 0;
                Toast.makeText(MainActivity.this, "Please enter value of number2", Toast.LENGTH_LONG).show();
                etNum2.requestFocus();
            } else {
                y = Integer.parseInt(etNum2.getText().toString());
            }
            if (etNum3.getText().toString().equals("")) {
                z = 0;
                Toast.makeText(MainActivity.this, "Please enter value of number3", Toast.LENGTH_LONG).show();
                etNum3.requestFocus();
            } else {
                z = Integer.parseInt(etNum3.getText().toString());
            }

            sum = x + y + z;
            tvResult.setText(String.valueOf("Sum of: " + x + " + " + y + " + " + z + " = " + sum));
        });
*/

        tvBackToPart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToPart2 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(backToPart2);
            }
        });


    btnSum.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double numb1=0.0;
            double numb2=0.0;
            double numb3=0.0;
            double sum;

            //Check if the field empty
            if (TextUtils.isEmpty(etNum1.getText().toString())
                    && TextUtils.isEmpty(etNum2.getText().toString())
                    && TextUtils.isEmpty(etNum3.getText().toString())) {
                Toast.makeText(MainActivity.this, "All fields are empty !\nPlease enter value.", Toast.LENGTH_LONG).show();
                etNum1.requestFocus();
                return ;
            }
            if(TextUtils.isEmpty(etNum1.getText().toString())){
                Toast.makeText(MainActivity.this, "Please enter value of number1", Toast.LENGTH_LONG).show();
                etNum1.requestFocus();
                return;
            }
            if(TextUtils.isEmpty(etNum2.getText().toString())){
                Toast.makeText(MainActivity.this, "Please enter value of number2", Toast.LENGTH_LONG).show();
                etNum2.requestFocus();
                return;
            }
            if(TextUtils.isEmpty(etNum3.getText().toString())){
                Toast.makeText(MainActivity.this, "Please enter value of number3", Toast.LENGTH_LONG).show();
                etNum3.requestFocus();
                return;
            }

            numb1=Double.parseDouble(etNum1.getText().toString());
            numb2=Double.parseDouble(etNum2.getText().toString());
            numb3=Double.parseDouble(etNum3.getText().toString());
            sum = numb1 + numb2 + numb3 ;
            tvResult.setText( numb1 + " + " + numb2 + " + " + numb3 + " = " + sum);
            //tvResult.setText("Sum of: " + numb1 + " + " + numb2 + " + " + numb3 + " = " + Double.toString(sum)); // the same.
        }
    });



    }

}
/*
 double numb1=0.0;
            double numb2=0.0;
            double numb3=0.0;
            double sum;
            //Check if the field empty
            if (TextUtils.isEmpty(num1.getText().toString())
                    || TextUtils.isEmpty(num2.getText().toString())
                    ||TextUtils.isEmpty(num3.getText().toString())) {
                return ;
            }
            numb1=Double.parseDouble(num1.getText().toString());
            numb2=Double.parseDouble(num2.getText().toString());
            numb3=Double.parseDouble(num3.getText().toString());
            sum=numb1+numb2+numb3;
            result.setText(Double.toString(sum));

 */