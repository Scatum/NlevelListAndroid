package com.twocentscode.nlevelexpandablelistview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    List<NLevelItem> list;
    ListView listView;
    public Gson gson = new GsonBuilder().setLenient().create();
    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://shamimediagroup.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<NLevelItem>();
        getVideoCategory();
        //here we create 5 grandparent (top level) NLevelItems
        //then foreach grandparent create a random number of parent (second level) NLevelItems
        //then foreach parent create a random number of children (third level) NLevelItems

        //we pass in an anonymous instance of NLevelView to the NLevelItem, this NLevelView is
        //what supplies the NLevelAdapter with a View for this NLevelItem


    }

    class SomeObject {
        public String name;

        public SomeObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public void doIt(CatalogRespons catalogRespons) {
        Random rng = new Random();
        final LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < 5; i++) {

            final NLevelItem grandParent = new NLevelItem(new SomeObject(catalogRespons.getErrorMsg()), null, new NLevelView() {

                @Override
                public View getView(NLevelItem item) {
                    View view = inflater.inflate(R.layout.list_item, null);
                    TextView tv = (TextView) view.findViewById(R.id.textView);
                    tv.setBackgroundColor(Color.GREEN);
                    String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                    tv.setText(name);
                    return view;
                }
            });
            list.add(grandParent);
            int numChildren = rng.nextInt(4) + 1;
            for (int j = 0; j < catalogRespons.getResArr().size(); j++) {
                NLevelItem parent = new NLevelItem(new SomeObject(catalogRespons.getResArr().get(j).getTitle()), grandParent, new NLevelView() {

                    @Override
                    public View getView(NLevelItem item) {
                        View view = inflater.inflate(R.layout.list_item, null);
                        TextView tv = (TextView) view.findViewById(R.id.textView);
                        tv.setBackgroundColor(Color.YELLOW);
                        String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                        tv.setText(name);
                        return view;
                    }
                });

                list.add(parent);
                int grandChildren = rng.nextInt(5) + 1;
                for (int k = 0; k < catalogRespons.getResArr().get(j).getSubCat().size(); k++) {
                    NLevelItem child = new NLevelItem(new SomeObject( catalogRespons.getResArr().get(j).getSubCat().get(k).getTitle()), parent, new NLevelView() {

                        @Override
                        public View getView(NLevelItem item) {
                            View view = inflater.inflate(R.layout.list_item, null);
                            TextView tv = (TextView) view.findViewById(R.id.textView);
                            tv.setBackgroundColor(Color.GRAY);
                            String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                            tv.setText(name);
                            return view;
                        }
                    });

                    list.add(child);
                }
            }
        }

        NLevelAdapter adapter = new NLevelAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ((NLevelAdapter) listView.getAdapter()).toggle(arg2);
                ((NLevelAdapter) listView.getAdapter()).getFilter().filter();

            }
        });
    }


    public void getVideoCategory() {

        Api apiRequest = retrofit.create(Api.class);
        Call<CatalogRespons> call = apiRequest.getVideoCategory();
        call.enqueue(new Callback<CatalogRespons>() {
            @Override
            public void onResponse(Call<CatalogRespons> call, retrofit2.Response<CatalogRespons> response) {
                Log.e("response ***getItemList", response.isSuccessful() + "***");

                if (response != null && response.body() != null) {
                    CatalogRespons itemListResponse = response.body();
                    doIt(itemListResponse);

                } else {
                }
            }

            @Override
            public void onFailure(Call<CatalogRespons> call, Throwable t) {
                if (t != null) {
                    Log.e("onFailure", t.getMessage());

                }
            }
        });
    }

}
