package zj.bannerdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import res.Images;

public class BaseNetDemo extends Activity {

    MZBannerView base_mzbanner_normal = null;
    MZBannerView base_mzbanner_auto_scroll = null;
    Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_demo);
        base_mzbanner_normal = (MZBannerView) findViewById(R.id.base_mzbanner_normal);
        base_mzbanner_auto_scroll = (MZBannerView) findViewById(R.id.base_mzbanner_auto_scroll);
        mContext = BaseNetDemo.this;
        initBannerView(base_mzbanner_normal);
        initBannerView(base_mzbanner_auto_scroll);
    }

    private void initBannerView(MZBannerView mMZBanner) {

        List<String> iamgeUrls = new ArrayList<>();

        for (int i = 0; i < Images.imageThumbUrls.length; i++) {
            iamgeUrls.add(Images.imageThumbUrls[i]);
        }

        mMZBanner.setPages(iamgeUrls, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new NetPicsHolder();
            }
        });

    }



    /**
     * 活动的bannerView的Holder
     */
    public class NetPicsHolder implements MZViewHolder<String> {

        private ImageView img;

        public NetPicsHolder() {
            super();
        }

        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            img = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, final int position, String picUrl) {
            // 数据绑定
            if (!TextUtils.isEmpty(picUrl)) {
                Glide.with(mContext)
                        .load(picUrl)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .centerCrop()
                        .crossFade()
                        .into(img);
            }
        }
    }

}
