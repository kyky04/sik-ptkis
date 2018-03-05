package uinbdg.skirpsi.futsal.Model;

import com.google.gson.annotations.SerializedName;


public class TeamDetailResponse {

	@SerializedName("data")
	private DataItemTeam data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public DataItemTeam getData() {
		return data;
	}

	public void setData(DataItemTeam data) {
		this.data = data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"TeamResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}