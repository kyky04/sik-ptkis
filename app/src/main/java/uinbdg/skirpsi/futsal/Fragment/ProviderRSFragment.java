package uinbdg.skirpsi.futsal.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import uinbdg.skirpsi.futsal.Adapter.AdapterRs;
import uinbdg.skirpsi.futsal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProviderRSFragment extends Fragment {

    @BindView(R.id.recycler_view_rs)
    RecyclerView recyclerViewRs;
    Unbinder unbinder;

    public ProviderRSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_provider_r, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
    recyclerViewRs.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerViewRs.setAdapter(new AdapterRs(getActivity()));
    recyclerViewRs.setHasFixedSize(true);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
