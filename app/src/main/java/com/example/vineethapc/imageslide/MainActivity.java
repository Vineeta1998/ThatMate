package com.example.vineethapc.imageslide;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.Timer;
import java.util.TimerTask;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private String[] urls = new String[]{"https://img1.exportersindia.com/product_images/bc-full/dir_100/2981720/vertical-wall-paper-1481773.jpg", "https://fsa.zobj.net/crop.php?r=qNi8z-DQS5QE2eUO1WLLYHdG2aG1ZDedHrPrKfp68g_ccDOjtSysIDpUpdF9P5qa9enyDgsBSjsmigJbpiJweyYqIRBfBXs9kmJ5KtzVs6_xrHcqxyJfjcqiYd9DBc6bxHH24PM_0tHKX33D-I2rAvyUkSqk-ETAQClhVK303O06RicfPmJBvV_mRsU","data:image/jpeg;base64,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"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, urls));
        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);

        NUM_PAGES = urls.length;

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;      //add the code for going to quiz page
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int pos) {
            }
        });
    }
}



