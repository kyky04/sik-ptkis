package uinbdg.SIK.ptkis.Model.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class BeritaUniversitasResponse{

	@SerializedName("data")
	private List<DataItemBeritaUniverstas> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemBeritaUniverstas> data){
		this.data = data;
	}

	public List<DataItemBeritaUniverstas> getData(){
		return data;
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
			"BeritaUniversitasResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}