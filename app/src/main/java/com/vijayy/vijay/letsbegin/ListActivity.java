package com.vijayy.vijay.letsbegin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    String[] titles1;
    String[] Des1;
    ListView lis;
    RecyclerView recv;
    int[] imagess = {R.drawable.corn, R.drawable.beans, R.drawable.sun, R.drawable.wheat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        titles1 = res.getStringArray(R.array.titles2);
        Des1 = res.getStringArray(R.array.description2);
        lis = (ListView)findViewById(R.id.lisView1);

        lis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            /*    if(i==0)
                {
                    Intent intend = new Intent(ListActivity.this, MainListActivity.class);
                    startActivity(intend);
                }
                */
                if(i==0)
                {
                    Intent intend = new Intent(ListActivity.this, MainList2Activity.class);
                    startActivity(intend);
                }
                if(i==1)
                {
                    Intent intend = new Intent(ListActivity.this, MainList3Activity.class);
                    startActivity(intend);
                }
                if(i==2)
                {
                    Intent intend = new Intent(ListActivity.this, MainList4Activity.class);
                    startActivity(intend);
                }
                if(i==3)
                {
                    Intent intend = new Intent(ListActivity.this, MainList5Activity.class);
                    startActivity(intend);
                }

            }
        });
        EAadapter eadapter=new EAadapter(this,titles1,imagess,Des1);
        lis.setAdapter(eadapter);
    }

}

class  EAadapter extends ArrayAdapter<String>
{   int[] imagess;
    String[] titleaa;
    String[] desaa;
    Context contextt;
    EAadapter(Context c,String[] titles1,int imag[],String[] desc)
    {
        super(c,R.layout.thr_row,R.id.textView5 ,titles1);
        this.contextt=c;
        this.imagess=imag;
        this.titleaa=titles1;
        this.desaa=desc;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup paarent) {
        LayoutInflater inflaterr=(LayoutInflater) contextt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roow= inflaterr.inflate(R.layout.thr_row,paarent,false);
        ImageView myimage=(ImageView) roow.findViewById(R.id.imageView2);
        TextView mytitle=(TextView)roow.findViewById(R.id.textView5);
        TextView mydes=(TextView)roow.findViewById(R.id.textView6);

        myimage.setImageResource(imagess[position]);
        mytitle.setText(titleaa[position]);
        mydes.setText(desaa[position]);
        return roow;
    }
}


