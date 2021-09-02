package com.devsuperior.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor()
public class Payment {
  private static final Long serialVersionUID = 1L;

  private String name;
  private Double dailyIncome;
  private Integer days;

  public double getTotal() {
    return days * dailyIncome;
  }

}