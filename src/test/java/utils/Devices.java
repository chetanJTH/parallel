package utils;

public enum Devices {

   // Oppo("4SB6QKOZVWZPSCPV","6.0"),
  //  Sony("RQ3006RCL6", "8.0"),
    moto("ZH33L2JWWT ","9");
   // Emulator("Pixel","9"),

  //  SamsungA8("RZ8M422FZJA", "8.0");

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String version;
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }


    Devices(String name, String version) {
        this.name = name;
        this.version = version;
    }
}
