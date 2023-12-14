package com.example.demo.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeatDTO {
    private int id;
    private String name;
    private boolean isOccupied;

    public void setIsOccupied(boolean b) {
        this.isOccupied = b;
    }
    public boolean getIsOccupied() {
        return isOccupied;
    }
}
