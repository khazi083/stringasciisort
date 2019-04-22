package com.stringsort.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    HashMap<String,Long> listmap= new HashMap<>();
    HashMap<String,Long> sortedEntries=new HashMap<>();
    String values[];
    TextView valuestxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valuestxt=findViewById(R.id.valueslist);
        values = getResources().getStringArray(R.array.cmpyvalues);
        initvalues();
    }

    private void initvalues() {
        for(int i=0;i<values.length;i++){
            listmap.put(values[i],asciisum(values[i]));
        }

        List list=new ArrayList(listmap.entrySet());

        Collections.sort(list,new Comparator(){
            public int compare(Object obj1, Object obj2){
                return ((Comparable)((Map.Entry)(obj2)).getValue()).compareTo(((Map.Entry)(obj1)).getValue());
            }
        });

        StringBuilder temptext=new StringBuilder();
        for(int j=0;j<list.size();j++)
            temptext.append(list.get(j)+"\n");
        valuestxt.setText(temptext);
    }

    private Long asciisum(final String value) {
        long sum = 0;

        for (int i=0;i<value.length();i++) {

            sum += (int)value.charAt(i);

        }

        return sum;
    }
}
