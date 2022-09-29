package com.example.madlab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button gen,sort;
    int arr[] = new int[5];
    TextView n1,n2,n3,n4,n5,res;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Arrays.fill(arr,0);
        n1 = (TextView) findViewById(R.id.num5);
        n2 = (TextView) findViewById(R.id.num4);
        n3 = (TextView) findViewById(R.id.num1);
        n4 = (TextView) findViewById(R.id.num3);
        n5 = (TextView) findViewById(R.id.num2);

        gen = (Button) findViewById(R.id.ret);
        sort = (Button) findViewById(R.id.sort);


        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int i =0;
                while(i<5)
                {
                    int temp = rand.nextInt(14);
                    if(temp==0 || contains(arr,i,temp)==true)
                    {
                        continue;
                    }
                    else
                    {
                        arr[i]=temp;
                        i++;
                    }
                }
                n1.setText(arr[0]+" ");
                n2.setText(arr[1]+" ");
                n3.setText(arr[2]+" ");
                n4.setText(arr[3]+" ");
                n5.setText(arr[4]+" ");
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arr[0]!=0) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putIntArray("Key1", arr);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please Generate Numbers",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean contains(int numbers[],int j,int num)
    {
        boolean ch = false;
        for(int i=0;i<j;i++)
        {
            if(numbers[i]==num)
            {
                ch = true;
                break;
            }
        }
        return ch;
    }
}