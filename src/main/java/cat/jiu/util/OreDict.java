package cat.jiu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import cat.jiu.*;
import cat.jiu.init.ModOreListType;

public class OreDict {
	
	public static void oreList(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.println("=============");
		System.out.println("输入需要执行的程序id");
		System.out.println("0=返回主菜单");
		System.out.println("1=输出矿物词典");
		System.out.println("2=输出矿物lang");
		System.out.println("3=创建矿物model.json");
		System.out.println("4=把矿物lang输出到lang文件");
		System.out.println("=============");
		int i = input.nextInt();
		
		if(i == 0) {
			Main.main(args);
		}if(i == 1) {
			oreDict();
			oreList(args);
		}if(i == 2) {
			oreDictName();
			oreList(args);
		}if(i == 3) {
			OreDict.createModelFile();
			oreList(args);
		}if(i == 4) {
			OreDict.writeOreDictName();
			oreList(args);
		}else {
			System.out.println("");
			OreDict.oreList(args);
		}
	}
	
	
	public static void oreDict() {
		 for(ModOreListType oredict : ModOreListType.values()) {
			    int meta = oredict.getMeta();
			    String iod = oredict.getIngot() + oredict.getInitialsUpperCaseName();
			    String nod = oredict.getNugget() + oredict.getInitialsUpperCaseName();
			    String dod = oredict.getDust() + oredict.getInitialsUpperCaseName();
			    String sod = oredict.getStick() + oredict.getInitialsUpperCaseName();
			    String pod = oredict.getPlate() + oredict.getInitialsUpperCaseName();
			    String god = oredict.getGear() + oredict.getInitialsUpperCaseName();
		  	    String siod = oredict.getSingularity() + oredict.getInitialsUpperCaseName();
				
				System.out.println("OreDict：" + iod +"，Meta：" + meta);
				System.out.println("OreDict：" + nod +"，Meta：" + meta);
				System.out.println("OreDict：" + dod +"，Meta：" + meta);
				System.out.println("OreDict：" + sod +"，Meta：" + meta);
				System.out.println("OreDict：" + pod +"，Meta：" + meta);
				System.out.println("OreDict：" + god +"，Meta：" + meta);
				System.out.println("OreDict：" + siod +"，Meta：" + meta);
		    }
		}
		
	public static void oreDictName() {
		for(ModOreListType oredict : ModOreListType.values()) {
			int meta = oredict.getMeta();
			String name = "item.jiu_tech.ore_";
			String iod = oredict.getIngot();
			String nod = oredict.getNugget();
			String dod = oredict.getDust();
			String sod = oredict.getStick();
			String pod = oredict.getPlate();
			String god = oredict.getGear();
		  	String siod = oredict.getSingularity();
				
			System.out.println(name + iod + "." + meta + ".name=");
			System.out.println(name + nod + "." + meta + ".name=");
			System.out.println(name + dod + "." + meta + ".name=");
			System.out.println(name + sod + "." + meta + ".name=");
			System.out.println(name + pod + "." + meta + ".name=");
			System.out.println(name + god + "." + meta + ".name=");
			System.out.println(name + siod + "." + meta + ".name=");
		}
	}
	
	@SuppressWarnings("unused")
	public static void createModelFile() throws IOException, FileNotFoundException {
		// Scanner input = new Scanner(System.in);
		// System.out.println("方块还是物品？");
		// System.out.println("方块：block");
		// System.out.println("物品：item");
		
		
		String path = "src/main/resources/assets/jiu_tech/models/item/ore/";
		File file = new File(path);
		
		File idir = new File(path + "ingot");
		File ndir = new File(path + "nugget");
		File ddir = new File(path + "dust");
		File sdir = new File(path + "stick");
		File pdir = new File(path + "plate");
		File gdir = new File(path + "gear");
		
		if(!idir.isDirectory() && !ndir.isDirectory() && !ddir.isDirectory() && !sdir.isDirectory() && !pdir.isDirectory() && !gdir.isDirectory()) {
			for(ModOreListType ore : ModOreListType.values()) {
				idir.mkdir();
				ndir.mkdir();
				ddir.mkdir();
				sdir.mkdir();
				pdir.mkdir();
				gdir.mkdir();
			}
			System.out.println("创建文件夹完成\n");
		}
		
		if(!file.isDirectory()){
			file.mkdirs();
			for(ModOreListType ore : ModOreListType.values()){
				int meta = ore.getMeta();
				String name = ore.getAllLowerCaseName();
				
				String ipath = idir + "/" + name + "_ingot.json";
				String dpath = ddir + "/" + name + "_dust.json";
				String npath = ndir + "/" + name + "_nugget.json";
				String gpath = gdir + "/" + name + "_gear.json";
				String ppath = pdir + "/" + name + "_plate.json";
				String spath = sdir + "/" + name + "_stick.json";
				
				File ifile = new File(ipath);
				File dfile = new File(dpath);
				File nfile = new File(npath);
				File gfile = new File(gpath);
				File pfile = new File(ppath);
				File sfile = new File(spath);
				
				ifile.createNewFile();
				dfile.createNewFile();
				nfile.createNewFile();
				gfile.createNewFile();
				pfile.createNewFile();
				sfile.createNewFile();
				
				WriteFile.writeOreItemModel(ipath, "ingot", name + "_ingot");
			  	WriteFile.writeOreItemModel(dpath, "dust", name + "_dust");
			  	WriteFile.writeOreItemModel(npath, "nugget", name + "_nugget");
			  	WriteFile.writeOreItemModel(gpath, "gear", name + "_gear");
			  	WriteFile.writeOreItemModel(ppath, "plate", name + "_plate");
			  	WriteFile.writeOreItemModel(spath, "stick", name + "_stick");
			  	System.out.println("文件创建成功");
			}
		}else{
			for(ModOreListType ore : ModOreListType.values()){
				int meta = ore.getMeta();
				String name = ore.getAllLowerCaseName();
				
				String ipath = idir + "/" + name + "_ingot.json";
				String dpath = ddir + "/" + name + "_dust.json";
				String npath = ndir + "/" + name + "_nugget.json";
				String gpath = gdir + "/" + name + "_gear.json";
				String ppath = pdir + "/" + name + "_plate.json";
				String spath = sdir + "/" + name + "_stick.json";
				
				File ifile = new File(ipath);
				File dfile = new File(dpath);
				File nfile = new File(npath);
				File gfile = new File(gpath);
				File pfile = new File(ppath);
				File sfile = new File(spath);
				
				ifile.createNewFile();
				dfile.createNewFile();
				nfile.createNewFile();
				gfile.createNewFile();
				pfile.createNewFile();
				sfile.createNewFile();
				
				WriteFile.writeOreItemModel(ipath, "ingot", name + "_ingot");
			  	WriteFile.writeOreItemModel(dpath, "dust", name + "_dust");
			  	WriteFile.writeOreItemModel(npath, "nugget", name + "_nugget");
			  	WriteFile.writeOreItemModel(gpath, "gear", name + "_gear");
			  	WriteFile.writeOreItemModel(ppath, "plate", name + "_plate");
			  	WriteFile.writeOreItemModel(spath, "stick", name + "_stick");
			  	System.out.println("文件创建成功");
			}
		}
	}
		
	public static void writeOreDictName() throws FileNotFoundException, IOException {
		String path = "src/main/resources/assets/jiu_tech/lang";
		File file = new File(path);
		
		String filepath = path + "/zh_cn.json";
		File filepath1 = new File(filepath);
		
		if(!file.isDirectory()) {
			file.mkdirs();
			if(!filepath1.isDirectory()) {
				filepath1.createNewFile();
				for(ModOreListType oredict : ModOreListType.values()) {
					int meta = oredict.getMeta();
					
				  	WriteFile.writeOreItemLang(filepath, "ingot", meta);
				  	WriteFile.writeOreItemLang(filepath, "nugget", meta);
				  	WriteFile.writeOreItemLang(filepath, "dust", meta);
				  	WriteFile.writeOreItemLang(filepath, "stick", meta);
				  	WriteFile.writeOreItemLang(filepath, "plate", meta);
				  	WriteFile.writeOreItemLang(filepath, "gear", meta);
				  	WriteFile.writeOreItemLang(filepath, "singularity",meta);
				  	System.out.println("写入成功");
				}
			}else {
				for(ModOreListType oredict : ModOreListType.values()) {
					int meta = oredict.getMeta();
					
				  	WriteFile.writeOreItemLang(filepath, "ingot", meta);
				  	WriteFile.writeOreItemLang(filepath, "nugget", meta);
				  	WriteFile.writeOreItemLang(filepath, "dust", meta);
				  	WriteFile.writeOreItemLang(filepath, "stick", meta);
				  	WriteFile.writeOreItemLang(filepath, "plate", meta);
				  	WriteFile.writeOreItemLang(filepath, "gear", meta);
				  	WriteFile.writeOreItemLang(filepath, "singularity",meta);
				  	System.out.println("写入成功");
				}
			}
			
		}else {
			for(ModOreListType oredict : ModOreListType.values()) {
				int meta = oredict.getMeta();
					
				WriteFile.writeOreItemLang(filepath, "ingot", meta);
			  	WriteFile.writeOreItemLang(filepath, "nugget", meta);
			  	WriteFile.writeOreItemLang(filepath, "dust", meta);
			  	WriteFile.writeOreItemLang(filepath, "stick", meta);
			  	WriteFile.writeOreItemLang(filepath, "plate", meta);
			  	WriteFile.writeOreItemLang(filepath, "gear", meta);
			  	WriteFile.writeOreItemLang(filepath, "singularity",meta);
			  	System.out.println("写入成功");
			}
		}
	}
}
