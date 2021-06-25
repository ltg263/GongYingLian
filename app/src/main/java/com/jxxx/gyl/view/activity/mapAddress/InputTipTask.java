package com.jxxx.gyl.view.activity.mapAddress;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;

import java.util.ArrayList;
import java.util.List;

public class InputTipTask implements Inputtips.InputtipsListener {

    private static InputTipTask mInstance;
    private Inputtips mInputTips;
    private Context mContext;
    private AutoCompleteTextView et;
    private List<LocationBean> dataLists = new ArrayList<>();

    private AdapterInputTips mInputTipsAdapter;

    private InputTipTask(Context context) {
        this.mContext = context;
    }

    //单例模式
    public static InputTipTask getInstance(Context context) {
        if (mInstance == null) {
            synchronized (InputTipTask.class) {
                if (mInstance == null) {
                    mInstance = new InputTipTask(context);
                }
            }
        }
        return mInstance;
    }

    public InputTipTask setAdapter(AutoCompleteTextView et) {
        this.et = et;
        return this;
    }

    public List<LocationBean> getBean() {
        return dataLists;
    }

    public void searchTips(String keyWord, String city) {
        //第二个参数默认代表全国，也可以为城市区号
        InputtipsQuery inputquery = new InputtipsQuery(keyWord, city);
        inputquery.setCityLimit(true);
        mInputTips = new Inputtips(mContext, inputquery);
        mInputTips.setInputtipsListener(this);
        mInputTips.requestInputtipsAsyn();
    }

    @Override
    public void onGetInputtips(final List<Tip> tipList, int rCode) {
        if (rCode == 1000) {
            ArrayList<String> datas = new ArrayList<>();
            if(tipList != null){
                dataLists.clear();
                for(Tip tip:tipList){
                    datas.add(tip.getName()+"\n"+tip.getDistrict()+tip.getAddress());
                    dataLists.add(new LocationBean(tip.getPoint().getLongitude(),tip.getPoint().getLatitude(),tip.getDistrict()+tip.getAddress(),tip.getName()));
                }
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_2,android.R.id.text1,datas);
            et.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
//            ArrayList<String> datas = new ArrayList<>();
//            if(tipList != null){
//                dataLists.clear();
//                for(Tip tip:tipList){
//                    datas.add(tip.getName());
//                    dataLists.add(new LocationBean(tip.getPoint().getLongitude(),tip.getPoint().getLatitude(),tip.getAddress(),tip.getName()));
//                }
//            }
//            List<HashMap<String,String>> searchList =new ArrayList<HashMap<String, String>>() ;
//            for (int i=0;i<tipList.size();i++) {
//                HashMap<String, String> hashMap = new HashMap<String, String>();
//                hashMap.put("name", tipList.get(i).getName());
//                hashMap.put("address", tipList.get(i).getDistrict()+tipList.get(i).getAddress());//将地址信息取出放入HashMap中
//                searchList.add(hashMap);//将HashMap放入表中
//            }
//            mInputTipsAdapter=new InputTipsAdapter(mContext);//新建一个适配器
//            //et.setAdapter(mInputTipsAdapter);//为listview适配
//            SimpleAdapter aAdapter = new SimpleAdapter(mContext, searchList, R.layout.search_list_item,
//                    new String[] {"name","address"}, new int[] {R.id.tv_detailAddress, R.id.tv_content});
//
//            et.setAdapter(aAdapter);
//            aAdapter.notifyDataSetChanged();




        }


    }
}