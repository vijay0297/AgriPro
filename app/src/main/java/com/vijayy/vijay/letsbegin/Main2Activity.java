package com.vijayy.vijay.letsbegin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
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

public class Main2Activity extends AppCompatActivity {
    String[] titAr;
    ListView lisg;
    int[] imagesg = {R.drawable.corn, R.drawable.cam, R.drawable.shop, R.drawable.framer, R.drawable.exp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Resources res = getResources();
        titAr = res.getStringArray(R.array.tit);
        lisg = (ListView)findViewById(R.id.listt);

        lisg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent Intnt = new Intent(Main2Activity.this, ListActivity.class);
                    startActivity(Intnt);
                }
                if(i==1)
                {
                    Intent Intnt = new Intent(Main2Activity.this, PostActivity.class);
                    startActivity(Intnt);
                }
                if(i==2)
                {
                    Intent Intnt = new Intent(Main2Activity.this, MapsActivity.class);
                    startActivity(Intnt);

                }
                if(i==3)
                {
                    Intent Intnt = new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(Intnt);

                }
                if(i==4)
                {
                    String ph="9789759427";
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",ph, null)));
                }

            }
        });
        AgAadapter dapter=new AgAadapter(this,titAr,imagesg);
        lisg.setAdapter(dapter);
    }

}

class  AgAadapter extends ArrayAdapter<String>
{   int[] image;
    String[] titla;
    Context context;
    AgAadapter(Context c,String[] tit,int im[])
    {
        super(c,R.layout.ag_row,R.id.texAg ,tit);
        this.context=c;
        this.image=im;
        this.titla=tit;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup paarent) {
        LayoutInflater inflaterr=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View r= inflaterr.inflate(R.layout.ag_row,paarent,false);
        ImageView myimage=(ImageView) r.findViewById(R.id.imageAg);
        TextView mytitle=(TextView)r.findViewById(R.id.texAg);
        myimage.setImageResource(image[position]);
        mytitle.setText(titla[position]);
        return r;
    }
}
