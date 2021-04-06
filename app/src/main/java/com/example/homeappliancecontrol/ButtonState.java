package com.example.homeappliancecontrol;

public class ButtonState {

    public Integer B1;
    public Integer B2;
    public Integer B3;
    public Integer B4;
    public Integer B5;
    public Integer B6;
    public Integer B7;
    public Integer B8;

    public ButtonState() {

    }

    public  ButtonState(Integer B, Integer x) {
        if (x == 1)
            this.B1 = B;
        if (x == 2)
            this.B2 = B;
        if (x == 3)
            this.B3 = B;
        if (x == 4)
            this.B4 = B;
        if (x == 5)
            this.B5 = B;
        if (x == 6)
            this.B6 = B;
        if (x == 7)
            this.B7 = B;
        if (x == 8)
            this.B8 = B;
    }

    public ButtonState(Integer B1,Integer B2, Integer B3, Integer B4,
                       Integer B5,Integer B6, Integer B7, Integer B8) {
        this.B1 = B1;
        this.B2 = B2;
        this.B3 = B3;
        this.B4 = B4;
        this.B5 = B5;
        this.B6 = B6;
        this.B7 = B7;
        this.B8 = B8;
    }
}
