package cat.jiu.util;

import java.io.*;

public class WriteFile {
	
	public static void writeString(String path, String utf) throws FileNotFoundException, IOException {
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path));
			out.write(utf + "\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void writeOreItemModel(String path, String utf1, String utf2) throws FileNotFoundException, IOException {
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path));
			out.write("{");
			out.write("\n\"parent\":\"item/generated\",");
			out.write("\n	\"textures\": {");
			out.write("\n		\"layer0\": \"jiu_tech:items/ore/" + utf1 + "/" + utf2 + "\"");
			out.write("\n	}");
			out.write("\n}");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void writeOreItemLang(String path, String name, int meta) {
		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path, true));
			out.write("item.jiu_tech." + name + "." + meta + ".name=\n");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
