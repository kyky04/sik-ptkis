package uinbdg.skirpsi.futsal.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import uinbdg.skirpsi.futsal.Fragment.ProviderDokterFragment;
import uinbdg.skirpsi.futsal.Fragment.ProviderKlinikFragment;
import uinbdg.skirpsi.futsal.Fragment.ProviderRSFragment;

/**
 * Created by pragmadev on 2/13/18.
 */

public class AdapterVpResultProvider extends FragmentPagerAdapter {
    public AdapterVpResultProvider(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProviderRSFragment rsFragment = new ProviderRSFragment();
                return rsFragment;
            case 1:
                ProviderKlinikFragment klinikFragment = new ProviderKlinikFragment();
                return klinikFragment;
            case 2:;
                ProviderDokterFragment dokterFragment = new ProviderDokterFragment();
                return dokterFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
