package uinbdg.skirpsi.futsal.Service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uinbdg.skirpsi.futsal.Model.AccessTokenRequest;
import uinbdg.skirpsi.futsal.Model.AccessTokenResponse;
import uinbdg.skirpsi.futsal.Model.DataItemPemain;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.JadwalResponse;
import uinbdg.skirpsi.futsal.Model.KompetisiResponse;
import uinbdg.skirpsi.futsal.Model.LapanganResponse;
import uinbdg.skirpsi.futsal.Model.PemainDetailResponse;
import uinbdg.skirpsi.futsal.Model.PemainResponse;
import uinbdg.skirpsi.futsal.Model.TeamDetailResponse;
import uinbdg.skirpsi.futsal.Model.TeamResponse;
import uinbdg.skirpsi.futsal.Model.UserResponse;

public interface FutsalApi {

    @POST("oauth/token")
    Call<AccessTokenResponse> getAccessToken(@Body AccessTokenRequest accessTokenRequest);

    @GET("api/user")
    Call<UserResponse> getUser(@Header("Authorization") String Authorization);


    @GET("api/jadwal")
    Call<JadwalResponse> getJadwal();

    @GET("api/lapangan")
    Call<LapanganResponse> getLapang();

    @GET("api/team")
    Call<TeamResponse> getTeam();

    @GET("api/teams-lapang/{id_lapang}")
    Call<TeamResponse> getTeamByLapang(@Path("id_lapang") int id_lapang);

    @GET("api/team/{id_team}")
    Call<TeamDetailResponse> getTim(@Path("id_team") int id_team);

    @GET("api/myteam/{id_user}")
    Call<TeamDetailResponse> getMyTim(@Path("id_user") int id_team);

    @GET("api/jadwal-team/{id_team}")
    Call<JadwalResponse> getJadwalByTeam(@Path("id_team") int id_team);

    @GET("api/pemain")
    Call<PemainResponse> getPemain();

    @GET("api/kompetisi")
    Call<KompetisiResponse> getKompetisi();

    @GET("api/pemain-team/{id_team}")
    Call<PemainResponse> getPemainByTeam(@Path("id_team") int id_team);

    @POST("api/team")
    Call<TeamDetailResponse> postTeam(@Body DataItemTeam team);

    @POST("api/pemain")
    Call<PemainDetailResponse> postPemain(@Body DataItemPemain pemain);

    @PATCH("api/pemain/{id}")
    Call<PemainDetailResponse> putPemain(@Path("id") int id, @Body DataItemPemain pemain);


}
