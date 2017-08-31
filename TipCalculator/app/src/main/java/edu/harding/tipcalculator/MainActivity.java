package edu.harding.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText mBillAmountEditText;
    EditText mTipPercentEditText;
    TextView mTipAmountTextView;
    TextView mTotalAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBillAmountEditText = (EditText) findViewById(R.id.billEditText);
        mTipPercentEditText = (EditText) findViewById(R.id.tipPercentEditText);
        mTipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        mTotalAmountTextView = (TextView) findViewById(R.id.totalTextView);
    }

    public void calculateClick(View view) {
        try {
            float bill = Float.parseFloat(mBillAmountEditText.getText().toString());
            float tipPercent = Float.parseFloat(mTipPercentEditText.getText().toString());

            float tip = bill * tipPercent * 0.01f;
            float total = bill + tip;

            Log.d("test", "tip = " + tip + "   total = " + total);

            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

            mTipAmountTextView.setText(moneyFormat.format(tip));
            mTotalAmountTextView.setText(moneyFormat.format(total));
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Enter numbers for bill and tip percent.", Toast.LENGTH_SHORT).show();
            mTipAmountTextView.setText("");
            mTotalAmountTextView.setText("");
        }
    }
}
