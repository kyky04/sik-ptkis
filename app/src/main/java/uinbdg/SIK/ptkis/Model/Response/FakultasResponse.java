package uinbdg.SIK.ptkis.Model.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class FakultasResponse{

	@SerializedName("data")
	private List<DataItemFakultas> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemFakultas> data){
		this.data = data;
	}

	public List<DataItemFakultas> getData(){
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
			"FakultasResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}