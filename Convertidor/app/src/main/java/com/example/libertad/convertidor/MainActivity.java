package com.example.libertad.convertidor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends ActionBarActivity {
    private EditText pesoText;
    private EditText dolarText;
    private RadioButton radioButtonMXaUSD;
    private RadioButton radioButtonUSDaMX;
    double tasa = 15.30;
    private EditText resultado;

    private Button convertidorBoton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.pesoText=(EditText) findViewById(R.id.pesoText);
        this.dolarText=(EditText)findViewById(R.id.dolarText);
        this.radioButtonMXaUSD = (RadioButton) findViewById(R.id.radioButtonMXaUSD);
        this.radioButtonUSDaMX = (RadioButton) findViewById(R.id.radioButtonUSDaMX);
        this.resultado = (EditText) findViewById(R.id.resultado);
        this.convertidorBoton=(Button)findViewById(R.id.convertidorBoton);
    }

    public void convertidorBotonOnClick(View v){

        double pesoText = 0,dolarText=0,resultadoText = 0;

        if(radioButtonMXaUSD.isChecked()) {
            pesoText = Double.parseDouble(this.pesoText.getText().toString());
            resultadoText=(pesoText/tasa);
            this.resultado.setText(Double.toString((double) resultadoText));
        }

        if(radioButtonUSDaMX.isChecked()) {
            dolarText = Double.parseDouble(this.dolarText.getText().toString());
            resultadoText=(dolarText*tasa);
            this.resultado.setText(Double.toString((double) resultadoText));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
