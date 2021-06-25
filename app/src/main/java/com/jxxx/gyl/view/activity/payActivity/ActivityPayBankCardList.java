package com.jxxx.gyl.view.activity.payActivity;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jxxx.gyl.R;
import com.jxxx.gyl.base.BaseActivity;
import com.jxxx.gyl.utils.DialogUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ActivityPayBankCardList extends BaseActivity {


    @BindView(R.id.include)
    Toolbar myToolbar;
    @BindView(R.id.cardRv)
    RecyclerView cardRv;

    AdapterPayBankCardList adapter;
    //    List<BankCardBean.ListBean> listBeans = new ArrayList<>();
    boolean isSelect = false;

    @Override
    public int intiLayout() {
        return R.layout.activity_pay_bank_card_list;
    }

    @Override
    public void initView() {

        setToolbar(myToolbar, "银行卡管理");

        isSelect = getIntent().getBooleanExtra("isSelect",false);
        adapter = new AdapterPayBankCardList(null);
        cardRv.setAdapter(adapter);
        if (isSelect) {
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(ActivityPayBankCardList.this, ActivityPayBankCardAdd.class);
                    intent.putExtra("item", ActivityPayBankCardList.this.adapter.getData().get(position));
                    setResult(2,intent);
                    finish();
                }
            });
        } else {
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                    Intent intent = new Intent(BankCardManageActivity.this, AddBankCardActivity.class);
//                    intent.putExtra("isUpdate", true);
//                    intent.putExtra("id", BankCardManageActivity.this.adapter.getData().get(position).getId());
//                    startActivity(intent);
                }
            });
        }

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
                if(view.getId()==R.id.iv_mr){
//                    if(BankCardManageActivity.this.adapter.getData().get(position).getStatus()==1){
//                        return;
//                    }
//                    BankCardRequest request = new BankCardRequest();
//                    request.setId(BankCardManageActivity.this.adapter.getData().get(position).getId());
//                    request.setStatus(1);
//
//                    RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),new Gson().toJson(request));
//                    RetrofitManager.build().create(UserService.class).addCardUpdatestatus(body)
//                            .compose(RxScheduler.observeOnMainThread())
//                            .as(RxScheduler.bindLifecycle(BankCardManageActivity.this))
//                            .subscribe(new BaseObserver() {
//                                @Override
//                                public void onSuccess(Object str) {
//                                    aaa();
//                                    ToastUtils.showShort("修改成功");
//                                }
//                            });
                    return;
                }
                DialogUtils.showDialogHint(ActivityPayBankCardList.this, "删除银行卡将无法恢复，确认删除吗",
                        false, () -> {
//                            RetrofitManager.build().create(UserService.class).deleteCard(
//                                    BankCardManageActivity.this.adapter.getData().get(position).getId())
//                                    .compose(RxScheduler.observeOnMainThread())
//                                    .as(RxScheduler.bindLifecycle(BankCardManageActivity.this))
//                                    .subscribe(new BaseObserver() {
//                                        @Override
//                                        public void onSuccess(Object str) {
//                                            BankCardManageActivity.this.adapter.remove(position);
//                                            BankCardManageActivity.this.adapter.notifyDataSetChanged();
//                                            ToastUtils.showShort("删除成功");
//                                        }
//                                    });
                        });


            }
        });
    }

    @Override
    public void initData() {
    }

    @OnClick(R.id.addBankCard)
    public void onViewClicked() {
        baseStartActivity(ActivityPayBankCardAdd.class,null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        aaa();
//
//                .subscribe(new BaseObserver<BankCardBean>() {
//                    @Override
//                    public void onHandleSuccess(BaseData<BankCardBean> t) throws Exception {
//                        listBeans = t.getData().getList();
//                        adapter.setNewData(listBeans);
//                    }
//                });
    }

    private void aaa() {

//        RetrofitManager.build().create(UserService.class).getBankCard()
//                .compose(RxScheduler.observeOnMainThread())
//                .as(RxScheduler.bindLifecycle(this))
//                .subscribe(new BaseObserver<AccountLists>() {
//                    @Override
//                    public void onSuccess(AccountLists emptyResponse) {
//                        adapter.setNewData(emptyResponse.getList());
//                    }
//                });
    }
}
