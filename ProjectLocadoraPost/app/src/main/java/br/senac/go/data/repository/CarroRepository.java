package br.senac.go.data.repository;

import android.util.Log;

import java.util.List;

import br.senac.go.data.model.Carro;
import br.senac.go.data.repository.source.CarroAPI;
import retrofit2.Call;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CarroRepository implements ICarroRepository {

    private CarroAPI carroAPI;

    public CarroRepository(CarroAPI carroAPI) {
        this.carroAPI = carroAPI;
    }

    @Override
    public void getAll(final Callback<List<Carro>> callback) {
        carroAPI.getAll().enqueue(new retrofit2.Callback<List<Carro>>() {

            @Override
            public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Carro>> call, Throwable t) {
                Log.e(TAG, "Erro");
            }
        });

    }

    @Override
    public void createCarro(final Callback<Carro> callback, Carro carro) {
        carroAPI.createCarro(carro).enqueue(new retrofit2.Callback<Carro>() {
            @Override
            public void onResponse(Call<Carro> call, Response<Carro> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Carro> call, Throwable t) {

            }
        });

    }
}
