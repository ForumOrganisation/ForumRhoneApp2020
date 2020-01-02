package in.tvac.akshayejh.firebasepushnotifications;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeHostActivity extends AppCompatActivity {

    private TextView mMissingLabel;
    private TextView mArrivedLabel;
    private TextView mEscortLabel;
    private TextView mWelcomedLabel;

    private ViewPager mMainPager;

    private WelcomePagerViewAdapter mWelcomePagerViewAdapter;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            sendToLogin();
        }
    }

    private void sendToLogin() {
        Intent loginIntent = new Intent(WelcomeHostActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_host);

        mAuth = FirebaseAuth.getInstance();

        mMissingLabel = (TextView) findViewById(R.id.missingLabel);
        mArrivedLabel = (TextView) findViewById(R.id.arrivedLabel);
        mEscortLabel = (TextView) findViewById(R.id.escortLabel);
        mWelcomedLabel = (TextView) findViewById(R.id.welcomedLabel);

        mMainPager = (ViewPager) findViewById(R.id.mainPager);
        mMainPager.setOffscreenPageLimit(2);

        mWelcomePagerViewAdapter = new WelcomePagerViewAdapter(getSupportFragmentManager());
        mMainPager.setAdapter(mWelcomePagerViewAdapter);

        mMissingLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(0);
            }
        });

        mArrivedLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(1);
            }
        });

        mEscortLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(2);
            }
        });

        mWelcomedLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainPager.setCurrentItem(3);
            }
        });

        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                changeTabs(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }

        });

    }

    private void changeTabs(int position) {

        if(position == 0){

            mMissingLabel.setTextColor(getColor(R.color.textTabBright));
            mMissingLabel.setTextSize(18);

            mArrivedLabel.setTextColor(getColor(R.color.textTabLight));
            mArrivedLabel.setTextSize(12);

            mEscortLabel.setTextColor(getColor(R.color.textTabLight));
            mEscortLabel.setTextSize(12);

            mWelcomedLabel.setTextColor(getColor(R.color.textTabLight));
            mWelcomedLabel.setTextSize(12);
        }

        if(position == 1){

            mMissingLabel.setTextColor(getColor(R.color.textTabLight));
            mMissingLabel.setTextSize(12);

            mArrivedLabel.setTextColor(getColor(R.color.textTabBright));
            mArrivedLabel.setTextSize(18);

            mEscortLabel.setTextColor(getColor(R.color.textTabLight));
            mEscortLabel.setTextSize(12);

            mWelcomedLabel.setTextColor(getColor(R.color.textTabLight));
            mWelcomedLabel.setTextSize(12);

        }

        if(position == 2){

            mMissingLabel.setTextColor(getColor(R.color.textTabLight));
            mMissingLabel.setTextSize(12);

            mArrivedLabel.setTextColor(getColor(R.color.textTabLight));
            mArrivedLabel.setTextSize(12);

            mEscortLabel.setTextColor(getColor(R.color.textTabBright));
            mEscortLabel.setTextSize(18);

            mWelcomedLabel.setTextColor(getColor(R.color.textTabLight));
            mWelcomedLabel.setTextSize(12);
        }

        if(position == 3){

            mMissingLabel.setTextColor(getColor(R.color.textTabLight));
            mMissingLabel.setTextSize(12);

            mArrivedLabel.setTextColor(getColor(R.color.textTabLight));
            mArrivedLabel.setTextSize(12);

            mEscortLabel.setTextColor(getColor(R.color.textTabLight));
            mEscortLabel.setTextSize(12);

            mWelcomedLabel.setTextColor(getColor(R.color.textTabBright));
            mWelcomedLabel.setTextSize(18);
        }



    }

}
