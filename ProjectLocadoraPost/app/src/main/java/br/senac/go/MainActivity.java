package br.senac.go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import br.senac.go.data.model.Carro;
import br.senac.go.data.model.CarroAdapter;
import br.senac.go.data.repository.CarroRepository;
import br.senac.go.data.repository.source.CarroAPI;
import br.senac.go.data.repository.ICarroRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ICarroRepository carroRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv =findViewById(R.id.recycleView);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("teste.com.br").addConverterFactory(GsonConverterFactory.create()).build();
        CarroAPI carroAPI = retrofit.create(CarroAPI.class);
        carroRepository = new CarroRepository(carroAPI);
        final Carro carro =new Carro();
        carro.setModelo("Voyage");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carroRepository.createCarro(new ICarroRepository.Callback<Carro>() {
                    @Override
                    public void onResult(Carro result) {
                        Toast.makeText(MainActivity.this,"Salvo com Sucesso" + result.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(MainActivity.this,"Erro", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {
                        Toast.makeText(MainActivity.this,"Objeto Vazio", Toast.LENGTH_SHORT).show();
                    }
                }, carro);
            }
        });
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
                Log.e("mainAct", "Erro em carregar a lista", e);
            }

            @Override
            public void onEmpty() {
                rv.setAdapter(null);
            }
        });
    }
}
