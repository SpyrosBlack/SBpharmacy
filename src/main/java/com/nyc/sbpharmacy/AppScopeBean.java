package com.nyc.sbpharmacy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class AppScopeBean {
    private int numberofusers;





    public AppScopeBean() {
        numberofusers = 0;
    }

    public int getNumberofusers() {
        return numberofusers;
    }

    public void setNumberofusers(int numberofusers) {
        this.numberofusers = numberofusers;
    }
}
