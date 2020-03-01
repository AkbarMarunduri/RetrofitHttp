package com.akbarprojec.retrofithttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PhotoAdaptor adaptor;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        GetService service = ApiClient.getRetrofitInstance().create(GetService.class);
        Call<List<PhotoData>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PhotoData>>() {
            @Override
            public void onResponse(Call<List<PhotoData>> call, Response<List<PhotoData>> response) {
                progressDialog.dismiss();
                generetDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoData>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Gagal loading",Toast.LENGTH_SHORT);
            }
        });
    }

    private void generetDataList(List<PhotoData> photoList){
        recyclerView=findViewById(R.id.photoViewList);
        adaptor=new PhotoAdaptor(photoList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptor);
    }
}
