package uinbdg.skirpsi.futsal.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private int latitude;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("team")
	private List<TeamItem> team;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("longitude")
	private int longitude;

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

	public void setLatitude(int latitude){
		this.latitude = latitude;
	}

	public int getLatitude(){
		return latitude;
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

	public void setTeam(List<TeamItem> team){
		this.team = team;
	}

	public List<TeamItem> getTeam(){
		return team;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setLongitude(int longitude){
		this.longitude = longitude;
	}

	public int getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",team = '" + team + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}