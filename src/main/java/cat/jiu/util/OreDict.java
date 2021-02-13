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
			    String iod = oredict.getIngot() + oredict.getName();
			    String nod = oredict.getNugget() + oredict.getName();
			    String dod = oredict.getDust() + oredict.getName();
			    String sod = oredict.getStick() + oredict.getName();
			    String pod = oredict.getPlate() + oredict.getName();
			    String god = oredict.getGear() + oredict.getName();
		  	    String siod = oredict.getSingularity() + oredict.getName();
				
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
		
		ModOreListType modore = ModOreListType.values()[0];
		
		String iod = modore.getIngot();
		String nod = modore.getNugget();
		String dod = modore.getDust();
		String sod = modore.getStick();
		String pod = modore.getPlate();
		String god = modore.getGear();
		
		File idir = new File(path + iod);
		File ndir = new File(path + nod);
		File ddir = new File(path + dod);
		File sdir = new File(path + sod);
		File pdir = new File(path + pod);
		File gdir = new File(path + god);
		
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
			file.mkdir();
			for(ModOreListType ore : ModOreListType.values()){
				int meta = ore.getMeta();
				
				String ipath = idir + "/" + iod + "." + meta + ".json";
				String dpath = ddir + "/" + dod + "." + meta + ".json";
				String npath = ndir + "/" + nod + "." + meta + ".json";
				String gpath = gdir + "/" + god + "." + meta + ".json";
				String ppath = pdir + "/" + pod + "." + meta + ".json";
				String spath = sdir + "/" + sod + "." + meta + ".json";
				
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
				
				WriteFile.writeOreItemModel(ipath, iod, iod + "." + meta);
			  	WriteFile.writeOreItemModel(dpath, dod, dod + "." + meta);
			  	WriteFile.writeOreItemModel(npath, nod, nod + "." + meta);
			  	WriteFile.writeOreItemModel(gpath, god, god + "." + meta);
			  	WriteFile.writeOreItemModel(ppath, pod, pod + "." + meta);
			  	WriteFile.writeOreItemModel(spath, sod, sod + "." + meta);
			  	System.out.println("文件创建成功");
			}
		}else{
			for(ModOreListType ore : ModOreListType.values()){
				int meta = ore.getMeta();
				
				String ipath = idir + "/" + iod + "." + meta + ".json";
				String dpath = ddir + "/" + dod + "." + meta + ".json";
				String npath = ndir + "/" + nod + "." + meta + ".json";
				String gpath = gdir + "/" + god + "." + meta + ".json";
				String ppath = pdir + "/" + pod + "." + meta + ".json";
				String spath = sdir + "/" + sod + "." + meta + ".json";
				
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
				
				WriteFile.writeOreItemModel(ipath, iod, iod + "." + meta);
			  	WriteFile.writeOreItemModel(dpath, dod, dod + "." + meta);
			  	WriteFile.writeOreItemModel(npath, nod, nod + "." + meta);
			  	WriteFile.writeOreItemModel(gpath, god, god + "." + meta);
			  	WriteFile.writeOreItemModel(ppath, pod, pod + "." + meta);
			  	WriteFile.writeOreItemModel(spath, sod, sod + "." + meta);
			  	System.out.println("文件创建成功");
			}
		}
	}
		
	public static void writeOreDictName() throws FileNotFoundException, IOException {
		String path = "src/main/resources/assets/jiu_tech/lang/zh_cn.json";
		File file = new File(path);
			
		if(!file.isDirectory()) {
			file.createNewFile();
			for(ModOreListType oredict : ModOreListType.values()) {
				int meta = oredict.getMeta();
				String iod = oredict.getIngot();
				String nod = oredict.getNugget();
				String dod = oredict.getDust();
				String sod = oredict.getStick();
				String pod = oredict.getPlate();
				String god = oredict.getGear();
			  	String siod = oredict.getSingularity();
					
			  	WriteFile.writeOreItemLang(path, iod, meta);
			  	WriteFile.writeOreItemLang(path, nod, meta);
			  	WriteFile.writeOreItemLang(path, dod, meta);
			  	WriteFile.writeOreItemLang(path, sod, meta);
			  	WriteFile.writeOreItemLang(path, pod, meta);
			  	WriteFile.writeOreItemLang(path, god, meta);
			  	WriteFile.writeOreItemLang(path, siod,meta);
			  	System.out.println("写入成功");
			}
		}else {
			for(ModOreListType oredict : ModOreListType.values()) {
				int meta = oredict.getMeta();
				String iod = oredict.getIngot();
				String nod = oredict.getNugget();
				String dod = oredict.getDust();
				String sod = oredict.getStick();
				String pod = oredict.getPlate();
				String god = oredict.getGear();
				String siod = oredict.getSingularity();
					
			  	WriteFile.writeOreItemLang(path, iod, meta);
			  	WriteFile.writeOreItemLang(path, nod, meta);
			  	WriteFile.writeOreItemLang(path, dod, meta);
			  	WriteFile.writeOreItemLang(path, sod, meta);
			  	WriteFile.writeOreItemLang(path, pod, meta);
			  	WriteFile.writeOreItemLang(path, god, meta);
			  	WriteFile.writeOreItemLang(path, siod,meta);
			  	System.out.println("写入成功");
			}
		}
	}
}
