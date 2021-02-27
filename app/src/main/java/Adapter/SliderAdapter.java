package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shahbatech.apiwrapper.model.NewsImage;
import com.shahbatech.lasirene.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

import Utilities.Helper.ImageProcessing;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<NewsImage> mSliderItems = new ArrayList<>();
    private ImageProcessing mImageProcessing;


    public SliderAdapter(Context context) {
        this.context = context;
        mImageProcessing = new ImageProcessing(context);

    }

    public void renewItems(List<NewsImage> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        NewsImage item = mSliderItems.get(position);

        if (!item.getImage().equals(""))
            mImageProcessing.load(viewHolder.imageViewBackground, item.getImage());

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }

}
