package uinbdg.skirpsi.futsal.Model;

import com.google.gson.annotations.SerializedName;


public class DataItemTeam {

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("lapang")
	private Lapang lapang;

	@SerializedName("id")
	private int id;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_lapang")
	private int idLapang;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLapang(Lapang lapang){
		this.lapang = lapang;
	}

	public Lapang getLapang(){
		return lapang;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdLapang(int idLapang){
		this.idLapang = idLapang;
	}

	public int getIdLapang(){
		return idLapang;
	}

	@Override
 	public String toString(){
		return 
			"DataItemTeam{" +
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",lapang = '" + lapang + '\'' + 
			",id = '" + id + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_lapang = '" + idLapang + '\'' + 
			"}";
		}
}