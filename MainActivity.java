//Developed By Amar
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;
import java.time.*;
import java.math.*;
import android.view.View;
import android.widget.*;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] currency1 = { "USD", "EUR", "CNY", "INR" };
    String[] currency2 = { "USD", "EUR", "CNY", "INR" };
    Button con,ic;
    EditText tf;
    boolean f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spin1 = findViewById(R.id.spfrom);
        Spinner spin2 = (Spinner) findViewById(R.id.spto);
        con = (Button) findViewById(R.id.button);
        ic = (Button) findViewById(R.id.swap);
        tf = (EditText) findViewById(R.id.txtamount);
        tf.setText(" ");
//        con.setEnabled(false);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currency1);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(ad);
        spin2.setAdapter(ad);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
                if(!(spin1.getSelectedItem() == spin2.getSelectedItem()))
                   toast();
            }
            public void check()
            {
//                boolean flag;
                try {
                    if ((spin1.getSelectedItem() == spin2.getSelectedItem())) {
                        tf.setText(tf.getText());

                    } else if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "INR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 81.26));
                        f1 = true;
                    } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "USD") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 81.26));
                        f2 = true;
                    } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "EUR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 78.74));
                        f3 = true;
                    } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "CNY") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 11.4));
                        f4 = true;
                    } else if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "EUR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 1.03));
                        f5 = true;
                    } else if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "CNY") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 7.13));
                        f6 = true;
                    } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "USD") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 1.03));
                        f7 = true;
                    } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "CNY") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 6.91));
                        f8 = true;
                    } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "INR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 78.74));
                        f9 = true;
                    } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "INR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a * 11.04));
                        f10 = true;
                    } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "USD") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 7.13));
                        f11 = true;
                    } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "EUR") {
                        double a = Double.parseDouble(tf.getText().toString());
                        tf.setText(String.format("%.2f", a / 6.91));
                        f12 = true;
                    }

                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this, "Enter the amount", Toast.LENGTH_SHORT).show();
                }
            }
            public void toast()
            {
                if(f1) {
                    Toast.makeText(MainActivity.this, "$ -> ₹", Toast.LENGTH_SHORT).show();
                    f1 = false;
                }
                else if(f2) {
                    Toast.makeText(MainActivity.this, "₹ -> $", Toast.LENGTH_SHORT).show();
                    f2 = false;
                }
                else if(f3) {
                    Toast.makeText(MainActivity.this, "₹ -> €", Toast.LENGTH_SHORT).show();
                    f3 = false;
                }
                else if(f4) {
                    Toast.makeText(MainActivity.this, "₹ -> ¥", Toast.LENGTH_SHORT).show();
                    f4 = false;
                }
                else if(f5) {
                    Toast.makeText(MainActivity.this, "$ -> €", Toast.LENGTH_SHORT).show();
                    f5 = false;
                }
                else if(f6) {
                    Toast.makeText(MainActivity.this, "$ -> ¥", Toast.LENGTH_SHORT).show();
                    f6 = false;
                }
                else if(f7) {
                    Toast.makeText(MainActivity.this, "€ -> $", Toast.LENGTH_SHORT).show();
                    f7 = false;
                }
                else if(f8) {
                    Toast.makeText(MainActivity.this, "€ -> ¥", Toast.LENGTH_SHORT).show();
                    f8 = false;
                }
                else if(f9) {
                    Toast.makeText(MainActivity.this, "€ -> ₹", Toast.LENGTH_SHORT).show();
                    f9 = false;
                }
                else if(f10) {
                    Toast.makeText(MainActivity.this, "¥ -> ₹", Toast.LENGTH_SHORT).show();
                    f10 = false;
                }
                else if(f11) {
                    Toast.makeText(MainActivity.this, "¥ -> $", Toast.LENGTH_SHORT).show();
                    f11 = false;
                }
                else if(f12) {
                    Toast.makeText(MainActivity.this, "¥ -> €", Toast.LENGTH_SHORT).show();
                    f12 = false;
                }
            }
        });

        ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "INR") {
                     spin1.setSelection(3);
                     spin2.setSelection(0);
                } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "USD") {
                    spin1.setSelection(0);
                    spin2.setSelection(3);
                } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "EUR") {
                    spin1.setSelection(1);
                    spin2.setSelection(3);
                } else if (spin1.getSelectedItem() == "INR" && spin2.getSelectedItem() == "CNY") {
                    spin1.setSelection(2);
                    spin2.setSelection(3);
                } else if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "EUR") {
                    spin1.setSelection(1);
                    spin2.setSelection(0);
                } else if (spin1.getSelectedItem() == "USD" && spin2.getSelectedItem() == "CNY") {
                    spin1.setSelection(2);
                    spin2.setSelection(0);
                } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "USD") {
                    spin1.setSelection(0);
                    spin2.setSelection(1);
                } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "CNY") {
                    spin1.setSelection(2);
                    spin2.setSelection(1);
                } else if (spin1.getSelectedItem() == "EUR" && spin2.getSelectedItem() == "INR") {
                    spin1.setSelection(3);
                    spin2.setSelection(1);
                } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "INR") {
                    spin1.setSelection(3);
                    spin2.setSelection(2);
                } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "USD") {
                    spin1.setSelection(0);
                    spin2.setSelection(2);
                } else if (spin1.getSelectedItem() == "CNY" && spin2.getSelectedItem() == "EUR") {
                    spin1.setSelection(1);
                    spin2.setSelection(2);
                }
            }
        });


    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



}