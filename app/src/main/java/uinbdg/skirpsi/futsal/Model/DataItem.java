package uinbdg.skirpsi.futsal.Model;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("team_home")
	private TeamHome teamHome;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_team_home")
	private int idTeamHome;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("id_team_away")
	private int idTeamAway;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("team_away")
	private TeamAway teamAway;

	@SerializedName("status")
	private String status;

	public void setTeamHome(TeamHome teamHome){
		this.teamHome = teamHome;
	}

	public TeamHome getTeamHome(){
		return teamHome;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdTeamHome(int idTeamHome){
		this.idTeamHome = idTeamHome;
	}

	public int getIdTeamHome(){
		return idTeamHome;
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

	public void setIdTeamAway(int idTeamAway){
		this.idTeamAway = idTeamAway;
	}

	public int getIdTeamAway(){
		return idTeamAway;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setTeamAway(TeamAway teamAway){
		this.teamAway = teamAway;
	}

	public TeamAway getTeamAway(){
		return teamAway;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"team_home = '" + teamHome + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",id_team_home = '" + idTeamHome + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",id_team_away = '" + idTeamAway + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",team_away = '" + teamAway + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}