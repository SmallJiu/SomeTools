package cat.jiu.util;

import java.io.*;

public class WriteFile {
	
	public static void writeString(String path, String utf) throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
			out.writeUTF(utf + System.getProperty("line.separator"));
			out.writeUTF(utf + System.getProperty("line.separator"));
			out.close();
	}
	
	public static void writeOreItemModel(String path, String utf1, String utf2) throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path, false)));
			out.writeUTF("{");
			out.writeUTF("\n\"parent\":\"item/generated\",");
			out.writeUTF("\n	\"textures\": {");
			out.writeUTF("\n		\"layer0\": \"jiu_tech:items/ore/" + utf1 + "/" + utf2 + "\"");
			out.writeUTF("\n	}");
			out.writeUTF("\n}");
			out.close();
	}
	
	public static void writeOreItemLang(String path, String name, int meta) throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path, true)));
			out.writeUTF("item.jiu_tech." + name + "." + meta + ".name=\n");
			out.close();
	}
}
