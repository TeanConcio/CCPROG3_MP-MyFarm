package Model.Titles;

public class FarmerTitle {

    /* ----- ----- ----- FarmerTitle Attributes ----- ----- ----- */

    private int intTitleTier;
    private String strFarmerTitle;
    private float fltEXPReq;
    private float fltEarningBonus;
    private float fltSeedDiscount;
    private int intWaterLimInc;
    private int intFertLimInc;
    private float fltRegistrationFee;





    /* ----- ----- ----- FarmerTitle Constructor ----- ----- ----- */

    /**
     * FarmerTitle Constructor
     * - Creates a new FarmerTitle object.
     *
     * @param intTitleTier Tier of the FarmerTitle.
     * @param strFarmerTitle Name of the FarmerTitle.
     * @param fltEXPReq Level requirement of the FarmerTitle.
     * @param fltEarningBonus Earning bonus of the FarmerTitle.
     * @param fltSeedDiscount Seed discount of the FarmerTitle.
     * @param intWaterLimInc Water limit increase of the FarmerTitle.
     * @param intFertLimInc Fertilizer limit increase of the FarmerTitle.
     * @param fltRegistrationFee Registration fee of the FarmerTitle.
     */
    public FarmerTitle (int intTitleTier,
                        String strFarmerTitle,
                        float fltEXPReq,
                        float fltEarningBonus,
                        float fltSeedDiscount,
                        int intWaterLimInc,
                        int intFertLimInc,
                        float fltRegistrationFee) {

        this.intTitleTier = intTitleTier;
        this.strFarmerTitle = strFarmerTitle;
        this.fltEXPReq = fltEXPReq;
        this.fltEarningBonus = fltEarningBonus;
        this.fltSeedDiscount = fltSeedDiscount;
        this.intWaterLimInc = intWaterLimInc;
        this.intFertLimInc = intFertLimInc;
        this.fltRegistrationFee = fltRegistrationFee;
    }





    /* ----- ----- ----- FarmerTitle Methods ----- ----- ----- */





    /* ----- ----- ----- Getters and Setters ----- ----- ----- */

    public int getIntTitleTier() {return intTitleTier;}
    public void setIntTitleTier(int intTitleTier) {this.intTitleTier = intTitleTier;}

    public String getStrFarmerTitle() {return strFarmerTitle;}
    public void setStrFarmerTitle(String strFarmerTitle) {this.strFarmerTitle = strFarmerTitle;}

    public float getFltEXPReq() {return fltEXPReq;}
    public void setFltEXPReq(float fltEXPReq) {this.fltEXPReq = fltEXPReq;}

    public float getFltEarningBonus() {return fltEarningBonus;}
    public void setFltEarningBonus(float fltEarningBonus) {this.fltEarningBonus = fltEarningBonus;}

    public float getFltSeedDiscount() {return fltSeedDiscount;}
    public void setFltSeedDiscount(float fltSeedDiscount) {this.fltSeedDiscount = fltSeedDiscount;}

    public int getIntWaterLimInc() {return intWaterLimInc;}
    public void setIntWaterLimInc(int intWaterLimInc) {this.intWaterLimInc = intWaterLimInc;}

    public int getIntFertLimInc() {return intFertLimInc;}
    public void setIntFertLimInc(int intFertLimInc) {this.intFertLimInc = intFertLimInc;}

    public float getFltRegistrationFee() {return fltRegistrationFee;}
    public void setFltRegistrationFee(float intRegistrationFee) {this.fltRegistrationFee = intRegistrationFee;}
}
