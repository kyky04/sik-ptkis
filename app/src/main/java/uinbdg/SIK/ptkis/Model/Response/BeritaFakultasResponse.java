package uinbdg.SIK.ptkis.Model.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class BeritaFakultasResponse{

	@SerializedName("data")
	private List<DataItemBeritaFakultas> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemBeritaFakultas> data){
		this.data = data;
	}

	public List<DataItemBeritaFakultas> getData(){
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
			"BeritaFakultasResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}