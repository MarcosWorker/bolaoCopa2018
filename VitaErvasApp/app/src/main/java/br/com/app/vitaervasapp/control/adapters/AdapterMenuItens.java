package br.com.app.vitaervasapp.control.adapters;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.app.vitaervasapp.R;

/**
 * Created by marcos on 13/01/18.
 */

public class AdapterMenuItens extends RecyclerView.Adapter<AdapterMenuItens.ViewHolder>{

    private List<String> itensMenu;

    public AdapterMenuItens(List<String> itensMenu) {
        this.itensMenu = itensMenu;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.menu_itens_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String itemMenu = itensMenu.get(position);

        holder.tvMenuItem.setText(itemMenu);

    }

    @Override
    public int getItemCount() {
        return itensMenu.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMenuItem;

        public ViewHolder(View v) {
            super(v);
            tvMenuItem = (TextView) v.findViewById(R.id.tv_nome_menu_item);
        }

    }
}
