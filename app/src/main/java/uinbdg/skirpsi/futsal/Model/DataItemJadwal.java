package uinbdg.skirpsi.futsal.Model;

import com.google.gson.annotations.SerializedName;


public class DataItemJadwal {

	@SerializedName("hari")
	private String hari;

	@SerializedName("id_team")
	private int idTeam;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("team")
	private Team team;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("lapang")
	private Team lapang;

	public void setHari(String hari){
		this.hari = hari;
	}

	public String getHari(){
		return hari;
	}

	public void setIdTeam(int idTeam){
		this.idTeam = idTeam;
	}

	public int getIdTeam(){
		return idTeam;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJadwal{" +
			"hari = '" + hari + '\'' + 
			",id_team = '" + idTeam + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",waktu = '" + waktu + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",team = '" + team + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}