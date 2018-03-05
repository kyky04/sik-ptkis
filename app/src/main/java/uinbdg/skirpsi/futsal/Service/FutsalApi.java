package uinbdg.skirpsi.futsal.Service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uinbdg.skirpsi.futsal.Model.DataItemPemain;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.JadwalResponse;
import uinbdg.skirpsi.futsal.Model.KompetisiResponse;
import uinbdg.skirpsi.futsal.Model.LapanganResponse;
import uinbdg.skirpsi.futsal.Model.PemainDetailResponse;
import uinbdg.skirpsi.futsal.Model.PemainResponse;
import uinbdg.skirpsi.futsal.Model.TeamDetailResponse;
import uinbdg.skirpsi.futsal.Model.TeamResponse;

public interface FutsalApi {

    @GET("jadwal")
    Call<JadwalResponse> getJadwal();

    @GET("lapangan")
    Call<LapanganResponse> getLapang();

    @GET("team")
    Call<TeamResponse> getTeam();

    @GET("team/{id_team}")
    Call<TeamDetailResponse> getTim(@Path("id_team") int id_team);

    @GET("myteam/{id_user}")
    Call<TeamDetailResponse> getMyTim(@Path("id_user") int id_team);

    @GET("jadwal-team/{id_team}")
    Call<JadwalResponse> getJadwalByTeam(@Path("id_team") int id_team);

    @GET("pemain")
    Call<PemainResponse> getPemain();

    @GET("kompetisi")
    Call<KompetisiResponse> getKompetisi();

    @GET("pemain-team/{id_team}")
    Call<PemainResponse> getPemainByTeam(@Path("id_team") int id_team);

    @POST("team")
    Call<TeamDetailResponse> postTeam(@Body DataItemTeam team);

    @POST("pemain")
    Call<PemainDetailResponse> postPemain(@Body DataItemPemain pemain);

    @PATCH("pemain/{id}")
    Call<PemainDetailResponse> putPemain(@Path("id")int id,@Body DataItemPemain pemain);


}
