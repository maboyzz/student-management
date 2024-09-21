package com.edu.constants;

public enum EnumAcademicRanking {
    EXCELLENT("excellent"),
    GOOD("good"),
    FAIR("fair"),
    AVERAGE("average"),
    BELOW_AVERAGE("below average"),
    POOR("poor");

    private String description;
    EnumAcademicRanking(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
