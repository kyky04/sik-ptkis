package uinbdg.SIK.ptkis.Model.Response;

import com.google.gson.annotations.SerializedName;

public class DataItemJurusan {

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_fak")
	private int idFak;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_univ")
	private int idUniv;

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

	public void setIdFak(int idFak){
		this.idFak = idFak;
	}

	public int getIdFak(){
		return idFak;
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

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdUniv(int idUniv){
		this.idUniv = idUniv;
	}

	public int getIdUniv(){
		return idUniv;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJurusan{" +
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",id_fak = '" + idFak + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_univ = '" + idUniv + '\'' + 
			"}";
		}
}