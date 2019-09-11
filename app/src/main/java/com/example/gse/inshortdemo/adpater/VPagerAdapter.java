package com.example.gse.inshortdemo.adpater;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gse.inshortdemo.R;

/**
 *
 */
public class VPagerAdapter extends PagerAdapter
{
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private String mHeader[] = {"India had a point to prove against Australia, says Kohli after win",
            "The ICC has shared a video of India captain Virat Kohli"};

    private String mContents[] = {"India had a point to prove against Australia, says Kohli after win short by Anmol Sharma / 12:45 am on 10 Jun 2019,Monday Following India's 36-run victory against Australia, captain Virat Kohli has said India had a point to prove against Australia because of their recent defeats against the defending World Cup champions. \"We had a point to prove...We came here with intent right from ball one,\" he added. In March this year, Australia had won an ODI series 3-2 in India.",
            "The ICC has shared a video of India captain Virat Kohli asking spectators not to boo Australia batsman Steve Smith during their 2019 World Cup match at The Oval on Sunday. In the video, Kohli can be seen making a clapping gesture towards Indian supporters at the stadium's Vauxhall End, urging them to clap rather than boo the ex-Australia captain."};

    public VPagerAdapter(Context context)
    {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View itemView = null;
        try {
            itemView = mLayoutInflater.inflate(R.layout.view_pager_content_item, container, false);

            TextView header = itemView.findViewById(R.id.text_view_heading);
            TextView content = itemView.findViewById(R.id.text_view_content);
            ImageView imageView = itemView.findViewById(R.id.image_view);

            if (position % 2 == 0) {
                header.setText(mHeader[0]);
                content.setText(mContents[0]);
                imageView.setImageResource(R.drawable.news_one);
            } else {
                header.setText(mHeader[1]);
                content.setText(mContents[1]);
                imageView.setImageResource(R.drawable.news_two);
            }

            container.addView(itemView);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
