package client.core;

import org.apache.commons.lang3.StringUtils;
import org.sikuli.script.Pattern;

public class DesktopElementCore extends Pattern{
	
	public DesktopElementCore(String imgPath){
		super(imgPath);
		StringUtils.capitalize(imgPath.split("/")[imgPath.split("/").length -2]);
	}
	
public void DesktopElementCore(){
		
	}

}
