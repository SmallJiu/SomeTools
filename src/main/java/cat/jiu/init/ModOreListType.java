package cat.jiu.init;

@SuppressWarnings("unused")
public enum ModOreListType{
	
	ORE_0     (0,  "Adamantium","adamantium",225,75,0),// 艾德曼合金
	ORE_1     (1,  "Antimony","antimony",200,25,0),// 锑
	ORE_2     (2,  "Bedrock","bedrock",000,000,000),// 基岩
	ORE_3     (3,  "Beryllium","beryllium",135,50,15),// 铍
	ORE_4     (4,  "Cesium","cesium",60,80,-45),// 铯
	ORE_5     (5,  "Chromium","chromium",315,75,45),// 铬
	ORE_6     (6,  "Germanium","germanium",55,5,0),// 锗
	ORE_7     (7,  "Indium","indium",220,20,0),// 铟
	ORE_8     (8,  "Iridium","iridium",185,100,55),// 铱
	ORE_9     (9,  "LightStar","light_star",000,000,000),// 光星
	ORE_10    (10, "Magnet","magnet",0,0,-55),// 磁铁
	ORE_11    (11, "Manganese","manganese",305,15,0),// 锰
	ORE_12    (12, "MentalInterdiction","mental_interdiction",000,000,000),// 心灵遮断合金
	ORE_13    (13, "MigenBusshitsu","migen_busshitsu",000,000,000),// 未元物质
	ORE_14    (14, "Monazite","monazite",55,25,25),// 独居石
	ORE_15    (15, "Rhenium","rhenium",75,65,0),// 铼
	ORE_16    (16, "Rutile","rutile",360,100,0),// 金红石
	ORE_17    (17, "Scandium","scandium",185,15,0),// 钪
	ORE_18    (18, "Star","star",000,000,000),// 星光辉
	ORE_19    (19, "TimeAndSpace","time_and_space",000,000,000),// 时间与空间
	ORE_20    (20, "Titanium","titanium",300,35,25),// 钛
	ORE_21    (21, "Tungsten","tungsten",0,0,-25),// 钨
	ORE_22    (22, "Vanadium","vanadium",195,15,-15),// 钒
	ORE_23    (23, "Vibranium","vibranium",0,75,0),// 振金
	ORE_24    (24, "WhiteDwarf","white_dwarf",000,000,000),// 白矮星
	ORE_25    (25, "Zinc","zinc",150,20,0),// 锌
	ORE_26    (26, "Zirconium","zirconium",190,80,35),// 锆
	ORE_27    (27, "Fantasy","fantasy",-000,-000,-000),// 幻想
	ORE_28    (28, "Corpus","corpus",25,100,-25),// 铜 Yep, is Warframe
	ORE_29    (29, "Tin","tin",195,50,50),// 锡
	ORE_30    (30, "Aluminium","aluminium",205,40,45),// 铝
	ORE_31    (31, "Silver","silver",200,100,45),// 银
	ORE_32    (32, "Nickel","nickel",40,40,25),// 镍
	ORE_33    (33, "Lead","lead",215,50,-45),// 铅
	ORE_34    (34, "Platinum","platinum",200,100,-10);// 铂
    
    private final int meta;
    private final String capsName;
    private final String lowerCaseName;
    private static final ModOreListType[] METADATA_LOOKUP = new ModOreListType[values().length];
	private final int h;
    private final int a;
    private final int i;
    
    ModOreListType(int meta, String capsName, String lowerCaseName, int h, int a, int i) {
        this.meta = meta;
        this.capsName = capsName;
        this.lowerCaseName = lowerCaseName;
        this.h = h;
        this.a = a;
        this.i = i;
    }
    
    public int getMeta() { 
    	return meta; 
    }
    
    // 获取小写名字格式化并加上meta值的名字
	public String getName() {
		return this.lowerCaseName + "_" + this.meta;
	}
    
    // 获取全大写字母的名字
    public String getAllUpperCaseName() {
    	return lowerCaseName.toUpperCase();
    }
    
    // 获取全小写字母的名字
    public String getAllLowerCaseName() { 
    	return lowerCaseName; 
    }
    
    // 获取首字母大写并格式化的名字
    public String getInitialsUpperCaseName() { 
    	return capsName; 
    }
    
    // 静态方法获取meta值对应的常量
    public static ModOreListType byMetadata(int meta) {
        return METADATA_LOOKUP[meta];
    }static {
        for (ModOreListType type : values()) {
            METADATA_LOOKUP[type.getMeta()] = type;
        }
    }
    
    public String getOre()  { return "ore"; }
    public String getIngot()  { return "ingot"; }
    public String getNugget() { return "nugget"; }
    public String getDust()   { return "dust"; }
    public String getStick()  { return "stick"; }
    public String getPlate()  { return "plate"; }
    public String getGear()   { return "gear"; }
    public String getSingularity() { return "singularity"; }
    
}
