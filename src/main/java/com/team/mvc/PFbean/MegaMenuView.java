package com.team.mvc.PFbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "megaMenuView")
@SessionScoped
public class MegaMenuView {
    private String orientation = "vertical";

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
