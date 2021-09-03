package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Worker implements Serializable {
  private static final Long serialVersionUID = 1L;

  private Long id;
  private String name;
  private Double dailyIncome;

}