package uinbdg.skirpsi.futsal.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.R;

/**
 * Created by Comp on 2/11/2018.
 */

public class AdapterPertandingan extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItem> dataItemTeamList;

    @BindView(R.id.lay)
    LinearLayout lay;

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterPertandingan(Context ctx) {
        this.ctx = ctx;
    }

    public AdapterPertandingan(Context ctx, List<DataItem> dataItemTeamList) {
        this.dataItemTeamList = dataItemTeamList;
        this.ctx = ctx;
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name_home)
        TextView tvNameHome;
        @BindView(R.id.tv_name_away)
        TextView tvNameAway;
        @BindView(R.id.tv_base_home)
        TextView tvBaseHome;
        @BindView(R.id.tv_jadwal)
        TextView tvJadwal;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.lay)
        LinearLayout lay;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pertandingan, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            view.tvNameHome.setText(dataItemTeamList.get(position).getTeamHome().getNama());
            view.tvNameAway.setText(dataItemTeamList.get(position).getTeamAway().getNama());
            view.tvBaseHome.setText(dataItemTeamList.get(position).getTeamAway().getLapang().getNama());
            view.tvStatus.setText(dataItemTeamList.get(position).getStatus());

            view.lay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataItemTeamList.size();
    }

    @Override
    public long getItemId(int position) {
        return dataItemTeamList.get(position).getId();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }

}
