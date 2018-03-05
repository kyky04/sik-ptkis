package uinbdg.skirpsi.futsal.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import uinbdg.skirpsi.futsal.R;


/**
 * Created by pragmadev on 2/20/18.
 */

public class AdapterSpinnerString extends ArrayAdapter<String>{
    Context ctx;
    List<String> itemProvinsi;

    public AdapterSpinnerString(Context context, int resource, List objects) {
        super(context,  R.layout.item_provinsi, R.id.tv_nama_prov, objects);
        this.ctx = context;
        this.itemProvinsi = objects;
    }


    @Override
    public int getCount() {
        return itemProvinsi.size();
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_provinsi, parent, false);
        TextView textView = (TextView)row.findViewById(R.id.tv_nama_prov);
        textView.setText(itemProvinsi.get(position));
        return row;
    }
}
