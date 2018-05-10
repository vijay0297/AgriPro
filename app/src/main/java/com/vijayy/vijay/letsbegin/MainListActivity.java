package com.vijayy.vijay.letsbegin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainListActivity extends AppCompatActivity {
    private DatabaseReference mdatabase;
    private RecyclerView mbloglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("plant");
        mbloglist=(RecyclerView)findViewById(R.id.blogview);
        mbloglist.setHasFixedSize(true);
        mbloglist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();



        FirebaseRecyclerAdapter<Blog,BlogViewHolder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<Blog,BlogViewHolder>(
                 Blog.class,
                R.layout.blog,BlogViewHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder,Blog model,int position){
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };
        mbloglist.setAdapter(firebaseRecyclerAdapter);
    }
    public static class  BlogViewHolder extends RecyclerView.ViewHolder{

        View mview;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mview=itemView;
        }
        public void setTitle(String title){
            TextView post_title=(TextView) mview.findViewById(R.id.postit);
            post_title.setText(title);

        }
        public void setDesc(String desc){
            TextView postdes=(TextView) mview.findViewById(R.id.postdesc);
            postdes.setText(desc);

        }
        public void setImage(Context ctx,String image){
            ImageView pst_image=(ImageView) mview.findViewById(R.id.pst_image);
            Picasso.with(ctx).load(image).into(pst_image);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.action_add){
            startActivity(new Intent(MainListActivity.this,PostActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
