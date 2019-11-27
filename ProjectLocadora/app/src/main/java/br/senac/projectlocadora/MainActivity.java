package br.senac.projectlocadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.senac.projectlocadora.data.Model.Carro;
import br.senac.projectlocadora.data.repository.ICarroRepository;
import br.senac.projectlocadora.data.repository.source.CarroAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ICarroRepository carroRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerView);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.7:8181").addConverterFactory(GsonConverterFactory.create()).build();
        CarroAPI carroAPI = retrofit.create(CarroAPI.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        carroRepository.getAll(new ICarroRepository.Callback<List<Carro>>() {
            @Override
            public void onResult(List<Carro> result) {
                RecyclerView.Adapter adapter = new CarroAdapter(MainActivity.this, result);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rv.setAdapter(adapter);
            }

            @Override
            public void onError(Exception e) {
                Log.e("mainAct", "Erro em carregar lista", e);

            }

            @Override
            public void onEmpty() { rv.setAdapter(null);}
        });
    }

    private class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {
        private final List<Carro> carroList;
        private final LayoutInflater layoutInflater;

        private CarroAdapter(MainActivity activity, List<Carro> carroList) {
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

        private class ViewHolder extends RecyclerView.ViewHolder {

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
}

