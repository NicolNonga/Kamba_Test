package com.example.nicodemos.kamba_test.Acitivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.nicodemos.kamba_test.Adapter.AdapterListView;
import com.example.nicodemos.kamba_test.DadosAPIModelo.KambaModel;
import com.example.nicodemos.kamba_test.DataService.DataService;
import com.example.nicodemos.kamba_test.R;

import java.util.ArrayList;
import java.util.List;

public class UserKambaTest extends AppCompatActivity {



    private  List<KambaModel> listKambaAPI= new ArrayList<>();
    private ListView listView;   // this is the listView variable
    private AdapterListView adapter;
    private ProgressBar progressBar;

    private static UserKambaTest userKambaTest;
    public static final String  EXTRA_ITEM_REFERENCE="REFERENCE"; // this that reference that enable us to get ShowUserKambaDitail method from other class

    // Now We create setter and getter of UserKmabaTest proprity so that the  may acess the ShowUserKambaDitail from other class

    public static UserKambaTest getUserKambaTest() {
        return userKambaTest;
    }

    public static void setUserKambaTest(UserKambaTest userKambaTest) {
        UserKambaTest.userKambaTest = userKambaTest;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_actidade);


           // now we weill first set UserKambaTest

        userKambaTest.setUserKambaTest(this);

        // set the progress Bar before we load that data from API
        progressBar= findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        // check if the data has been dowloaded from the API, if so  show The List
        KambaAPIDownloaded kambaAPIDownloaded= new KambaAPIDownloaded() {
            @Override
            public void sucess(Boolean sucess) {

                if (sucess){
                    progressBar.setVisibility(View.GONE);
                    SetUPListView();}

            }
        };
        SetUPListView();



        listKambaAPI= DataService.getInstance().DownloadKambaAPI(UserKambaTest.this,kambaAPIDownloaded);



    }



    public  void SetUPListView(){

        // this method get  listView and set it to Adpater

        listView = findViewById(R.id.listView);
        adapter= new AdapterListView(this, listKambaAPI);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    // we creat that Interface to shake when data has beem dowloand from Internet via API
    public interface KambaAPIDownloaded{

        void sucess(Boolean sucess);

    }

    // this method open a new intent and
    public  void ShowUserKambaDitail(KambaModel reference){

        Intent showuserkambadetail= new Intent(UserKambaTest.this, UserKambasMore.class);
        showuserkambadetail.putExtra(UserKambaTest.EXTRA_ITEM_REFERENCE,reference);
        startActivity(showuserkambadetail);
    }

}
