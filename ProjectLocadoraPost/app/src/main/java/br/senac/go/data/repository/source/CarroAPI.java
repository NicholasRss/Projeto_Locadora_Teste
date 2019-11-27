package br.senac.go.data.repository.source;

import java.util.List;

import br.senac.go.data.model.Carro;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CarroAPI {

    @GET("/modelo")
    Call<List<Carro>> getAll();

    @POST("/modelo")
    Call<Carro> createCarro(@Body Carro carro);
}
