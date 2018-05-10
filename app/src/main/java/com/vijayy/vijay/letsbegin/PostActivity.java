package com.vijayy.vijay.letsbegin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.Manifest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class PostActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private EditText mtitle,mdesc;
    private Button mpost;
    private  Uri imageuri=null;
    private  static final int GALLERY_REQUEST=1;
    private ProgressDialog mProgress;
    private StorageReference mStorage;
    private DatabaseReference mdatabase;
    private static final int PERMISSIONS_REQUEST_READ_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mtitle = (EditText) findViewById(R.id.title);
        mdesc = (EditText) findViewById(R.id.decsfileld);
        mpost = (Button) findViewById(R.id.post);
        imageButton = (ImageButton) findViewById(R.id.imageselect);
        mStorage= FirebaseStorage.getInstance().getReference();
        mdatabase= FirebaseDatabase.getInstance().getReference().child("plant1");
        mProgress=new ProgressDialog(this);
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSIONS_REQUEST_READ_STORAGE);




        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryintent.setType("image/*");
                startActivityForResult(galleryintent, GALLERY_REQUEST);
            }
        });
        mpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();

            }
        });
    }
    private void startPosting(){

        mProgress.setMessage("uploading to database...");
        mProgress.show();
        final String title=mtitle.getText().toString().trim();
        final String desc=mdesc.getText().toString().trim();
        if(!TextUtils.isEmpty(title)&&!TextUtils.isEmpty(desc)&&imageuri!= null){
            StorageReference filepath=mStorage.child("plant1_image").child(imageuri.getLastPathSegment());
            filepath.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl=taskSnapshot.getDownloadUrl();

                    DatabaseReference mpost=mdatabase.push();
                    mpost.child("title").setValue(title);
                    mpost.child("desc").setValue(desc);
                    mpost.child("image").setValue(downloadUrl.toString());

                    startActivity(new Intent(PostActivity.this,MainActivity.class));
                    mProgress.dismiss();
                }
            });

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK){
            imageuri=data.getData();
            imageButton.setImageURI(imageuri);
        }
    }
}
