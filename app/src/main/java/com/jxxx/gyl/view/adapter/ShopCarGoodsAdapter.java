package com.jxxx.gyl.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jxxx.gyl.MainActivity;
import com.jxxx.gyl.R;
import com.jxxx.gyl.api.HttpsUtils;
import com.jxxx.gyl.bean.ShoppingCartListBean;
import com.jxxx.gyl.utils.GlideImageLoader;
import com.jxxx.gyl.utils.view.AddandView;
import com.jxxx.gyl.view.fragment.HomeThreeFragment;

import java.util.List;

public class ShopCarGoodsAdapter extends BaseQuickAdapter<ShoppingCartListBean.ItemListBean, BaseViewHolder> {

    public ShopCarGoodsAdapter(List<ShoppingCartListBean.ItemListBean> data) {
        super(R.layout.item_shop_car_goodes, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartListBean.ItemListBean item) {
        GlideImageLoader.loadImageViewRadius(mContext,item.getCartSpuDTO().getIconUrl(),30,helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_name,item.getCartSpuDTO().getSpuName())
                .setVisible(R.id.iv_add,false).setVisible(R.id.tv_add,false).setVisible(R.id.add,true)
                .addOnClickListener(R.id.add)
                .setText(R.id.tv_type,item.getCartSpuDTO().getCartSkuDTO().getSkuName())
                .setText(R.id.tv_price,item.getCartSpuDTO().getCartSkuDTO().getSkuPriceDTO().getSkuPrice());
        AddandView mAddandView = helper.getView(R.id.add);
        mAddandView.setValue(Integer.valueOf(item.getCartSpuDTO().getCartSkuDTO().getSkuNum()));
        if(item.getCartSpuDTO().getSpuSupplyType().equals("1")){
            helper.setText(R.id.tv_spuSupplyType,"自营");
        }else if(item.getCartSpuDTO().getSpuSupplyType().equals("2")){
            helper.setText(R.id.tv_spuSupplyType,"供应商");
        }

        mAddandView.setOnNumberChangedListener(new AddandView.OnNumberChangedListener() {
            @Override
            public void OnNumberChanged(int vs, boolean isAdd) {
                if(isAdd){
                    HttpsUtils.userRechargeOrder(mContext, item.getCartSpuDTO().getCartSkuDTO().getId(),
                            item.getCartSpuDTO().getId(), new HttpsUtils.ShoppingCartInterface() {
                        @Override
                        public void isResult(Boolean isResult) {
                            if(isResult){
                                mAddandView.add();
                            }
                        }
                    });
                }else{
                    HttpsUtils.shoppingCartReduce(mContext, item.getCartSpuDTO().getCartSkuDTO().getId()
                            , item.getCartSpuDTO().getId(), new HttpsUtils.ShoppingCartInterface() {
                                @Override
                                public void isResult(Boolean isResult) {
                                    if(isResult){
                                        if(vs==1){
                                            ((MainActivity)mContext).updateUI();
                                        }
                                        mAddandView.jian();
                                    }
                                }
                            });
                }
            }
        });
    }

}
