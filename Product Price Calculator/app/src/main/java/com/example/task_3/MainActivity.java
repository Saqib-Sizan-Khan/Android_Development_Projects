package com.example.task_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox riceCb,sugarCb,milkCb,onionCb,potatoCb;
    private SeekBar riceSb,sugarSb,milkSb,onionSb,potatoSb;
    private TextView riceVt,sugarVt,milkVt,onionVt,potatoVt,orderDetailsText,delivaryDetailsText,priceDetailsText,paymentDetailsText;
    private Switch delivarySwitch;
    private RadioGroup paymentRadio;
    private RadioButton paymentButton;
    private Button orderButton;

    int rice = 65,sugar = 35,milk = 60,onion = 80,potato = 50;
    int rValue,sValue,mValue,oValue,pValue,dvalue;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkUp();
        checkBoxOperation();
        seekBarOperation();

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Products: ");

                if(riceCb.isChecked()){
                    String value = riceCb.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(sugarCb.isChecked()){
                    String value = sugarCb.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(milkCb.isChecked()){
                    String value = milkCb.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(onionCb.isChecked()){
                    String value = onionCb.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(potatoCb.isChecked()){
                    String value = potatoCb.getText().toString();
                    stringBuilder.append(value+" ");
                }

                int selectedId = paymentRadio.getCheckedRadioButtonId();
                paymentButton = (RadioButton) findViewById(selectedId);

                String value = paymentButton.getText().toString();
                paymentDetailsText.setText("Payment: "+value);

                orderDetailsText.setText(stringBuilder);
                price = rValue+sValue+mValue+oValue+pValue+dvalue;

                if (dvalue == 50){
                    delivaryDetailsText.setText("Delivary Charge: 50 BDT.");
                }
                else {
                    delivaryDetailsText.setText("Delivary Charge: N/A");
                }

                priceDetailsText.setText("Total Price: "+price+" BDT.");
            }
        });

        delivarySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    dvalue = 50;
                }
                else{
                    dvalue = 0;
                }
            }
        });
    }

    private void linkUp(){
        riceCb = (CheckBox) findViewById(R.id.riceCheckBoxId);
        sugarCb = (CheckBox) findViewById(R.id.sugarCheckBoxId);
        milkCb = (CheckBox) findViewById(R.id.milkCheckBoxId);
        onionCb = (CheckBox) findViewById(R.id.onionCheckBoxId);
        potatoCb = (CheckBox) findViewById(R.id.potatoCheckBoxId);

        riceSb = (SeekBar) findViewById(R.id.riceSeekBarId);
        sugarSb = (SeekBar) findViewById(R.id.sugarSeekBarId);
        milkSb = (SeekBar) findViewById(R.id.milkSeekBarId);
        onionSb = (SeekBar) findViewById(R.id.onionSeekBarId);
        potatoSb = (SeekBar) findViewById(R.id.potatoSeekBarId);

        riceSb.setEnabled(false);
        sugarSb.setEnabled(false);
        milkSb.setEnabled(false);
        onionSb.setEnabled(false);
        potatoSb.setEnabled(false);

        riceVt = (TextView) findViewById(R.id.riceAmountId);
        sugarVt = (TextView) findViewById(R.id.sugarAmountId);
        milkVt = (TextView) findViewById(R.id.milkAmountId);
        onionVt = (TextView) findViewById(R.id.onionAmountId);
        potatoVt = (TextView) findViewById(R.id.potatoAmountId);

        delivarySwitch = (Switch) findViewById(R.id.delivarySwitchId);

        paymentRadio = (RadioGroup) findViewById(R.id.paymentRadioId);

        orderButton = (Button) findViewById(R.id.orderButtonId);

        orderDetailsText = (TextView) findViewById(R.id.orderDetailsTextId);
        delivaryDetailsText = (TextView) findViewById(R.id.delivaryDetailsTextId);
        priceDetailsText = (TextView) findViewById(R.id.priceDetailsTextId);
        paymentDetailsText = (TextView) findViewById(R.id.paymentDetailsTextId);
    }

    private void checkBoxOperation(){
        riceCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    riceSb.setEnabled(true);
                    riceSb.setProgress(1);
                }

                else {
                    riceSb.setEnabled(false);
                    riceSb.setProgress(0);
                }
            }
        });

        sugarCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sugarSb.setEnabled(true);
                    sugarSb.setProgress(1);
                }

                else {
                    sugarSb.setEnabled(false);
                    sugarSb.setProgress(0);
                }
            }
        });

        milkCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    milkSb.setEnabled(true);
                    milkSb.setProgress(1);
                }

                else {
                    milkSb.setEnabled(false);
                    milkSb.setProgress(0);
                }
            }
        });

        onionCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    onionSb.setEnabled(true);
                    onionSb.setProgress(1);
                }

                else {
                    onionSb.setEnabled(false);
                    onionSb.setProgress(0);
                }
            }
        });

        potatoCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    potatoSb.setEnabled(true);
                    potatoSb.setProgress(1);
                }

                else {
                    potatoSb.setEnabled(false);
                    potatoSb.setProgress(0);
                }
            }
        });
    }

    private void seekBarOperation(){
        riceSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                riceVt.setText("Value: "+progress+"/"+seekBar.getMax()+"(kg)");
                rValue = 0;
                rValue += rice*progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sugarSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sugarVt.setText("Value: "+progress+"/"+seekBar.getMax()+"(kg)");
                sValue = 0;
                sValue += sugar*progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        milkSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                milkVt.setText("Value: "+progress+"/"+seekBar.getMax()+"(liter)");
                mValue = 0;
                mValue += milk*progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        onionSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                onionVt.setText("Value: "+progress+"/"+seekBar.getMax()+"(kg)");
                oValue = 0;
                oValue += onion*progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        potatoSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                potatoVt.setText("Value: "+progress+"/"+seekBar.getMax()+"(kg)");
                pValue = 0;
                pValue += potato*progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
