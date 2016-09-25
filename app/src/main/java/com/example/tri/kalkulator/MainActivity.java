package com.example.tri.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private static final String TAG = "MainActivity";

    private EditText editText;
    private Button buttonX2, buttonCC;
    private ViewGroup rootView;
    private String[] opList = {"+", "-", "="};
    private String buttonString;
    private double tmpRes = 0;
    private String currentOp = null;
    //private EditText etNum1;
    //private EditText etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonX2 = (Button) findViewById(R.id.buttonX2);
        buttonX2.setText(Html.fromHtml("x<sup>2</sup>"));
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("0");
        Button buttonCC =(Button) findViewById(R.id.buttonCC);
        buttonCC.setOnClickListener(this);
        rootView = (ViewGroup)findViewById(R.id.rootView);
        setupAllListeners(rootView);


    }

    private void setupAllListeners(ViewGroup rootView){
        int numChild = rootView.getChildCount();
        //Log.v(TAG, "child number
        for (int i = 0; i < numChild; i++) {
            View view = rootView.getChildAt(i);
            if(view instanceof ViewGroup){
                setupAllListeners((ViewGroup) view);
            } else if(view instanceof Button){
                Button button = (Button) view;
                button.setOnClickListener(this);
            }
            //Log.v(TAG,"View id: "+ view.getId());
        }
    }

    public void displayResult(View view){
        editText.setText("Result");
    }

    @Override
    public void onClick(View v) {
        char[] txt = editText.getText().toString().toCharArray();
        switch (v.getId()){
            case R.id.buttonCC:
                editText.setText("0");
                break;
            default:
                //editText.setText()
                Button button = (Button) v;
                buttonString = button.getText().toString();
                if(Arrays.asList(opList).contains(buttonString)) {
                    setOperasi();
                } else {
                    if(txt[0] == '0') {
                        editText.setText(buttonString);
                    } else {
                        editText.setText(editText.getText().toString() + buttonString);
                    }

                }

                Log.v(TAG, "Log All");
        }
    }

    public void setOperasi() {
        switch(buttonString) {
            case "+":
                tmpRes = Double.parseDouble(editText.getText().toString());
                currentOp = "+";
                editText.setText("0");
                break;
            case "-":
                tmpRes = Double.parseDouble(editText.getText().toString());
                currentOp = "-";
                editText.setText("0");
                break;
            case "=":
                hitungOperasi();
                break;
        }
    }

    public void hitungOperasi() {
        double tmp = Double.parseDouble(editText.getText().toString());
        switch (currentOp) {
            case "+":
                tmp = tmp + tmpRes;
                //currentResult = tmp;
                System.out.println("+ Masuk sini : " + tmp);
                editText.setText(String.valueOf((int) tmp));
                tmpRes = 0;
                currentOp = null;
                break;
            case "-":
                tmp = tmpRes - tmp;
                //currentResult = tmp;
                System.out.println("- Masuk sini : " + tmp);
                editText.setText(String.valueOf((int) tmp));
                currentOp = null;
                tmpRes = 0;
                break;

        }
    }
 public void setOperasi() {
        switch(buttonString) {
            case "*":
                tmpRes = Double.parseDouble(editText.getText().toString());
                currentOp = "*";
                editText.setText("0");
                break;
            case "/":
                tmpRes = Double.parseDouble(editText.getText().toString());
                currentOp = "/";
                editText.setText("0");
                break;
            case "=":
                hitungOperasi();
                break;
        }
    }

    public void hitungOperasi() {
        double tmp = Double.parseDouble(editText.getText().toString());
        switch (currentOp) {
            case "*":
                tmp = tmp * tmpRes;
                //currentResult = tmp;
                System.out.println("* Masuk sini : " * tmp);
                editText.setText(String.valueOf((int) tmp));
                tmpRes = 0;
                currentOp = null;
                break;
            case "/":
                tmp = tmpRes / tmp;
                //currentResult = tmp;
                System.out.println("/ Masuk sini : " / tmp);
                editText.setText(String.valueOf((int) tmp));
                currentOp = null;
                tmpRes = 0;
                break;

        }
    }

}