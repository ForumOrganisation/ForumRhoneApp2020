package in.tvac.akshayejh.firebasepushnotifications;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class WelcomePagerViewAdapter  extends FragmentPagerAdapter {

    public WelcomePagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CompaniesFragment usersFragment0 = new CompaniesFragment();
                return usersFragment0;

            case 1:
                CompaniesFragment usersFragment1 = new CompaniesFragment();
                return usersFragment1;

            case 2:
                CompaniesFragment usersFragment2 = new CompaniesFragment();
                return  usersFragment2;

            case 3:
                CompaniesFragment usersFragment3 = new CompaniesFragment();
                return  usersFragment3;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 4;
    }

}
