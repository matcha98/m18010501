package com.matcha.m18010501;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv,tv4;
    EditText ed;
    int ch=0;
    int tmp=-1;
    boolean[] chs=new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv4=findViewById(R.id.textView4);
    }

    //對話框
    public void click1(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Dialog");
        builder.setMessage("This is Test");

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了確定",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了Help",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    //對話框--輸入
    public void click2(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("請輸入");
        ed=new EditText(MainActivity.this);
        ed.setText(tv.getText().toString());
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了確定",Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    //對話框--列表
    public void click3(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        final TextView tv2=findViewById(R.id.textView2);
        builder.setTitle("請選擇");
        final String[] fruit={"蘋果","香蕉","李子"};
        builder.setItems(fruit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv2.setText(fruit[i]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    //對話框--單選
    public void click4(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選");
        final TextView tv3=findViewById(R.id.textView3);
        final String[] fruit={"蘋果","香蕉","李子"};
        tmp=ch;
        builder.setSingleChoiceItems(fruit, ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tmp=i;
            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch=tmp;
                tv3.setText(fruit[ch]);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    //對話框-多選
    public void click5(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選");
        final String[] fruit={"蘋果","香蕉","李子","西瓜","鳳梨"};
        builder.setMultiChoiceItems(fruit, chs, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int p) {
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<5;i++)
                {
                    if(chs[i])
                    {
                        sb.append(fruit[i]+",");
                    }
                }
                tv4.setText(sb.toString());
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    //對話框-layout
    public void click6(View v)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Dialog");
        LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
        View v1=inflater.inflate(R.layout.layout1,null);
        final TextView tv5=v1.findViewById(R.id.textView5);
        Button bt7=v1.findViewById(R.id.button7);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv5.setText("Hello World");
            }
        });
        builder.setView(v1);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了確定",Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }
}
