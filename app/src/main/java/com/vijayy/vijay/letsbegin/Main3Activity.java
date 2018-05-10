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

public class Main3Activity extends AppCompatActivity {
    String[] titlesAgr;
    ListView lisAg;
    int[] imagesAgr = {R.drawable.dies, R.drawable.fer, R.drawable.latest, R.drawable.lab, R.drawable.market512,
            R.drawable.exp,R.drawable.madd,R.drawable.comp,R.drawable.market512,R.drawable.exp,R.drawable.market512};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Resources res = getResources();
        titlesAgr = res.getStringArray(R.array.titAgri);
        lisAg = (ListView)findViewById(R.id.agrilist);

        lisAg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    String url = "http://farmer.gov.in/Disease.aspx?";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }
                if(i==1)
                {
                    String url = "http://farmer.gov.in/WholesalerStockReport.aspx";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }
                if(i==2)
                {
                    String url = "http://farmer.gov.in/Seed/CentralVariety.aspx?NQgm7A9VpSQ=";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }
                if(i==3)
                {
                    String url = "http://farmer.gov.in/DiagnoLab.aspx?";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);

                }
                if(i==4)
                {
                    String url = "http://farmer.gov.in/Beneficiary/total_beneficiaryCount.aspx";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==5)
                {
                    String url = "http://farmer.gov.in/IpmDoDont.aspx#";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } if(i==6)
                {
                    String url = "http://agriculture.gov.in/Contacts.aspx";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } if(i==7)
                {
                    String url = "http://agricoop.gov.in/tenders?page=1";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } if(i==8)
                {
                    String url = "http://farmer.gov.in/mandi.aspx";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } if(i==9)
                {
                    String url = "http://agricoop.gov.in/whos-who";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==10)
                {
                    String url = "http://farmer.gov.in/AgriExportReport.aspx";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
        AgriAadapter adapter=new AgriAadapter(this,titlesAgr,imagesAgr);
        lisAg.setAdapter(adapter);
    }

}

class  AgriAadapter extends ArrayAdapter<String>
{   int[] images;
    String[] titlea;
    Context context;
    AgriAadapter(Context c,String[] titles,int img[])
    {
        super(c,R.layout.agri_row,R.id.texAgri ,titles);
        this.context=c;
        this.images=img;
        this.titlea=titles;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup paarent) {
        LayoutInflater inflaterr=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflaterr.inflate(R.layout.agri_row,paarent,false);
        ImageView myimage=(ImageView) row.findViewById(R.id.imageAgri);
        TextView mytitle=(TextView)row.findViewById(R.id.texAgri);
        myimage.setImageResource(images[position]);
        mytitle.setText(titlea[position]);
        return row;
    }
}


