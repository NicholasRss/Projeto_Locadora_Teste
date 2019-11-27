package br.senac.go.data.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.senac.go.MainActivity;
import br.senac.go.R;

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {
    private final List<Carro> carroList;
    private final LayoutInflater layoutInflater;

    public CarroAdapter(MainActivity activity, List<Carro> carroList) {
        layoutInflater = activity.getLayoutInflater();
        this.carroList = carroList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_carro, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(carroList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return carroList.size();
    }

    public List<Carro> getCarroList() {
        return carroList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }

        public void bind(Carro carro, int position) {
            tv.setText(carro.getModelo() + " " + carro.getId());
        }
    }
}