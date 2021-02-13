package cat.jiu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ConsoleCommand {
	
	public static void useLinuxCommand(String commandPath) {
        try {
            Process p = Runtime.getRuntime().exec(commandPath);  //调用Linux的相关命令

            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);      //创建IO管道，准备输出命令执行后的显示内容

            String line;
            while ((line = input.readLine()) != null) {     //按行打印输出内容
                System.out.println(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
	
/*
*	sourcePath 项目文件路径
*/	
	public static String useCMDCommand(String commandPath) {
  		InputStream error = null;
  		try {
  			StringBuffer command = new StringBuffer();
  				command.append("cmd /c d: ");
  				//这里的&&在多条语句的情况下使用，表示等上一条语句执行成功后在执行下一条命令，
  				//也可以使用&表示执行上一条后台就立刻执行下一条语句
  				command.append(String.format(" && cd %s", commandPath));
  				command.append(" && mvn -Dmaven.test.skip=true package");
  			Process p = Runtime.getRuntime().exec(command.toString());
  				error = p.getErrorStream();
  			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(error));
  			StringBuffer buffer = new StringBuffer();
  			String s = "";
  			while ((s = bufferedReader.readLine()) != null) {
  				buffer.append(s);
  			}
  				bufferedReader.close();
  				p.waitFor();
  			if (p.exitValue() != 0) {
  				return buffer.toString();
  			} else {
  				return "";
  			}
  		} catch (Exception ex) {
  			if (error != null) {
  				try {
  					error.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
  			return ex.getMessage();
  		}
	}
}
