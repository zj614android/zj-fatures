package zj.bannerdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BaseLocalDemo extends Activity {

    public static final int []RES = new int[]{R.mipmap.image5,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image6,R.mipmap.image7,R.mipmap.image8};

    MZBannerView base_mzbanner_normal = null;
    MZBannerView base_mzbanner_auto_scroll = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_demo);

        base_mzbanner_normal = (MZBannerView) findViewById(R.id.base_mzbanner_normal);
        base_mzbanner_auto_scroll = (MZBannerView) findViewById(R.id.base_mzbanner_auto_scroll);
        initBannerView(base_mzbanner_normal);
        initBannerView(base_mzbanner_auto_scroll);


        
    }

    private void initBannerView(MZBannerView mMZBanner) {
        mMZBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(BaseLocalDemo.this,"click page:"+position,Toast.LENGTH_LONG).show();
            }
        });

        mMZBanner.setIndicatorRes(R.color.colorAccent,R.color.colorPrimary);


        List<Integer> list = new ArrayList<>();
        for(int i=0;i<RES.length;i++){
            list.add(RES[i]);
        }
        mMZBanner.setIndicatorVisible(false);
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        mMZBanner.setIndicatorVisible(true);
    }


    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }


    //这里看个人需求了 不设置这俩行是不会自动轮播的
    @Override
    protected void onResume() {
        super.onResume();
        base_mzbanner_normal.start();
        base_mzbanner_auto_scroll.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        base_mzbanner_normal.pause();
        base_mzbanner_auto_scroll.pause();
    }
}
