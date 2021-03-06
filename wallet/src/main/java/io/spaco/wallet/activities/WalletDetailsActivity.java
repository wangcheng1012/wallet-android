package io.spaco.wallet.activities;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import io.spaco.wallet.R;
import io.spaco.wallet.activities.WalletDetails.WalletDetailsAdapter;
import io.spaco.wallet.activities.WalletDetails.WalletDetailsListener;
import io.spaco.wallet.base.BaseActivity;
import io.spaco.wallet.beans.WalletDetailsBean;
import io.spaco.wallet.utils.StatusBarUtils;
import io.spaco.wallet.utils.ToastUtils;
import io.spaco.wallet.widget.ShowQrDialog;

public class WalletDetailsActivity extends BaseActivity implements WalletDetailsListener {

    RecyclerView recyclerView;
    WalletDetailsAdapter walletDetailsAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_wallet_details;
    }

    @Override
    protected void initViews() {
        StatusBarUtils.statusBarCompat(this);
        recyclerView = findViewById(R.id.recyclerview);
        Toolbar toolbar = findViewById(R.id.id_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<WalletDetailsBean> walletDetailsBeans = new ArrayList<>();
        walletDetailsBeans.add(new WalletDetailsBean());
        walletDetailsBeans.add(new WalletDetailsBean());
        walletDetailsBeans.add(new WalletDetailsBean());
        walletDetailsAdapter = new WalletDetailsAdapter(walletDetailsBeans);
        walletDetailsAdapter.setWalletDetailsListener(this);
        recyclerView.setAdapter(walletDetailsAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onItemClick(int position, WalletDetailsBean bean) {
        ShowQrDialog showQrDialog = new ShowQrDialog(this);
        showQrDialog.setKey("http://www.baidu.com");
        showQrDialog.show();
    }

    @Override
    public void onCreateAddress() {
        ToastUtils.show("创建新地址");
    }
}
