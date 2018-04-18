package uinbdg.SIK.ptkis.Service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uinbdg.SIK.ptkis.Model.Response.BeritaFakultasResponse;
import uinbdg.SIK.ptkis.Model.Response.BeritaJurusanResponse;
import uinbdg.SIK.ptkis.Model.Response.BeritaUniversitasResponse;
import uinbdg.SIK.ptkis.Model.Response.DataItemBeritaFakultas;
import uinbdg.SIK.ptkis.Model.Response.DataItemFakultas;
import uinbdg.SIK.ptkis.Model.Response.DataItemJurusan;
import uinbdg.SIK.ptkis.Model.Response.FakultasResponse;
import uinbdg.SIK.ptkis.Model.Response.JurusanResponse;
import uinbdg.SIK.ptkis.Model.Response.LoginResponse;
import uinbdg.SIK.ptkis.Model.Response.PendaftarResponse;
import uinbdg.SIK.ptkis.Model.Response.UniversitasResponse;

public interface PTKISApi {

    @GET("universitas")
    Call<UniversitasResponse> getUniversitas();

    @POST("fakultas-univ")
    Call<FakultasResponse> getFakultas(@Body DataItemFakultas itemFakultas);

    @POST("jurusan-univ")
    Call<JurusanResponse> getJurusan(@Body DataItemJurusan itemFakultas);

    @GET("berita-universitas/{id_univ}")
    Call<BeritaUniversitasResponse> getBeritaUniversitas(@Path("id_univ") int id_univ);

    @POST("berita-fakultas")
    Call<BeritaFakultasResponse> getBeritaFakultas(@Body DataItemBeritaFakultas itemFakultas);

    @POST("berita-jurusan")
    Call<BeritaJurusanResponse> getBeritaFakultas(@Body DataItemJurusan itemJurusan);

    @GET("beasiswas")
    Call<PendaftarResponse> getPendaftarBeasiswa();

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("email") String user_name, @Field("password") String password);

}
