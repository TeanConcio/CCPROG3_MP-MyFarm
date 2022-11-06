public class FarmerTitle {

    /* ----- ----- ----- FarmerTitle Attributes ----- ----- ----- */

    private int intTitleTier;
    private String strFarmerTitle;
    private int intLevelReq;
    private float fltEarningBonus;
    private float fltSeedDiscount;
    private int intWaterLimInc;
    private int intFertLimInc;
    private int intRegistrationFee;





    /* ----- ----- ----- FarmerTitle Constructor ----- ----- ----- */

    /**
     * FarmerTitle Constructor
     * - Creates a new FarmerTitle object.
     *
     * @param intTitleTier Tier of the FarmerTitle.
     * @param strFarmerTitle Name of the FarmerTitle.
     * @param intLevelReq Level requirement of the FarmerTitle.
     * @param fltEarningBonus Earning bonus of the FarmerTitle.
     * @param fltSeedDiscount Seed discount of the FarmerTitle.
     * @param intWaterLimInc Water limit increase of the FarmerTitle.
     * @param intFertLimInc Fertilizer limit increase of the FarmerTitle.
     * @param intRegistrationFee Registration fee of the FarmerTitle.
     */
    public FarmerTitle (int intTitleTier,
                        String strFarmerTitle,
                        int intLevelReq,
                        float fltEarningBonus,
                        float fltSeedDiscount,
                        int intWaterLimInc,
                        int intFertLimInc,
                        int intRegistrationFee) {

        this.intTitleTier = intTitleTier;
        this.strFarmerTitle = strFarmerTitle;
        this.intLevelReq = intLevelReq;
        this.fltEarningBonus = fltEarningBonus;
        this.fltSeedDiscount = fltSeedDiscount;
        this.intWaterLimInc = intWaterLimInc;
        this.intFertLimInc = intFertLimInc;
        this.intRegistrationFee = intRegistrationFee;
    }





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public int getIntTitleTier() {return intTitleTier;}
    public void setIntTitleTier(int intTitleTier) {this.intTitleTier = intTitleTier;}

    public String getStrFarmerTitle() {return strFarmerTitle;}
    public void setStrFarmerTitle(String strFarmerTitle) {this.strFarmerTitle = strFarmerTitle;}

    public int getIntLevelReq() {return intLevelReq;}
    public void setIntLevelReq(int intLevelReq) {this.intLevelReq = intLevelReq;}

    public float getFltEarningBonus() {return fltEarningBonus;}
    public void setFltEarningBonus(float fltEarningBonus) {this.fltEarningBonus = fltEarningBonus;}

    public float getFltSeedDiscount() {return fltSeedDiscount;}
    public void setFltSeedDiscount(float fltSeedDiscount) {this.fltSeedDiscount = fltSeedDiscount;}

    public int getIntWaterLimInc() {return intWaterLimInc;}
    public void setIntWaterLimInc(int intWaterLimInc) {this.intWaterLimInc = intWaterLimInc;}

    public int getIntFertLimInc() {return intFertLimInc;}
    public void setIntFertLimInc(int intFertLimInc) {this.intFertLimInc = intFertLimInc;}

    public int getIntRegistrationFee() {return intRegistrationFee;}
    public void setIntRegistrationFee(int intRegistrationFee) {this.intRegistrationFee = intRegistrationFee;}
}
