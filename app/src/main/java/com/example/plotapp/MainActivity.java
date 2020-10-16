package com.example.plotapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final TextView txtFunction=(TextView)findViewById(R.id.txtFunction);
        final CustomView customView=(CustomView)findViewById(R.id.plotview);
        Button buttonPlot=(Button)findViewById(R.id.buttonPlot);
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    String strFunction=txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    customView.invalidate();
                }
            }
        });

        Button button_sin=(Button)findViewById(R.id.button_sin);
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("sin(x)");
                    customView.setStrFunction("sin(x)");
                    customView.invalidate();
                }
            }
        });

        Button button_cos=(Button)findViewById(R.id.button_cos);
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("cos(x)");
                    customView.setStrFunction("cos(x)");
                    customView.invalidate();
                }
            }
        });

        Button button_tg=(Button)findViewById(R.id.button_tg);
        button_tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("tg(x)");
                    customView.setStrFunction("tg(x)");
                    customView.invalidate();
                }
            }
        });

        Button button_ctg=(Button)findViewById(R.id.button_ctg);
        button_ctg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("ctg(x)");
                    customView.setStrFunction("ctg(x)");
                    customView.invalidate();
                }
            }
        });

        Button button_x2=(Button)findViewById(R.id.button_x2);
        button_x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("x^2");
                    customView.setStrFunction("x^2");
                    customView.invalidate();
                }
            }
        });

        Button button_x3=(Button)findViewById(R.id.button_x3);
        button_x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("x^3");
                    customView.setStrFunction("x^3");
                    customView.invalidate();
                }
            }
        });

        Button button_genhao=(Button)findViewById(R.id.button_genhao);
        button_genhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("x^0.5");
                    customView.setStrFunction("x^0.5");
                    customView.invalidate();
                }
            }
        });

        Button button_fenshu=(Button)findViewById(R.id.button_fenshu);
        button_fenshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("1/x");
                    customView.setStrFunction("1/x");
                    customView.invalidate();
                }
            }
        });

        Button button_CE=(Button)findViewById(R.id.buttonCE);
        button_CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customView!=null){
                    txtFunction.setText("");
                    customView.setStrFunction("");
                    customView.invalidate();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 创建菜单，包含帮助页面和退出按钮。
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_help:{   //帮助页面
                Intent intent = new Intent(MainActivity.this,Help.class);
                startActivity(intent);
                break;
            }
            case R.id.action_exit:{ //退出系统
                exit();
            }
        }
        return false;
    }

    public void exit(){
        System.exit(0);
    }
}
