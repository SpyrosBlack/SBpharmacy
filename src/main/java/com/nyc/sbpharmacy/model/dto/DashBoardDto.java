package com.nyc.sbpharmacy.model.dto;

public class DashBoardDto {

    private int totalorders;
    private float totalcostoforders;
    private int totalonlinepersons;
    private int totalmessages;

    public int getTotalorders() {
        return totalorders;
    }

    public void setTotalorders(int totalorders) {
        this.totalorders = totalorders;
    }

    public float getTotalcostoforders() {
        return totalcostoforders;
    }

    public void setTotalcostoforders(float totalcostoforders) {
        this.totalcostoforders = totalcostoforders;
    }

    public int getTotalonlinepersons() {
        return totalonlinepersons;
    }

    public void setTotalonlinepersons(int totalonlinepersons) {
        this.totalonlinepersons = totalonlinepersons;
    }

    public int getTotalmessages() {
        return totalmessages;
    }

    public void setTotalmessages(int totalmessages) {
        this.totalmessages = totalmessages;
    }
}
