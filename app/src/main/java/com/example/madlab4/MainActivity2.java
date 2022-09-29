package com.example.madlab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    TextView n1,n2,n3,n4,n5;
    int arr[];
    int sum=0;
    Button ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        n1 = (TextView) findViewById(R.id.num1);
        n2 = (TextView) findViewById(R.id.num2);
        n3 = (TextView) findViewById(R.id.num3);
        n4 = (TextView) findViewById(R.id.num4);
        n5 = (TextView) findViewById(R.id.num5);

        ret = (Button) findViewById(R.id.ret);

        Bundle bundle = getIntent().getExtras();
        arr = bundle.getIntArray("Key1");

        for(int i =0;i<5;i++)
        {
            for(int j =i+1;j<5;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i =0;i<5;i++)
        {
            sum+=arr[i];
        }
        n1.setText(arr[0]+" ");
        n2.setText(arr[1]+" ");
        n3.setText(arr[2]+" ");
        n4.setText(arr[3]+" ");
        n5.setText(arr[4]+" ");

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
