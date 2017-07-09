package zj.bannerdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import res.Images;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class WithPhotoDemo extends Activity {

    MZBannerView photo_banner = null;
    Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        photo_banner = (MZBannerView) findViewById(R.id.photo_banner);
        mContext = WithPhotoDemo.this;
        initBannerView(photo_banner);
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

        private PhotoView pho;

        public NetPicsHolder() {
            super();
        }

        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.photoview_banner_item, null);
            pho = (PhotoView) view.findViewById(R.id.banner_image);
            pho.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    onBackPressed();
                }
            });
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
                        .into(pho);
            }
        }
    }

}
