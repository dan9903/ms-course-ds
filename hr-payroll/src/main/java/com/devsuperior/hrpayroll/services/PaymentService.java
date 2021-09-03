package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

  @Value("${hr-worker.host}")
  private String hrWorkerHost;

  @Autowired
  private RestTemplate restTemplate;

  public Payment getPayment(long workerId, int days) {
    Map<String, String> uriVariables = new HashMap<String, String>();
    uriVariables.put("id", Long.toString(workerId));
    String url = hrWorkerHost + "/workers/{id}";

    Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }

}