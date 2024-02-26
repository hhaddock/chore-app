package com.atlas.menter.constant;

public enum ChoreType {
    KITCHEN("Kitchen"),
    BATHROOM("Bathroom"),
    BEDROOM("Bedroom"),
    LIVINGROOM("Living Room"),
    OFFICE("Office"),
    GARAGE("Garage"),
    YARD("Yard"),
    OTHER("Other");

    public final String label;

    private ChoreType(String label) {
        this.label = label;
    }
}
