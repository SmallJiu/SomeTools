package cat.jiu.init;

@SuppressWarnings("unused")
public enum ModOreListType {
	
	ORE_0     (0,  "Adamantium",225,75,0),
	ORE_1     (1,  "Antimony",200,25,0),
	ORE_2     (2,  "Bedrock",000,000,000),
	ORE_3     (3,  "Beryllium",135,50,15),
	ORE_4     (4,  "Cesium",60,80,-45),
	ORE_5     (5,  "Chromium",315,75,45),
	ORE_6     (6,  "Germanium",55,5,0),
	ORE_7     (7,  "Indium",220,20,0),
	ORE_8     (8,  "Iridium",185,100,55),
	ORE_9     (9,  "LightStar",000,000,000),
	ORE_10    (10, "Magnet",0,-100,-55),
	ORE_11    (11, "Manganese",305,15,0),
	ORE_12    (12, "MentalInterdiction",000,000,000),
	ORE_13    (13, "MigenBusshitsu",000,000,000),
	ORE_14    (14, "Monazite",55,25,25),
	ORE_15    (15, "Rhenium",75,65,0),
	ORE_16    (16, "Rutile",360,100,0),
	ORE_17    (17, "Scandium",185,15,0),
	ORE_18    (18, "Star",000,000,000),
	ORE_19    (19, "TimeAndSpace",000,000,000),
	ORE_20    (20, "Titanium",300,35,25),
	ORE_21    (21, "Tungsten",0,0,-25),
	ORE_22    (22, "Vanadium",195,15,-15),
	ORE_23    (23, "Vibranium",0,75,0),
	ORE_24    (24, "WhiteDwarf",000,000,000),
	ORE_25    (25, "Zinc",150,20,0),
	ORE_26    (26, "Zirconium",190,80,35),
	ORE_27    (27, "Fantasy",-000,-000,-000);
    
    private final int meta;
    private final String name;
	private final int h;
    private final int a;
    private final int i;
    
    ModOreListType(int meta, String name, int h, int a, int i) {
        this.meta = meta;
        this.name = name;
        this.h = h;
        this.a = a;
        this.i = i;
    }
    
    public int getMeta() { 
    	return meta; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public String getBlock() { return "block"; }
    public String getIngot() { return "ingot"; }
    public String getNugget() { return "nugget"; }
    public String getDust() { return "dust"; }
    public String getStick() { return "stick"; }
    public String getPlate() { return "plate"; }
    public String getGear() { return "gear"; }
    public String getSingularity() { return "singularity"; }
}
