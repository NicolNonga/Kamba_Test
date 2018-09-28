package com.example.nicodemos.kamba_test.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.nicodemos.kamba_test.Acitivitys.UserKambaTest;
import com.example.nicodemos.kamba_test.DadosAPIModelo.KambaModel;
import com.example.nicodemos.kamba_test.R;

import java.util.List;

/**
 * Created by Nicodemos on 27/09/2018.
 */

public class AdapterListView extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<KambaModel> DataList;
    Context context;

    public AdapterListView(Activity activity, List<KambaModel> dataList) {
        this.activity = activity;
        DataList = dataList;

    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int position) {

        return  DataList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
               TextView holder_comany;
                TextView name_bank;
               TextView description_bank;
               Button detailUserKamba;

        if (inflater== null){

            inflater= (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null){

            convertView= inflater.inflate(R.layout.layout_user_kamba, null, false);

            final KambaModel modelReference=DataList.get(position);
            holder_comany=  convertView.findViewById(R.id.holder_company);
            name_bank= convertView.findViewById(R.id.name_bank);
            description_bank= convertView.findViewById(R.id.description_bank);
             KambaModel dataList= DataList.get(position);
            holder_comany.setText(dataList.getLastname());
            name_bank.setText(dataList.getFirst_name_to());
            description_bank.setText(dataList.getPhone_number());


            // get detail when user click to view more detail about payment

            detailUserKamba= convertView.findViewById(R.id.button_detail);
            detailUserKamba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    UserKambaTest.getUserKambaTest().ShowUserKambaDitail(modelReference);

                }
            });
        }
        return convertView;
    }
}
